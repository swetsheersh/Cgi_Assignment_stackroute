package assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assig_13 {
	
	public static LocalDate warrenty(LocalDate date,int year,int month) {
		date=date.plusMonths(month);
		date=date.plusYears(year);
		return date;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String d;
		System.out.println("Enter your product purchase date in (dd-MM-yyyy) format: ");
		d=scanner.nextLine();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date=LocalDate.parse(d,formatter);
		System.out.println("Enter warrantee period in month and year");
		System.out.println("year: ");
		int y=scanner.nextInt();
		System.out.println("month: ");
		int mon=scanner.nextInt();
		System.out.println("Expiry date of warrenty: "+ warrenty(date,y,mon));

	}

}