package wasliecore.helpers;

import java.util.Calendar;
import java.util.HashSet;

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
	
	/**
	 * Inbetween does NOT include start and end numbers itself
	 */
	public static boolean inBetween(int start, int end, int number){
		return number > start && number < end;
	}
	
	public static String convertByteArray(Byte[] bytes){
		String s = null;
		for(Byte b : bytes){
			s += b.toString();
		}
		return s;
	}
	
	public static HashSet<String> convertStringSet(String[] strings){
		HashSet<String> set = new HashSet<String>();
		
		for(String s : strings)
			set.add(s);
		return set;
	}
	
	public static String[] convertStringArray(HashSet<String> set){
		return (String[])set.toArray();
	}
	
	public static int calculateDistance(int from, int to){
		if(from > to)
			return from - to;
		else if(to > from)
			return to - from;
		
		return 0;
	}
	
	public static double percent(double value, double percent){
		double difference = value/100*percent;
		return difference;
	}
	
	public static double average(double[] values){
		double total = 0;
		
		for(int i = 0; i < values.length; i++){
			total = total + values[i];
		}
		
		double average = total/values.length;
		return average;
	}
	
	/**
	 * @param value
	 * number to change amount of decimals.
	 * @param decimals
	 * usage: 1 + amount of decimals
	 * example: decimals = 10; means 1 decimal.
	 * example: decimals = 100; means 2 decimals.
	 * @return new decimal
	 */
	public static double changeDecimals(double value, int decimals){
		double dec = (double)Math.round(value * decimals) / decimals;
		return dec;
	}
}