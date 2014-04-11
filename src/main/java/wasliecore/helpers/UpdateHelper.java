package wasliecore.helpers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class UpdateHelper {
	
	public static Double getVersion(String modName)
	{
		try{
			URL url = new URL("https://dl.dropboxusercontent.com/u/46500170/Site/Builds/" + modName + "_UPDATE" + ".wasliecore");
			Scanner scanner = new Scanner(url.openStream());
			
			while(scanner.hasNext()){
				String[] total = scanner.nextLine().split(":");
				double version = Double.parseDouble(total[0]);	
				return version;
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getText(String modName)
	{
		try{
			URL url = new URL("https://dl.dropboxusercontent.com/u/46500170/Site/Builds/" + modName + "_UPDATE" + ".wasliecore");

			Scanner scanner = new Scanner(url.openStream());
			
			while(scanner.hasNext()){
				String[] total = scanner.nextLine().split(":");
				String text = total[1];
				return text;
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static HashMap<Double, String> getUpdate(String modName)
	{
		try{
			HashMap<Double, String> update = new HashMap<Double, String>();
			URL url = new URL("https://dl.dropboxusercontent.com/u/46500170/Site/Builds/" + modName + "_UPDATE" + ".wasliecore");

			Scanner scanner = new Scanner(url.openStream());
			
			while(scanner.hasNext()){
				String[] total = scanner.nextLine().split(":");
				double version = Double.parseDouble(total[0]);	
				String text = total[1];
				update.put(version, text);
			}
			scanner.close();
			return update;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
