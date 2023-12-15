package com.pluralsight.dealership;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Scanner;
public class HomeScreen {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String DB_URL = "jdbc:mysql://localhost:3306/cardealership";
        String USER = "root";
        String PASS = System.getenv("CalebH05");
//        DataManager dataManager = new DataManager(DB_URL, USER, PASS);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);

        DataManager dataManager = new DataManager(dataSource);
        //down is the menu
        System.out.println("What are you looking for?");
        System.out.println("1. Search by Model");
        System.out.println("2. Search by Color");
        System.out.println("3. Search by Price");
        System.out.println("4. Search by Mileage");
        System.out.println("5. Search by Year");
        System.out.println("6. Search by Type");
        System.out.println("7. Add a Vehicle");
        System.out.println("8. Remove a Vehicle");
        System.out.print("State thy choice: ");
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        //select your options
        switch (choice) {
            case 1:
                searchByModel(DB_URL, USER, PASS, keyboard);

                System.out.println();
                break;
            case 2:
                searchByColor(DB_URL, USER, PASS, keyboard);
                System.out.println();
                break;
            case 3:
                searchByPrice(DB_URL, USER, PASS, keyboard);
                System.out.println();
                break;
            case 4:
                searchByMileage(DB_URL, USER, PASS, keyboard);
                System.out.println();
                break;
            case 5:
                searchByYear(DB_URL, USER, PASS, keyboard);
                System.out.println();
                break;
            case 6:
                searchByType(DB_URL, USER, PASS, keyboard);
                System.out.println();
                break;
            case 7:
                addVehicle(DB_URL, USER, PASS, keyboard);
                System.out.println("Vehicle has been added");
                break;
            case 8:
                removeVehicle(DB_URL, USER, PASS, keyboard);
                System.out.println("Vehicle has been removed");
                break;
            default:
                System.out.println("Thou speak madness. Try again, knave.");
        }}
    //Field o' methods down below
    private static void searchByModel(String DB_URL, String USER, String PASS, Scanner keyboard) {
        DataManager dataManager = new DataManager(DB_URL, USER, PASS);
        System.out.println("State thy model: ");
        String input = keyboard.nextLine();
        List<String> searchResults = dataManager.getVehicleInfo(input);
        dataManager.getVehicleInfo(input);
        System.out.println(searchResults + "These be the cars thou seekth");

    }
    private static void searchByColor(String DB_URL, String USER, String PASS, Scanner keyboard) {
        DataManager dataManager = new DataManager(DB_URL, USER, PASS);
        System.out.println("State thy color: ");
        String input = keyboard.nextLine();
        dataManager.getVehicleInfo(input);
    }
    private static void searchByPrice(String DB_URL, String USER, String PASS, Scanner keyboard) {
        DataManager dataManager = new DataManager(DB_URL, USER, PASS);
        System.out.println("State thy price range: ");
        String input = keyboard.nextLine();
        dataManager.getVehicleInfo(input);
    }
    private static void searchByMileage(String DB_URL, String USER, String PASS, Scanner keyboard) {
        DataManager dataManager = new DataManager(DB_URL, USER, PASS);
        System.out.println("State thy mileage range: ");
        String input = keyboard.nextLine();
        dataManager.getVehicleInfo(input);
    }
    private static void searchByYear(String DB_URL, String USER, String PASS, Scanner keyboard) {
        DataManager dataManager = new DataManager(DB_URL, USER, PASS);
        System.out.println("State thy year: ");
        String input = keyboard.nextLine();
        dataManager.getVehicleInfo(input);
    }
    private static void searchByType(String DB_URL, String USER, String PASS, Scanner keyboard) {
        DataManager dataManager = new DataManager(DB_URL, USER, PASS);
        System.out.println("State thy type: ");
        String input = keyboard.nextLine();
        dataManager.getVehicleInfo(input);
    }
    //methods for adding and removing vehicles from the db
    private static void addVehicle(String DB_URL, String USER, String PASS, Scanner keyboard) {
        DataManager dataManager = new DataManager(DB_URL, USER, PASS);
        System.out.println("Enter vehicle details:");
        System.out.print("Model: ");
        String model = keyboard.nextLine();
        System.out.print("Color: ");
        String color = keyboard.nextLine();
        System.out.print("Price: ");
        String price = keyboard.nextLine();
        System.out.print("Mileage: ");
        String mileage = keyboard.nextLine();
        System.out.print("Year: ");
        String year = keyboard.nextLine();
        System.out.print("Type: ");
        String type = keyboard.nextLine();
        String[] values = {model, color, price, mileage, year, type};
        dataManager.insertData("Vehicles", "Model, Color, Price, Mileage, Year, Type", values);
        System.out.println("Vehicle added successfully!");
    }
private static void removeVehicle(String DB_URL, String USER, String PASS, Scanner keyboard) {
DataManager dataManager = new DataManager(DB_URL, USER, PASS);
System.out.print("Enter the model of the vehicle to remove: ");
String modelToRemove = keyboard.nextLine();
String[] values = {modelToRemove};
dataManager.deleteData("Vehicles", "Model", values);
System.out.println("Thou hast removed the vehicle.");
}}
