package rentACar;

import display.Ascii;

import java.sql.SQLException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws SQLException {

        DBManager dbManager = new DBManager();
        ClientMode clientMode = new ClientMode(dbManager);
        EmpMode empMode = new EmpMode(dbManager);

        Ascii.welcome();
        if (Ascii.state.equals("empMode")) {
            empMode.start();
        } else if (Ascii.state.equals("clientMode")) {
            clientMode.start();
        }

    }


}