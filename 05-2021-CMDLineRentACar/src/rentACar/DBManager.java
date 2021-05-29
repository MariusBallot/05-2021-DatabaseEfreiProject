package rentACar;

import java.sql.*;

public class DBManager {

    DBManager(){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rentacar", "postgres", "postgres")) {

            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.vehicule");


        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }



}
