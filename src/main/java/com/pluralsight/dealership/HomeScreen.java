package com.pluralsight.dealership;
import org.apache.commons.dbcp2.BasicDataSource;
import java.util.List;
import java.util.Scanner;
public class HomeScreen {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String DB_URL = "jdbc:mysql://localhost:3306/cardealership";
        String USER = "root";
        String PASS = System.getenv("my_DB_Password");
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
                searchByModel(dataManager, keyboard);

                System.out.println();
                break;
            case 2:
                searchByColor(dataManager, keyboard);
                System.out.println();
                break;
            case 3:
                searchByPrice(dataManager, keyboard);
                System.out.println();
                break;
            case 4:
                searchByMileage(dataManager, keyboard);
                System.out.println();
                break;
            case 5:
                searchByYear(dataManager, keyboard);
                System.out.println();
                break;
            case 6:
                searchByType(dataManager, keyboard);
                System.out.println();
                break;
            case 7:
                addVehicle(dataManager, keyboard);
                System.out.println("Vehicle has been added");
                break;
            case 8:
                removeVehicle(dataManager, keyboard);
                System.out.println("Vehicle has been removed");
                break;
            default:
                System.out.println("Thou speak madness. Try again, knave.");
        }}
    //Field o' methods down below
    private static void searchByModel(DataManager dataManager, Scanner keyboard) {
        System.out.println("State thy model: ");
        String input = keyboard.nextLine();
        List<String> searchResults = dataManager.getVehicleInfo(input);
        dataManager.getVehicleInfo(input);
        System.out.println(searchResults + "These be the cars thou seekth");

    }
    private static void searchByColor(DataManager dataManager, Scanner keyboard) {
        System.out.println("State thy color: ");
        String input = keyboard.nextLine();
        List<String> searchResults = dataManager.getVehicleInfo(input);
        dataManager.getVehicleInfo(input);
        System.out.println(searchResults + "These be the cars thou seekth");
    }
    private static void searchByPrice(DataManager dataManager, Scanner keyboard) {
        System.out.println("State thy price range: ");
        String input = keyboard.nextLine();
        List<String> searchResults = dataManager.getVehicleInfo(input);
        dataManager.getVehicleInfo(input);
        System.out.println(searchResults + "These be the cars thou seekth");
    }
    private static void searchByMileage(DataManager dataManager, Scanner keyboard) {
        System.out.println("State thy mileage range: ");
        String input = keyboard.nextLine();
        List<String> searchResults = dataManager.getVehicleInfo(input);
        dataManager.getVehicleInfo(input);
        System.out.println(searchResults + "These be the cars thou seekth");
    }
    private static void searchByYear(DataManager dataManager, Scanner keyboard) {
        System.out.println("State thy year: ");
        String input = keyboard.nextLine();
        List<String> searchResults = dataManager.getVehicleInfo(input);
        dataManager.getVehicleInfo(input);
        System.out.println(searchResults + "These be the cars thou seekth");
    }
    private static void searchByType(DataManager dataManager, Scanner keyboard) {
        System.out.println("State thy type: ");
        String input = keyboard.nextLine();
        List<String> searchResults = dataManager.getVehicleInfo(input);
        dataManager.getVehicleInfo(input);
        System.out.println(searchResults + "These be the cars thou seekth");
    }
    //methods for adding and removing vehicles from the db
    private static void addVehicle(DataManager dataManager, Scanner keyboard) {
        System.out.println("State thy vehicle details:");
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
        System.out.println("Thy vehicle has been added!");
    }
private static void removeVehicle(DataManager dataManager, Scanner keyboard) {;
System.out.print("State the model of the vehicle thou wish to remove: ");
String modelToRemove = keyboard.nextLine();
String[] values = {modelToRemove};
dataManager.deleteData("Vehicles", "Model", values);
System.out.println("Thou hast removed the vehicle.");
}}
