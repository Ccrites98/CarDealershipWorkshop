package com.pluralsight.dealership;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class HomeScreen {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String DB_URL = "jdbc:mysql://localhost:3306/cardealership";
    String USER = "root";
    String PASS = System.getenv("CalebH05");



    System.out.println("What are you looking for?");
    System.out.println("Search by Model: ");
    System.out.println("Search by Color: ");
    System.out.println("Search by Price: ");
    System.out.println("Search by Mileage: ");
    System.out.println("Search by Year: ");
    System.out.println("Search by Type: ");
    String input = scanner.nextLine();

    DataManager.getVehicleInfo(input);


}
}

