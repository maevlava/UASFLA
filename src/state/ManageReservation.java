package state;

import chainofresponsibility.Resepsionis;
import model.Pelanggan;
import model.Room;

public class ManageReservation implements ApplicationState {

    Application application;

    public ManageReservation(Application application) {
        this.application = application;
    }


    @Override
    public void runSubProgram(Pelanggan pelanggan) {

    }

    @Override
    public void exit() {

    }
}
