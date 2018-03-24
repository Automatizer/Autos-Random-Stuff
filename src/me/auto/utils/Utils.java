package me.auto.utils;

public class Utils {

	public static int stringToInt(String toConvert){
		int toReturn = -1;
		try{
			toReturn = Integer.parseInt(toConvert);
		}catch(Exception ex){
			toReturn = -1;
		}
		return toReturn;
	}
	
	public static double stringToDouble(String toConvert){
		double toReturn = -1;
		try{
			toReturn = Double.parseDouble(toConvert);
		}catch(Exception ex){
			toReturn = -1;
		}
		return toReturn;
	}
	
	public static boolean stringToBoolean(String toConvert){
		boolean toReturn = false;
		try{
			toReturn = Boolean.parseBoolean(toConvert);
		}catch(Exception ex){
			toReturn = false;
		}
		return toReturn;
	}
	
	
	
}
