package wasliecore.helpers.misc;

import wasliecore.helpers.DateHelper;
import wasliecore.helpers.MathHelper;

public class SpecialDates {
	public static String getSpecialDay()
	{
		if(DateHelper.getCurrentDate() == "1/1")
			return "New Year";
		
		else if(DateHelper.getCurrentDate() == "16/12")
			return "Birthday_wasliebob";
		else if(DateHelper.getCurrentDate() == "24/12" || DateHelper.getCurrentDate() == "25/12")
			return "XMas";
		else if(DateHelper.getCurrentDate() == "31/12")
			return "Old Year";
			
		return null;
	}
	
	public static String getMessage(String s){
		if(s == "New Year")
			return "Happy New Year!";
		else if(s == "Birthday_wasliebob")
			return "Today's it's wasliebob's " + MathHelper.calculateAge(1997) + " birthday!";
		else if(s == "XMas")
			return "Happy Christmas";
		
		return null;
	}
}