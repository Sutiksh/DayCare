package edu.neu.csye6200.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.sql.Date;
import java.util.logging.SimpleFormatter;

public class ConvertUtil {
	
	public static int stringToInt(String str) {
		int val = 0;
		try {
			val = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		return val;
		
	}

	public static String intToString(int val){
		String str = "";
		str += val;
		return str;
	}

	public static double stringToDouble(String str) {
		double val = 0.0;
		try {
			val = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		return val;
		
	}

	public static String doubleToString(double val){
		String str = "";
		str += val;
		return str;
	}
	
	public static long stringToLong(String str) {
		if(str == null){
			return 0;
		}

		long val = 0;
		try {
			val = Long.parseLong(str);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		return val;
		
	}

	public static String longToString(long val){
		String str = "";
		str += val;
		return str;
	}
	
	public static LocalDate stringtoLocalDate(String str) {
		if(str == null){
			return null;
		}

		LocalDate val = null;
		
		try {
			val = LocalDate.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return val;
	}

	public static String idToString(int id) {
		if (id == -1) {
			return "null";
		} else {
			return String.valueOf(id);
		}
	}

	public static String dateToString(LocalDate date){
		if(date == null){
			return "";
		}
		return date.getYear() + "/" + date.getMonthValue() + "/" + date.getDayOfMonth();
	}

	public static java.sql.Date stringToDate(String strdate){
		String[] tokens = strdate.split("-");
		return (java.sql.Date) new Date(ConvertUtil.stringToInt(tokens[0]), ConvertUtil.stringToInt(tokens[1]), ConvertUtil.stringToInt(tokens[2]));
	}

	public static int calAge(LocalDate birthdate){
		int year = birthdate.getYear();
		int month = birthdate.getMonthValue();
//		String[] date = birthdate.split("-");
//		int year = Integer.parseInt(date[0]);
//		int month = Integer.parseInt(date[1]);
		LocalDate now = LocalDate.now();
		return 12 * (now.getYear() - year - 1) + (12 - month) + now.getMonthValue();
	}
}
