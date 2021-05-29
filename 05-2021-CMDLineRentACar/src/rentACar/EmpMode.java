package rentACar;

import display.Ascii;

import java.util.Scanner;

public class EmpMode {
    DBManager dbManager;
    EmpMode( DBManager dbManager){
        this.dbManager = dbManager;
    }

    public void start(){
        Ascii.employeeMenu();
        System.out.println("ENTER LOGIN");
        Scanner logScan = new Scanner(System.in);
        String log = logScan.nextLine();  // Read user input

        System.out.println("ENTER PASSWORD");
        Scanner passScan = new Scanner(System.in);
        String pass = passScan.nextLine();

        Boolean verif = dbManager.verifLogs(log, pass);
        if (verif) {
            Ascii.successCo();
        } else {
            Ascii.err404();
        }
    }
}
