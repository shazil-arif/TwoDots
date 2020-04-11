/** 
*  @file Dots.java
*  @author Shazil Arif
*  @brief Dots contains the main client code to start a game of TwoDots
*  @date April 1st 2020
*/
public class Dots {
	/**
	 * @brief main code to instantiate a controller and start a game mode strategy
	 * @details this method should be run to play the game using the given makefile with rule 'make dots'
	 */
	public static void main(String[] args) {
		TwoDotsBoard b = new TwoDotsBoard(6,6);
		BoardView v = new BoardView();
		BoardController c = new BoardController(b,v);
		c.printMsg("Welcome to Two Dots!\n");
		c.printMsg("You can choose between the timed mode or the mode that lasts 30 moves");
		Strategy mode = c.modePrompt();
		mode.play(b);
		c.printMsg("The game ended");
	}
	

}
