package rentACar;

import display.Ascii;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();

        Ascii.welcome();
        System.out.println(Ascii.state);
        if(Ascii.state.equals("empMode")){
            System.out.println("ENTER LOGIN");
            Scanner logScan = new Scanner(System.in);
            String log = logScan.nextLine();  // Read user input

        }


    }
}