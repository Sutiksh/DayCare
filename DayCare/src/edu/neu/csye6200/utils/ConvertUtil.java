package edu.neu.csye6200.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
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

	public static double stringToDouble(String str) {
		double val = 0.0;
		try {
			val = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		return val;
		
	}
	
	public static long stringToLong(String str) {
		long val = 0;
		try {
			val = Long.parseLong(str);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		
		return val;
		
	}
	
	public static LocalDate stringtoLocalDate(String str) {
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
