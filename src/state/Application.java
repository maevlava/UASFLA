package state;

public class Application implements ApplicationState {


    ApplicationState reservationMenu;
    ApplicationState insertReservation;
    ApplicationState prepareReservation;
    ApplicationState manageReservation;

    ApplicationState applicationState;

    // Initialize states objects
    public Application() {
        this.reservationMenu = new ReservationApplication(this);
        this.insertReservation = new InsertReservation(this);
        this.prepareReservation = new PrepareReservation(this);
        this.manageReservation = new ManageReservation(this);

        applicationState = reservationMenu;
    }
    public void run() {
        applicationState.runSubProgram();
    }

    // State Pattern
    public void setApplicationState(ApplicationState newState) {
        this.applicationState = newState;
    }

    @Override
    public void runSubProgram() {
        applicationState.runSubProgram();
    }

    @Override
    public void exit() {
        applicationState.exit();
    }


    // State Getter
    public ApplicationState getInsertReservation() {
        return insertReservation;
    }

    public ApplicationState getPrepareReservation() {
        return prepareReservation;
    }

    public ApplicationState getManageReservation() {
        return manageReservation;
    }
}
