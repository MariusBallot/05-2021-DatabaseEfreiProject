package rentACar;

import display.Ascii;

import java.sql.*;
import java.util.Scanner;

public class DBManager {

    DBManager() {

    }

    public static Boolean verifLogs(String log, String pass) {
        Boolean checker = false;
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rentacar", "postgres", "postgres")) {


            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM public.employe WHERE login = '" + log + "'");

            while (rs.next()) {
                System.out.println(rs.getString("login"));
                if (pass.equals(rs.getString("mdp"))) {
                    checker = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return checker;

    }

    public static void getCars(){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rentacar", "postgres", "postgres")) {


            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Vehicule");

            while (rs.next()) {
                String str = "Model : "+rs.getString("modele") +"    "
                        +"Brand : "+rs.getString("marque") +"    ";
                System.out.println(str );

            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public static void getCarsByBrand(){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rentacar", "postgres", "postgres")) {


            Statement statement = connection.createStatement();
            System.out.println("ENTER BRAND OF CHOICE");
            Scanner bScan = new Scanner(System.in);
            String brand = bScan.nextLine();
            ResultSet rs = statement.executeQuery("SELECT * FROM Vehicule WHERE marque = '"+brand+"'");

            Boolean exists = false;
            while (rs.next()) {
                exists = true;
                String str = "Model : "+rs.getString("modele") +"    "
                        +"Brand : "+rs.getString("marque") +"    ";
                System.out.println(str );
            }
            if(!exists){
                Ascii.err404();
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }


}
