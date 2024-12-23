package com.example.web_appp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {
    private Connection connection;
    private String username = "root";
    private String password = "root";

    public database() throws SQLException , ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             String url = "jdbc:mysql://localhost/test_database";  // Ensure correct URL

            // Establish connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
    }

    public void add_operation(int first, int second, int sum) throws SQLException
    {
        String query = "INSERT INTO test_table (first_number, second_number, sum) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1 , first);
        ps.setInt(2 , second);
        ps.setInt(3 , sum);
        int res = ps.executeUpdate();
        connection.close();
        System.out.println("inserted successfully -> " + res);
    }

}
