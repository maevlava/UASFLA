package state;

import model.Pelanggan;

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
