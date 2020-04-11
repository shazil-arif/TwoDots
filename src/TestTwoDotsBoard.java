/** 
*  @file TestTwoDotsBoard.java
*  @author Shazil Arif
*  @brief TestTwoDotsBoard is used to test module TwoDotsBoard
*  @date April 6th
*/

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestTwoDotsBoard {
	
	TwoDotsBoard b;
	ArrayList<ArrayList<Color>> s;

	
	@Before
	public void SetUp() {
		s = new ArrayList<ArrayList<Color>>();
		
		//note that there is a valid path at the top left with the 3 red dots
		s.add(new ArrayList<Color>(Arrays.asList(Color.R,Color.G,Color.R,Color.G,Color.R,Color.B)));
		s.add(new ArrayList<Color>(Arrays.asList(Color.R,Color.R,Color.G,Color.B,Color.G,Color.P)));
		s.add(new ArrayList<Color>(Arrays.asList(Color.B,Color.Y,Color.B,Color.B,Color.Y,Color.B)));
		s.add(new ArrayList<Color>(Arrays.asList(Color.Y,Color.G,Color.Y,Color.B,Color.B,Color.G)));
		s.add(new ArrayList<Color>(Arrays.asList(Color.P,Color.B,Color.P,Color.Y,Color.G,Color.Y)));
		s.add(new ArrayList<Color>(Arrays.asList(Color.R,Color.P,Color.P,Color.P,Color.P,Color.R)));
		b = new TwoDotsBoard(6,6);
		for(int i = 0; i < s.size(); i++) {
			for(int j = 0; j < s.get(i).size(); j++) {
				b.set(new PointT(i,j), s.get(i).get(j));
			}
		}
	}
	
	//test constructor exceptions
	@Test(expected=IllegalArgumentException.class)
	public void testBoardExceptionForZeroRow() {
		new TwoDotsBoard(0,1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testBoardExceptionForNegativeRow() {
		new TwoDotsBoard(-1,1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testBoardExceptionForZeroCol() {
		new TwoDotsBoard(1,0);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testBoardExceptionForNegativeCol() {
		new TwoDotsBoard(1,-1);
	}
	
	//test getter and setter methods
	@Test
	public void testGet() {
		assertTrue(b.get(new PointT(0,0)) == Color.R);
	}
	@Test
	public void testSet() {
		b.set(new PointT(0,5),Color.G);
		assertTrue(b.get(new PointT(0,5)) == Color.G);
	}
	
	@Test
	public void testgetNumCol() {
		assertTrue(b.getNumCol()== s.get(0).size());
	}
	
	@Test 
	public void testgetNumRow() { 
		assertTrue(b.getNumRow() == s.size());
	}
	
	
	//test validate moves with different inputs
	@Test
	public void testValidateMovesForSequenceSizeLessThanOne() {
		TwoDotsBoard board = new TwoDotsBoard(6,6);
		BoardMoves moves = new BoardMoves();
		assertTrue(!board.validateMoves(moves));	
	}
	
	@Test 
	public void testValidateMovesForSequenceSizeEqualOne() {
		TwoDotsBoard board = new TwoDotsBoard(6,6);
		BoardMoves moves = new BoardMoves();
		moves.add(new PointT(1,1));
		assertTrue(!board.validateMoves(moves));	
	}
	
	@Test 
	public void testValidateMovesWithInvalidPoints() {
		TwoDotsBoard board = new TwoDotsBoard(6,6);
		BoardMoves moves = new BoardMoves();
		moves.add(new PointT(-1,1));
		moves.add(new PointT(100,100));
		assertTrue(!board.validateMoves(moves));
	}
	
	@Test
	public void testValidateMoves() {
		BoardMoves moves = new BoardMoves();
		moves.add(new PointT(0,0));
		moves.add(new PointT(1,0));
		moves.add(new PointT(1,1));
		assertTrue(b.validateMoves(moves));	
	}
	
	@Test
	public void testValidateMovesWithRepeatedMoves() {
		BoardMoves moves = new BoardMoves();
		moves.add(new PointT(2,2));
		moves.add(new PointT(2,3));
		moves.add(new PointT(1,3));
		moves.add(new PointT(2,3));
		moves.add(new PointT(3,3));
		assertTrue(!b.validateMoves(moves));	
	}
	@Test
	public void testValidateMovesWithInvalidMoves() {
		BoardMoves moves = new BoardMoves();
		moves.add(new PointT(0,0));
		moves.add(new PointT(1,0));
		moves.add(new PointT(2,0));
		assertTrue(!b.validateMoves(moves));	
	}
	
	//test update board
	@Test
	public void testUpdateBoard() {
		/*
		 * testing the updateBoard() directly is not possible because the board sets new random values to certain cells
		 * the approach here to test is to eliminate a row of dots and then check if the values on top of those dots have sunk down
		 * notice in the startUp() method there is a row of P/Purple colored dots that we can test with
		 * if we remove those dots the colors B,P,O,G will sink down and take there place 
		 */
		
		BoardMoves test = new BoardMoves();
		test.add(new PointT(5,1)); //should update to B
		test.add(new PointT(5,2)); //updates to P
		test.add(new PointT(5,3)); //updates to O
		test.add(new PointT(5,4)); //updates to G
		
		ArrayList<Color> c = new ArrayList<Color>();
		c.add(Color.B);
		c.add(Color.P);
		c.add(Color.Y);
		c.add(Color.G);
		
		b.updateBoard(test);
		
		for (int i = 0; i < test.size(); i++) 
			assertTrue(b.get(test.get(i)) == c.get(i));
	}
	
}
