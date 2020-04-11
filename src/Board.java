/**
*  @file Seq2D.java
*  @author Shazil Arif
*  @brief Board is a module used to represent a generic playable game board
*  @date March 16th 2020
*/
import java.util.ArrayList;

/** 
* @brief Board provides an ADT to represent a generic 2D board parameterized over any type
*/

abstract public class Board<T>{

    //state variables
    protected ArrayList<ArrayList<T>> s; //represents the board
    protected int n_row;
    protected int n_col;
    
    
    /**
     * @brief Constructor method for Board
     * @param row the number of rows desired in the board
     * @param col the number of columns desired in the board
     * @details the Boards cells are not initialized to anything, only the corresponding number of rows are added
     * @throws IllegalArgumentException if the parameter row or parameter col is less than or equal to 0
     */
    public Board(int row, int col) {
    	if(row <= 0 || col <= 0)
    		throw new IllegalArgumentException("Number of rows and columns have to be positive!");
    	n_row = row;
    	n_col = col;
    	s = new ArrayList<ArrayList<T>>();
    	for(int i = 0; i < n_row; i++) {
    		s.add(new ArrayList<T>());
    	}
    }
        
    /**
     * @brief setter method for Board, get a value at a given point
     * @param p PointT object indicating the position to get
     * @return the value at point p
     * @throws IndexOutBoundsException if PointT object lies outside of the Board, i.e the row or column lie outside of the Boards dimensions
     */
    public void set(PointT p, T v) {
    	if(validPoint(p)) {
    		s.get(p.row()).set(p.col(), v);
    	}
    	else 
    		throw new IndexOutOfBoundsException("The given point lies outside of the Board!");
    }
    
    /**
     * @brief getter method for Board, get a value at a given point
     * @param p PointT object indicating the position to get
     * @return the value at point p
     * @throws IndexOutBoundsException if PointT object lies outside of the Board, i.e the row or column lie outside of the Boards dimensions
     */
     public T get(PointT p){
         if(validPoint(p))
             return s.get(p.row()).get(p.col());
         else
             throw new IndexOutOfBoundsException("The given point lies outside of the Board!");
     }
     
     /**
      * @brief getter method for the number of rows in the current Board object
      * @return the number of rows in the current Board
      */
      public int getNumRow(){ return n_row; }

      /**
      * @brief getter method for the number of columns in the current Board object
      * @return the number of columns in the current Board object
      */
      public int getNumCol(){ return n_col; }
      
     /**
      * @brief private helper method to validate a row number
      * @param row the row index to validate
      * @return boolean indicating if the row number is valid
      */
     private boolean validRow(int row) { return row >= 0 && row < n_row; }

      /** 
      * @brief private helper method to validate a column number
      * @param col the column index to validate
      * @return boolean indicating if the column number is valid (i.e lies in the 2D sequence bounds)
      */
     private boolean validCol(int col){ return col >= 0 && col < n_col; }

      /** 
      * @brief protected helper method to validate a PointT object. visible to the current and a child class only
      * @param p the PointT object to validate
      * @return boolean indicating if the column number is valid (i.e lies in the 2D sequence bounds)
      */
     protected boolean validPoint(PointT p){ 
         return validRow(p.row()) && validCol(p.col()); 
     }
    
}
