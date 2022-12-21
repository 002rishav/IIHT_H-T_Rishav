package com.basic.dateandtimeapi;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class DateTime {

	public static void main(String[] args) {
		
//		Date today = new Date();
		LocalDate today = LocalDate.now();
		//We don't need new because we don't want to create an object
		
		System.out.println("Local Date: "+today);
		
		LocalDateTime rightNow = LocalDateTime.now();
		System.out.println("Local Date and Time: "+rightNow);
		
		LocalDate rightNow1 = LocalDate.of(2022, Month.AUGUST, 15);
		System.out.println("Specific Date: "+rightNow1);
		
		LocalTime t1 = LocalTime.now(ZoneId.of("CET"));
		System.out.println("Local Time: "+t1);
		
//		LocalDate birthDay = LocalDate.now().withDayOfMonth(dayOfMonth)
		

	}

}
