package wasliecore.helpers.java;

import java.util.ArrayList;
import java.util.HashSet;

public class StringHelper {
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
	
	public static ArrayList<String> convertStringList(String[] strings){
		ArrayList<String> list = new ArrayList<String>();
		for(String s : strings)
			list.add(s);
		return list;
	}
	
	public static String[] convertStringArray(ArrayList<String> list){
		return (String[])list.toArray();
	}
	
	public static String[] convertStringArray(HashSet<String> set){
		return (String[])set.toArray();
	}
}