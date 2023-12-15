package com.pluralsight.dealership;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DataManager {
    private DataSource dataSource;
    public DataManager(String jdbcUrl, String USER, String PASS) {
        initializeDataSource(jdbcUrl, USER, PASS);
    }
    private void initializeDataSource(String jdbcUrl, String USER, String PASS) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/cardealership");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("CalebH05");
        this.dataSource = basicDataSource;
    }
    public List<String> getVehicleInfo(String vehicles) {
        List<String> cars = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Vehicles WHERE Vehicles = ?")) {
                preparedStatement.setString(1, vehicles.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int priceRange = resultSet.getInt("Price");
                    double yearRange = resultSet.getInt("year");
                    int mileage = resultSet.getInt("Mileage");
                    String carModel = resultSet.getString("CarModel");
                    String color = resultSet.getString("Color");
                    String vehicleInfo = priceRange + " " + yearRange + " " + mileage + " " + carModel + " " + color + " " + vehicles;
                    cars.add(vehicleInfo);

                    for (String vehicle : cars) {
                        System.out.println(vehicle);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    public void insertData(String tableName, String columnNames, String[] values) {
        try (Connection connection = dataSource.getConnection()) {
            String columns = String.join(", ", columnNames.split(","));
            String placeholders = String.join(", ", repeat("?", values.length));
            String insertQuery = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columns, placeholders);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for (int i = 0; i < values.length; i++) {
                    preparedStatement.setString(i + 1, values[i]);
                }
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteData(String tableName, String columnName, String[] values) {
        try (Connection connection = dataSource.getConnection()) {
            String placeholders = String.join(", ", repeat("?", values.length));
            String deleteQuery = String.format("DELETE FROM %s WHERE %s IN (%s)", tableName, columnName, placeholders);

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                for (int i = 0; i < values.length; i++) {
                    preparedStatement.setString(i + 1, values[i]);
                }
                preparedStatement.executeUpdate();
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
    public void closeConnection() {
    }
}
