package state;

public class InsertReservation implements ApplicationState {

    Application application;
    public InsertReservation(Application app) {
        application = app;
    }
    @Override
    public void runSubProgram() {
        menu();
    }

    private void menu() {
        System.out.println("Wow");
    }


    @Override
    public void exit() {

    }
}
