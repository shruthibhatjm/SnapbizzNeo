package com.SNBN.rough;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodayDate {

	public static void main(String[] args) {
		// Get today's date
        LocalDate today = LocalDate.now();

        // Add 10 days to the current date
        LocalDate datePlus10Days = today.plusDays(10);

        // Extract the day of the month without leading zeros
       // int dayOfMonth = today.getDayOfMonth();
        int dayOfMonthPlus10 = datePlus10Days.getDayOfMonth();

        // Print the results
       // System.out.println("Original day of the month: " + dayOfMonth);
        System.out.println( dayOfMonthPlus10);
    
	}

}
