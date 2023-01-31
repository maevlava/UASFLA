package state;

public class InsertReservation implements MenuState {

    Menu menu;
    public InsertReservation(Menu menus) {
        menu = menus;
    }

    @Override
    public void showMenu() {
        System.out.println("ini adalah show menu");
    }

    @Override
    public void doThings() {

    }

    @Override
    public void exit() {

    }
}
