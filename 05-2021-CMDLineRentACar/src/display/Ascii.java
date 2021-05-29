package display;

import java.util.Scanner;

public class Ascii {

    public static String state = "neutral";

    public static void welcome() {
        String welcome =
                "|  __ \\ |  ____|| \\ | ||__   __|     /\\      / ____|    /\\    |  __ \\ \n" +
                        "| |__) || |__   |  \\| |   | |       /  \\    | |        /  \\   | |__) |\n" +
                        "|  _  / |  __|  | . ` |   | |      / /\\ \\   | |       / /\\ \\  |  _  / \n" +
                        "| | \\ \\ | |____ | |\\  |   | |     / ____ \\  | |____  / ____ \\ | | \\ \\ \n" +
                        "|_|  \\_\\|______||_| \\_|   |_|    /_/    \\_\\  \\_____|/_/    \\_\\|_|  \\_\\";

        System.out.println(welcome);
        mainMenu();
    }

    public static void mainMenu() {
        String str =
                "\n" +
                        "\n" +
                        "\n" +
                        "|  \\/  |       (_)                                       \n" +
                        "| \\  / |  __ _  _  _ __    _ __ ___    ___  _ __   _   _ \n" +
                        "| |\\/| | / _` || || '_ \\  | '_ ` _ \\  / _ \\| '_ \\ | | | |\n" +
                        "| |  | || (_| || || | | | | | | | | ||  __/| | | || |_| |\n" +
                        "|_|  |_| \\__,_||_||_| |_| |_| |_| |_| \\___||_| |_| \\__,_|\n" +
                        "                                                         "
                        + "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "__          __ _                                                         \n" +
                        "\\ \\        / /| |                                                      _ \n" +
                        " \\ \\  /\\  / / | |__    ___     __ _  _ __  ___   _   _   ___   _   _  (_)\n" +
                        "  \\ \\/  \\/ /  | '_ \\  / _ \\   / _` || '__|/ _ \\ | | | | / _ \\ | | | |    \n" +
                        "   \\  /\\  /   | | | || (_) | | (_| || |  |  __/ | |_| || (_) || |_| |  _ \n" +
                        "    \\/  \\/    |_| |_| \\___/   \\__,_||_|   \\___|  \\__, | \\___/  \\__,_| (_)\n" +
                        "                                                  __/ |                  \n" +
                        "                                                 |___/                   " + "\n" +
                        "\n" +
                        "\n" +
                        "\n" + "" +
                        "/_ |   / ____|| |(_)             | |  \n" +
                        " | |  | |     | | _   ___  _ __  | |_ \n" +
                        " | |  | |     | || | / _ \\| '_ \\ | __|\n" +
                        " | | _| |____ | || ||  __/| | | || |_ \n" +
                        " |_|(_)\\_____||_||_| \\___||_| |_| \\__|" + "\n" +
                        "\n" +
                        "\n" + " ___      ______                    _                           \n" +
                        "|__ \\    |  ____|                  | |                          \n" +
                        "   ) |   | |__    _ __ ___   _ __  | |  ___   _   _   ___   ___ \n" +
                        "  / /    |  __|  | '_ ` _ \\ | '_ \\ | | / _ \\ | | | | / _ \\ / _ \\\n" +
                        " / /_  _ | |____ | | | | | || |_) || || (_) || |_| ||  __/|  __/\n" +
                        "|____|(_)|______||_| |_| |_|| .__/ |_| \\___/  \\__, | \\___| \\___|\n" +
                        "                            | |                __/ |            \n" +
                        "                            |_|               |___/             \n" + "" +
                        "Type in 1 or 2 :";

        System.out.println(str);


        Scanner myScan = new Scanner(System.in);
        String mode = myScan.nextLine();  // Read user input
        if (mode.equals("1")) {
            clientMenu();
        } else if (mode.equals("2")) {
           state = "empMode";
            employeeMenu();
        } else {
            err404();
        }
    }

    public static void err404() {
        String str =
                "|  ____||  __ \\ |  __ \\  / __ \\ |  __ \\  | || |   / _ \\ | || |  \n" +
                        "| |__   | |__) || |__) || |  | || |__) | | || |_ | | | || || |_ \n" +
                        "|  __|  |  _  / |  _  / | |  | ||  _  /  |__   _|| | | ||__   _|\n" +
                        "| |____ | | \\ \\ | | \\ \\ | |__| || | \\ \\     | |  | |_| |   | |  \n" +
                        "|______||_|  \\_\\|_|  \\_\\ \\____/ |_|  \\_\\    |_|   \\___/    |_| ";

        System.out.println(str);
    }

    public static void clientMenu() {
        String str =
                "|  __ \\ |  ____|| \\ | ||__   __|     /\\      / ____|    /\\    |  __ \\ \n" +
                        "| |__) || |__   |  \\| |   | |       /  \\    | |        /  \\   | |__) |\n" +
                        "|  _  / |  __|  | . ` |   | |      / /\\ \\   | |       / /\\ \\  |  _  / \n" +
                        "| | \\ \\ | |____ | |\\  |   | |     / ____ \\  | |____  / ____ \\ | | \\ \\ \n" +
                        "|_|  \\_\\|______||_| \\_|   |_|    /_/    \\_\\  \\_____|/_/    \\_\\|_|  \\_\\";

        System.out.println(str);
    }

    public static void employeeMenu() {
        String str =
                "|  ____||  \\/  ||  __ \\ | |     / __ \\\\ \\   / /|  ____||  ____|\n" +
                        "| |__   | \\  / || |__) || |    | |  | |\\ \\_/ / | |__   | |__   \n" +
                        "|  __|  | |\\/| ||  ___/ | |    | |  | | \\   /  |  __|  |  __|  \n" +
                        "| |____ | |  | || |     | |____| |__| |  | |   | |____ | |____ \n" +
                        "|______||_|  |_||_|     |______|\\____/   |_|   |______||______|\n" +
                        "                                                               \n" +
                        "                                                               \n" +
                        " __  __   ____   _____   ______ \n" +
                        "|  \\/  | / __ \\ |  __ \\ |  ____|\n" +
                        "| \\  / || |  | || |  | || |__   \n" +
                        "| |\\/| || |  | || |  | ||  __|  \n" +
                        "| |  | || |__| || |__| || |____ \n" +
                        "|_|  |_| \\____/ |_____/ |______|"
        +
                "\n" +
                "\n" +
                "\n";
        System.out.println(str);
    }

}