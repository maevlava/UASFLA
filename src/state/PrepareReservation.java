package state;

public class PrepareReservation implements ApplicationState {

    Application application;
    public PrepareReservation(Application application) {
        this.application = application;
    }

    @Override
    public void runSubProgram() {

    }

    @Override
    public void exit() {

    }
}
