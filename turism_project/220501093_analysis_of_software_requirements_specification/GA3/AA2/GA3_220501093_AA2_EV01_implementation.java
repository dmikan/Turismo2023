/**
 * This program requests a date of birth and the current date. It returns the the age in years. The second part  
 * of the program calculate if a given year is a leap year or not. The flowcharts used to design the algoritms 
 * can be found in the same directory of this file. 
 */

//package com.mycompany.if_else_example;
import java.util.Scanner;

public class DateUtils {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Request date of birth
        System.out.print("Enter the year of birth: ");
        int yearOfBirth = scanner.nextInt();

        System.out.print("Enter the month of birth: ");
        int monthOfBirth = scanner.nextInt();

        System.out.print("Enter the day of birth: ");
        int dayOfBirth = scanner.nextInt();

        // Request date of today
        System.out.print("Enter the current year: ");
        int currentYear = scanner.nextInt();

        System.out.print("Enter the current month: ");
        int currentMonth = scanner.nextInt();

        System.out.print("Enter the current day: ");
        int currentDay = scanner.nextInt();

        // Calculate age
        int age = calculateAge(yearOfBirth, monthOfBirth, dayOfBirth, currentYear, currentMonth, currentDay);
        System.out.println("The age in years is: " + age + ".");

        // Determine if a year is a leap year
        System.out.println("Enter a year to check if it's a leap year:");
        int year = scanner.nextInt();
        boolean isLeapYear = isLeapYear(year);
        System.out.println("Is " + year + " a leap year? " + (isLeapYear ? "TRUE" : "FALSE"));

        scanner.close();
    }

    // Function to calculate age
    public static int calculateAge(int yearOfBirth, int monthOfBirth, int dayOfBirth, 
                                   int currentYear, int currentMonth, int currentDay) {
        int age;
        if (currentMonth < monthOfBirth) {
            age = currentYear - yearOfBirth - 1;
        } else {
            if (currentMonth == monthOfBirth) {
                if (currentDay < dayOfBirth) {
                    age = currentYear - yearOfBirth - 1;
                } else {
                    age = currentYear - yearOfBirth;
                }
            } else {
                age = currentYear - yearOfBirth;
            }
        }
        return age;
    }

    // Function to determine if a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
