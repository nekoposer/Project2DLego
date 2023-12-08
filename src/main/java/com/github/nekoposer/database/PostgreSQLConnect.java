package com.github.nekoposer.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgreSQLConnect {
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String user = "admin";
    static String password = "root";

    //селект
    public static Map<String, Integer> selectDataFromDB(String index) {
        Map<String, Integer> result = new HashMap<>();
        String select = """
            SELECT name, time
            FROM leaders
            WHERE name = ?
            """;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(select);
            statement.setString(1, index);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int time = resultSet.getInt("time");
                result.put(name, time);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    // инсерт
    public static void insertDataIntoDB(String name, int time) {
        String insert = """
            INSERT INTO leaders (name, time)
            VALUES (?, ?)
            """;
        try {
            Map<String, Integer> existing = PostgreSQLConnect.selectDataFromDB(name);
            if (existing.size() == 0) {
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = connection.prepareStatement(insert);
                statement.setString(1, name);
                statement.setInt(2, time);
                statement.executeUpdate();

                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    //апдейт
    public static void updateDataInDB(String name, int time) {
        String update = """
            UPDATE leaders
            SET time = ?
            WHERE name = ?
            """;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setInt(1, time);
            statement.setString(2, name);
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    //селект всё
    public static List<Map<String, Integer>> selectAllFromDB() {
        List<Map<String, Integer>> result = new ArrayList<>();
        String select = """
        SELECT name, time
        FROM leaders
        ORDER BY time DESC
        """;
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(select);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Map<String, Integer> row = new HashMap<>();
                row.put(resultSet.getString("name"), resultSet.getInt("time"));
                result.add(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }
}