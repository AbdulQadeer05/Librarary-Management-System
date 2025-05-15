package com.example.library_managment_system;

import java.sql.*;

public class Connectivty {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/library_managment_system";
        String username = "root";
        String password = "root";

        try {
            // 1. Load MySQL JDBC Driver (optional for newer Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to database
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");

            // 3. Create SQL query
            String sql = "SELECT * FROM book";

            // 4. Create Statement and Execute Query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 5. Loop through the result
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");

                System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Price: " + price);
            }

            // 6. Close connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}