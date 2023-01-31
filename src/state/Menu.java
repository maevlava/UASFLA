package state;

public class Menu implements MenuState{

    MenuState insertReservation;
    MenuState prepareReservation;
    MenuState manageReservation;

    MenuState menuState;

    // Initialize states objects
    public Menu() {
        this.insertReservation = new InsertReservation(this);
        this.prepareReservation = new PrepareReservation(this);
        this.manageReservation = new ManageReservation(this);
    }

    // State Pattern
    public void setMenuState(MenuState newState) {
        this.menuState = newState;
    }

    @Override
    public void showMenu() {
        menuState.showMenu();
    }

    @Override
    public void doThings() {
        menuState.doThings();
    }

    @Override
    public void exit() {
        menuState.exit();
    }


    // State Getter
    public MenuState getInsertReservation() {
        return insertReservation;
    }

    public MenuState getPrepareReservation() {
        return prepareReservation;
    }

    public MenuState getManageReservation() {
        return manageReservation;
    }
}
