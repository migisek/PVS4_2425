package databases;

import java.sql.*;

public class Basics {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.1.12.16:3306/cities", "prg", "infis");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM city");

        while (resultSet.next()){//jede po zaznamench - radcich
            System.out.println(resultSet.getString("Name") +
                    ", " + resultSet.getString("CountryCode") +
                    ", " + resultSet.getInt("Population"));
        }
    }
}
