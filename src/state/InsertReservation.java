package state;

public class InsertReservation implements ApplicationState {

    Application application;
    public InsertReservation(Application menus) {
        application = menus;
    }

    @Override
    public void runSubProgram() {

    }

    @Override
    public void exit() {

    }
}
