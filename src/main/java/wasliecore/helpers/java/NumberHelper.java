package wasliecore.helpers.java;

public class NumberHelper {
	public boolean isBetween(int number, int start, int end){
		return number > start && number < end;
	}
	
	public int getLowest(int a, int b){
		return (a < b) ? a : b;
	}
	
	public int getHighest(int a, int b){
		return (a > b) ? a : b;
	}
}