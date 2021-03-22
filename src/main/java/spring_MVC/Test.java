package spring_MVC;

import spring_MVC.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "mama071991";

    private static Connection connection;

    public static void main(String[] args) {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT name FROM person WHERE id = 1";
            ResultSet resultSet = statement.executeQuery(SQL);
            String s = "";
            while (resultSet.next()) {
                s = resultSet.getString("name");
            }
            System.out.println(s);
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
