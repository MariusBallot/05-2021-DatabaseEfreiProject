package rentACar;

import display.Ascii;

import java.util.Scanner;

public class ClientMode {

    DBManager dbManager;
    ClientMode( DBManager dbManager){
        this.dbManager = dbManager;
    }
    public void start(){
        Ascii.clientMenu();
        Scanner cliScan = new Scanner(System.in);
        String select = cliScan.nextLine();  // Read user input
        if (select.equals("1")) {
            dbManager.getCars();
        }else if (select.equals("2")){
            dbManager.getCarsByBrand();
        }
        else if (select.equals("3")){
            return;
        }
        System.out.println("PRESS ANY KEY TO CONTINUE");
        Scanner ptc = new Scanner(System.in);
        ptc.nextLine();
        this.start();
    }
}
