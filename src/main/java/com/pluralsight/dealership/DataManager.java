package com.pluralsight.dealership;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private Connection connection;

    public DataManager(String jdbcUrl, String USER, String PASS, DataSource datasource) {
        this.datasource = datasource;
        try {
            this.connection = DriverManager.getConnection(jdbcUrl, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public DataManager(BasicDataSource dataSource, DataSource datasource) {
//        this.datasource = datasource;
//    }

    public void createTable(String tableName, String columns) {
        try {
            String createTableQuery = String.format("CREATE TABLE IF NOT EXISTS %s (%s)", tableName, columns);
            connection.createStatement().executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String tableName, String columnNames, String[] values) {
        try {
            String columns = String.join(", ", columnNames);
            String placeholders = String.join(", ", repeat("?", values.length));
            String insertQuery = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, placeholders);
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setString(i + 1, values[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static DataSource datasource;
        public static List<String> getVehicleInfo(String vehicles){
            List<String> cars = new ArrayList<>();
            try (Connection connection = datasource.getConnection()) {
                try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Vehicles WHERE Vehicles = ?")) {


                    preparedStatement.setString(1,vehicles.toString());
                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        int priceRange = resultSet.getInt("Price");
                        double yearRange = resultSet.getInt("year");
                        int mileage = resultSet.getInt("Mileage");
                        String carModel = resultSet.getString("CarModel");
                        String color = resultSet.getString("Color");
                        String VehicleInfo = priceRange + " " + yearRange + " " + mileage + " " + carModel + " " + color + " " + vehicles;
                        cars.add(VehicleInfo);

                        for (String vehicle : cars
                        ) {
                            System.out.println(cars);

                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return cars;
        }




    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String[] repeat(String value, int count) {
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = value;
        }
        return array;
    }

}