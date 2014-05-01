package wasliecore.helpers;

import java.util.Calendar;

public class MathHelper {	
	/**
	 * 
	 * @param ticks
	 * @return
	 */
	public static int tickToSecond(int ticks)
	{
		int seconds = ticks/20;
		return seconds;
	}
	
	/**
	 * 
	 * @param seconds
	 * @return
	 */
	public static int secondToTick(int seconds)
	{
		int ticks = seconds*20;
		return ticks;
	}
	
	/**
	 * 
	 * @param ticks
	 * @return
	 */
	public static int ticksToMinutes(int ticks)
	{
		int seconds = ticks/20;
		int minutes = seconds/60;
		
		return minutes;
	}
	
	/**
	 * 
	 * @param minutes
	 * @return
	 */
	public static int minutesToTicks(int minutes)
	{
		int seconds = minutes*60;
		int ticks = seconds*20;
		
		return ticks;
	}
	
	/**
	 * 
	 * @param ticks
	 * @return
	 */
	public static int ticksToHours(int ticks)
	{
		int seconds = ticks/20;
		int minutes = seconds/60;
		int hours  = minutes/60;
		
		return hours;
	}
	
	/**
	 * 
	 * @param hours
	 * @return
	 */
	public static int hoursToTicks(int hours)
	{
		int minutes = hours*60;
		int seconds = minutes*60;
		int ticks = seconds*20;
		
		return ticks;
	}
	
	public static int calculateAge(int birthYear){
		 int year = Calendar.getInstance().get(Calendar.YEAR);	
		 return (year - birthYear);
	}
}