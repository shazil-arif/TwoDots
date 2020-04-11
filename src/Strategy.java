/** 
*  @file Strategy.java
*  @author Shazil Arif
*  @brief Strategy is an interface for defining a family of game modes for Two Dots
*  @date April 1st 2020
*/


/** 
* @brief Strategy is an interface for defining a family of game modes for Two Dots
*/
 interface Strategy {
    /**
     * @brief Generic method to start a game mode from a family of different modes
     */
	public void play(TwoDotsBoard b);
}
