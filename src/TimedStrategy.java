/** 
*  @file TimedStrategy.java
*  @author Shazil Arif
*  @brief TimedStrategy is the timed game mode for TwoDots 
*  @date April 2nd 2020
*/


/**
 * @brief 
 * @details extends StrategyGameMode to implement a customizable game play. Note that in this game mode the user has a set amount of time.
 * if the time runs out while the user is typing in a set of dots to eliminate, they are allowed to finish inputting the set of dots to eliminate
 * if this input results in a win, the user wins otherwise the game ends 
 */
public class TimedStrategy extends StrategyGameMode{

	//state variables
	private int TARGET;
	private int TIME;
	private final long BILLION = 1000000000;
	private long start;
	
	
	@Override
	/**
	 * @brief check winning condition for gaming
	 * @return if 5 or more dots have been eliminated in one move 
	 */
	boolean checkWin() {
		if(moves.size()==TARGET) return true;
		return false;
	}

	@Override
	/**
	 * @brief check if game can still be continued. 
	 * @details checks if timer has been cancelled or not
	 * @return if the timer has been cancelled or not
	 */
	boolean canContinue() {
		return CountDownTimer.isCancelled();
	}

	@Override
    /**
	* @brief update view to indicate time elapsed since start of game
	*/
	void updateData() {
		long now = (System.nanoTime() - start)/BILLION;
		c.printMsg(String.format("Time elapsed: %d seconds",now));
	}

	@Override
	/**
	 * @brief display an introduction message and brief information on how to play the game mode
	 */
	void introMsg() {
		c.printMsg(String.format("This is the mode with %d seconds",TIME));
		c.printMsg(String.format("You win by eliminating %d dots in one move",TARGET));
		c.printMsg("Enter a sequence of x,y pairs seperate by spaces");
		c.printMsg("Example: 1,2 4,5 5,5");
	}

	@Override
	/**
	 * @brief set up global variables at beginning of game
	 */
	void startUp(TwoDotsBoard b) {
		TARGET = 5;
		TIME = 60;
		v = new BoardView();
		c = new BoardController(b,v);
		start = System.nanoTime();
		CountDownTimer.newTimer(TIME);
	}
	
	@Override
	/**
	 * @brief indicate to the user they have won and the reason 
	 */
	void endMsg() {
		c.printMsg(String.format("You won by eliminating %d dots in one move!", TARGET));
	}
}
