package wasliecore.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	public static String getCurrentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getCurrentMonth()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	
	public static String getCurrentDay()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getCurrentFullDate()
	{
		return getCurrentDay() + " " + getCurrentFullMonth();
	}
	
	public static String getCurrentFullMonth()
	{
		String month = getCurrentMonth();
		if(month == "1")
			return "January";
		if(month == "2")
			return "February";
		if(month == "3")
			return "March";
		if(month == "4")
			return "April";
		if(month == "5")
			return "May";
		if(month == "6")
			return "June";
		if(month == "7")
			return "July";
		if(month == "8")
			return "August";
		if(month == "9")
			return "September";
		if(month == "10")
			return "Oktober";
		if(month == "11")
			return "November";
		if(month == "12")
			return "December";
		else
			return "You just found out a new month 0.o";
	}
}