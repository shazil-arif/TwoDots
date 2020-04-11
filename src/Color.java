/** 
*  @file Colors.java
*  @author Shazil Arif
*  @brief Colors contains an enumeration for different colors on a two dots game board
*  @date April 1st 2020
*/

import java.util.Random;


/**
 * @brief Color is enumeration for different colors on a two dots game board
 *
 */
public enum Color{
    R,G,B,P,Y;
	
	/**
	 * @brief return a random color R,G,B,P or Y
	 * @return a random Color
	 */
	public static Color randomColor(){
		Random rnd = new Random();
	    int index = rnd.nextInt(Color.values().length);
	    return Color.values()[index];
	}
}


