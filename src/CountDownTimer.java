/** 
*  @file GameEnd.java
*  @author Shazil Arif
*  @brief CountDownTimer contains routines to create a count down timer and check when it has been cancelled
*  @date April 1st 2020
*/
import java.util.Timer;
import java.util.TimerTask;


/**
 *  @brief GameEnd contains routines to create a count down timer and execute a function when this timer is out of time 
 */
public class CountDownTimer{
	//special thanks to: http://www.iitk.ac.in/esc101/05Aug/tutorial/essential/threads/timer.html
	 private static Timer timer;
	 private static boolean cancelled;
	 private static int multiplier;
	 
	 /**
	  * @brief create a new Timer
	  * @param time the time in seconds to set for the timer
	  * @throws IllegalArgumentException if the time given is less than 1 second
	  */
	 public static void newTimer(int time) {
		 if(time < 1) throw new IllegalArgumentException("Timer must be set for atleast 1 second");
		 timer = new Timer();
		 multiplier = 1000;
		 cancelled = false;
		 timer.schedule(new End(), time*multiplier);	
	 }		
	 
	 /**
	  * @brief check if the timer has been cancelled or not
	  * @return whether the timer has ended or not
	  */
	 public static boolean isCancelled() {
		 return !cancelled;
	 }
	 
	 /**
	  * @brief class End extends TimerTask and provides a method to cancel the timer
	  */
	public static class End extends TimerTask {
		
		/**
		 * @brief this method is executed when the timer's allocated time has run out
		 * @details exists the system with status code 0 once the timer cancels	
		 */
		public void run() {
			timer.cancel();
			cancelled = true;
		}
	}
}