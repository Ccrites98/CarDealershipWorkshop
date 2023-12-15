package com.pluralsight.dealership;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DataManager {
    private Connection connection;
    public DataManager(String jdbcUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    public void createTable(String tableName, String columns) {
        try {
            String createTableQuery = String.format("CREATE TABLE IF NOT EXISTS %s (%s)", tableName, columns);
            connection.createStatement().executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }}
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
        }}
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    private String[] repeat(String value, int count) {
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = value;
        }
        return array;
    }}