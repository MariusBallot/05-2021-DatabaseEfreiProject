package rentACar;

import display.Ascii;

public class CmdLineApp {

    ClientMode clientMode;
    EmpMode empMode;

    CmdLineApp(ClientMode clientMode,EmpMode empMode){
        this.clientMode = clientMode;
        this.empMode = empMode;
    }

    public void start(){
        Ascii.welcome();
        if (Ascii.state.equals("empMode")) {
            empMode.start();
        } else if (Ascii.state.equals("clientMode")) {
            clientMode.start();
        }
    }
}
