package ru.goryachev.foreman.config;

import java.sql.*;

public class classicJDBC {

    //classic JDBC connection is not used in this project, just for example
    //work with table of this project "construction"
    /*
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/foreman";
        String username = "postgres";
        String password = "postgres";

        System.out.println("classicJDBC is READY:");
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            final char dm = (char) 34;

            ResultSet resultSet = statement.executeQuery("SELECT * FROM construction");

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int column_count = rsmd.getColumnCount();
            System.out.println("classicJDBC columns: " + column_count);

            while (resultSet.next()) {
                System.out.println("classicJDBC result TWO works: " + resultSet.getInt("id"));
                System.out.println("classicJDBC result TWO works: " + resultSet.getString("codenumber"));
                System.out.println("classicJDBC result TWO works: " + resultSet.getString("name"));
                System.out.println("classicJDBC result TWO works: " + resultSet.getString("description"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("classicJDBC is CLOSED");

    }

*/
}
