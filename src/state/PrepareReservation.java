package state;

import model.Pelanggan;

public class PrepareReservation implements ApplicationState {

    Application application;
    public PrepareReservation(Application application) {
        this.application = application;
    }

    @Override
    public void runSubProgram(Pelanggan pelanggan) {

    }

    @Override
    public void exit() {

    }
}
