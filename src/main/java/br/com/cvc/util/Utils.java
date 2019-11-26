package br.com.cvc.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Utils {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	
	public static Long getDiffDates(String d1, String d2) throws Exception{
		
		try{
		    LocalDate dateTime1 = LocalDate.parse(d1, formatter);
		    LocalDate dateTime2 = LocalDate.parse(d2, formatter);
		    
			return ChronoUnit.DAYS.between(dateTime1, dateTime2);
		}catch (Exception e){
			throw new Exception("Verifique formato data: MM-dd-yyyy");
		}

	}
}
