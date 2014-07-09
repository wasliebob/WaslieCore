package wasliecore.helpers;

import java.util.ArrayList;

public class WarningHelper {
	public static void addWarning(String name){
		warnings.add(name);
	}
	public static ArrayList<String> warnings = new ArrayList<String>();
}