package wasliecore.helpers.misc;

import wasliecore.helpers.DateHelper;

public class SpecialDates {
	public static String getSpecialDay()
	{
		if(DateHelper.getCurrentDate() == "1/1")
			return "New Year";
		
		else if(DateHelper.getCurrentDate() == "16/12")
			return "Birthday";
		else if(DateHelper.getCurrentDate() == "24/12" || DateHelper.getCurrentDate() == "25/12")
			return "XMas";
		else if(DateHelper.getCurrentDate() == "31/12")
			return "Old Year";
			
		return null;
	}
}
