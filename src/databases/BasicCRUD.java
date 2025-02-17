package databases;

import java.sql.*;

public class BasicCRUD {
    private static final String USER = "infis";
    private static final String PASSWORD = "infis";
    private static final String DB_URL = "jdbc:mysql://10.1.12.18:3306/world";
    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)){
            System.out.println("Pripojeno uspesne k DB!");

            //vypsat vsechny zeme:
            Statement stmt = conn.createStatement();

            //zaroven akceptuje dotaz, zaroven uchovava odpoved na doraz/pohled
            String query = "SELECT Name, Continent, Population FROM country";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                System.out.println(rs.getString("Name")
                        + " | " + rs.getString("Continent")
                        + "|" + rs.getInt("Population"));
            }

        } catch (SQLException e){
            System.out.println("Nepodarilo se pripojit k DB: " + e.getMessage());
        }

    }
}
