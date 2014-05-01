package wasliecore.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static String getCurrentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static int getCurrentMonth()
	{
		int month = Calendar.getInstance().get(Calendar.MONTH);
		return month;
	}
	
	public static String getCurrentDay()
	{
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		return Integer.toString(day);
	}
	
	public static String getCurrentFullDate()
	{
		return getCurrentDay() + " " + getCurrentFullMonth();
	}
	
	public static String getCurrentFullMonth()
	{
		int month = getCurrentMonth();
		if(month == 0)
			return "January";
		if(month == 1)
			return "February";
		if(month == 2)
			return "March";
		if(month == 3)
			return "April";
		if(month == 4)
			return "May";
		if(month == 5)
			return "June";
		if(month == 6)
			return "July";
		if(month == 7)
			return "August";
		if(month == 8)
			return "September";
		if(month == 9)
			return "Oktober";
		if(month == 10)
			return "November";
		if(month == 11)
			return "December";
		else
			return "You just found out a new month 0.o";
	}
}