/** 
*  @file StrategyGameMode.java
*  @author Shazil Arif
*  @brief StrategyGameMode defines a generic algorithm for playing a Strategy/game mode for TwoDots
*  @date April 2nd 2020
*/


/** 
* @brief Strategy is an interface for defining a family of game modes for Two Dots
* @details implements the Strategy interface
*/

class MovesStrategy extends StrategyGameMode{

	private int move_count;
	private int TARGET;
	
	@Override
	/**
	 * @brief condition to check if game can still be continued
	 * @return boolean indicating whether game can be continued
	 */
	boolean canContinue() {
		return move_count > 0;
	}

	@Override
	/**
	 * @brief check winning conditions for moves strategy game mode
	 * @return if 5 or more dots eliminated in one move 
	 */
	boolean checkWin() {
		if(moves.size()>=TARGET) return true;
		else {
			move_count--;
			return false;
		}
	}

	@Override
	/**
	 * @brief display an intro message and brief information on how to play the game mode
	 */
	void introMsg() {
		c.printMsg(String.format("This is the mode with %d moves",move_count));
		c.printMsg(String.format("You win by eliminating %d or more dots in one move",TARGET));
		c.printMsg("Enter a sequence of x,y pairs seperate by spaces");
		c.printMsg("Example: 1,2 4,5 5,5");
	}

	@Override
	/**
	 * @brief update view to indicate amount of score left
	 * @details if the number of moves has ran out then the game exits with exit code 0
	 */
	void updateData() {
		if(move_count == 0) {
			c.printMsg(String.format("The game ended! You ran out of moves"));
			System.exit(0);
		}
		c.printMsg(String.format("Moves left: %d", move_count));
	}

	@Override
	/**
	 * @brief set up global variables at beginning of game. 
	 */
	void startUp(TwoDotsBoard b) {
		v = new BoardView();
		c = new BoardController(b,v);
		move_count = 15;
		TARGET = 5;
	}
	
	@Override
	/**
	 * @brief indicate to the user they have won and the reason 
	 */
	void endMsg() {
		c.printMsg(String.format("You won by eliminating %d dots in one move!", TARGET));
	}

}