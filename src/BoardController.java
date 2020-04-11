/**
*  @file BoardController.java
*  @author Shazil Arif
*  @brief BoardController is a module used to interact with a TwoDotsBoard and a BoardView object
*  @date April 2nd 2020
*/

/**
 * @brief controller for TwoDotsBoard and a BoardView object
 */
public class BoardController {
	private TwoDotsBoard model;
	private BoardView view;
	
	/**
	 * @brief constructor for BoardController
	 * @param model the TwoDotsBoard object to control, interact with
	 * @param view the view object to interact with
	 */
	public BoardController(TwoDotsBoard model, BoardView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * @brief get the color at a specific point for a TwoDotsBoard object
	 * @param p The point to get the color at
	 * @return the Color at point p
	 */
	public Color get(PointT p) {
		return model.get(p);
	}
	
	/**
	 * @brief set a color at a specific point for a TwoDotsBoard object
	 * @param p The point to set the color at
	 * @param c the color to set
	 */
	public void set(PointT p, Color c) {
		model.set(p, c);
	}
	
	/**
	 * @brief validate a sequence of input moves for a TwoDotsBoard
	 * @details see validateMoves in TwoDotsBoard for more information
	 * @param moves the sequence of moves to validate
	 * @return boolean indicating is the given sequence is valid
	 */
	public boolean validateMoves(BoardMoves moves) {
		return model.validateMoves(moves);
	}
	
	/**
	 * @brief update a TwoDotsBoard after eliminating a sequence of dots
	 * @details See updateBoard in TwoDotsBoard for more information
	 * @param moves containing the sequence of dots to eliminate
	 */
	public void updateBoard(BoardMoves moves) {
		model.updateBoard(moves);
	}
	
	
	/**
	 * @brief print out to standard output the current state of a TwoDotsBoard
	 */
	public void updateView() {
		view.printBoard(model);
	}
	
	/**
	 * @brief print out to standard input a string
	 * @param msg the string to print out
	 */
	public void printMsg(String msg) {
		view.printMsg(msg);
	}
	
	/**
	 * @brief get a playable game mode of choice from the user through the standard input via a prompt
	 * @details see modePrompt() in BoardView.java for more information
	 * @return the game mode the user wants to play
	 */
	public Strategy modePrompt() {
		return view.modePrompt();
	}
	
	
	/**
	 * @brief close the input stream from the standard input
	 * @details Note: this is not specific to a specific instance of a BoardController object and will close the stream globally, use carefully
	 */
	public void closeViewStream() {
		view.closeStream();
	}
	
	/**
	 * @brief get a input sequence of dots to eliminate on a TwoDotsBoard from the user via the standard input
	 * @return a sequence containing the points indicated by the user
	 */
	public BoardMoves getInput() {
		BoardMoves b = view.getInput();
		while(!model.validateMoves(b)) {
			printMsg("Invalid combination of board moves. Please Re try");
			b = view.getInput();
		}
		return b;
	}
	

}
