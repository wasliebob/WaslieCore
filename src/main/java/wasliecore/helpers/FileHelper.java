package wasliecore.helpers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import wasliecore.main.Config;

public class FileHelper {

	public static void createMainFolder() {
		File file = new File(Config.mapLocation + "/WaslieCore/");
		if(!file.exists())
			file.mkdir();
	}
	
	/**
	 * 
	 * @param modName
	 */
	public static void createModFolder(String modName){
		File file = new File(Config.mapLocation  + "/WaslieCore/" + modName + "/");
		if(!file.exists())
			file.mkdir();
		}
	
	/**
	 * 
	 * @param modName
	 * @param fileName
	 * @param extension
	 * @param map
	 */
	public static void createBaseFileInFolder(String modName, String fileName, String extension, HashMap<Integer, String> map){
		File file = new File(Config.mapLocation + "/WaslieCore/" +  modName + "/" + fileName + "." + extension);
		try {
			file.createNewFile();
			PrintWriter writer = new PrintWriter(Config.mapLocation + "/WaslieCore/"+ modName + fileName + "." + extension, "UTF-8");
			
			for(int i = 0; i < map.size(); i++)
				if(map.get(i) != null)
					writer.println(map.get(i));

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param fileName
	 * @param extension
	 * @param list
	 */
	public static void createBaseFileOutsideFolder(String fileName, String extension, ArrayList<String> list){
		File file = new File(Config.mapLocation + "/WaslieCore/" + fileName + "." + extension);
		try {
			file.createNewFile();
			PrintWriter writer = new PrintWriter(Config.mapLocation + "/WaslieCore/" + fileName + "." + extension, "UTF-8");
			
			for(int i = 0; i < list.size(); i++)
				if(list.get(i) != null)
					writer.println(list.get(i));

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static HashMap<String, Double> getDonators()
	{
		return donators;
	}
	
	public static void addDonators()
	{
		try{
			URL url = new URL("https://dl.dropboxusercontent.com/u/46500170/Site/donator_list.txt");

			Scanner scanner = new Scanner(url.openStream());
			
			while(scanner.hasNext()){
				String[] total = scanner.nextLine().split(":");
				String name = total[0];	
				double amount = Double.parseDouble(total[1]);
				donators.put(name, amount);
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static HashMap<String, Double> donators = new HashMap<String, Double>();
	
	public static boolean isDonator(String name)
	{
		return getDonators().containsKey(name);
	}
	
	public static double getAmount(String name)
	{
		if(isDonator(name)){
			return getDonators().get(name);
		}else
			return 0;
	}
}
