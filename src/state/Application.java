package state;

import model.Pelanggan;

public class Application implements ApplicationState {


    ApplicationState reservationMenu;
    ApplicationState insertReservation;
    ApplicationState prepareReservation;
    ApplicationState manageReservation;

    ApplicationState applicationState;
    Pelanggan pelanggan;

    // Initialize states objects
    public Application() {
        this.pelanggan = new Pelanggan();
        this.reservationMenu = new ReservationApplication(this);
        this.insertReservation = new InsertReservation(this);
        this.prepareReservation = new PrepareReservation(this);
        this.manageReservation = new ManageReservation(this);

        applicationState = reservationMenu;
    }
    public void run() {
        applicationState.runSubProgram(this.pelanggan);
    }

    // State Pattern
    public void setApplicationState(ApplicationState newState) {
        this.applicationState = newState;
    }

    @Override
    public void runSubProgram(Pelanggan pelanggan) {
        applicationState.runSubProgram(pelanggan);
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
