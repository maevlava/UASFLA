package state;

import java.util.Scanner;

public class ReservationMenu implements MenuState {

    Scanner sc;
    Menu menu;

    public ReservationMenu(Menu menu) {
        this.menu = menu;
        sc = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("1. Insert Reservation");
        System.out.println("2. Prepare Reservation");
        System.out.println("3. Manage Reservation");
        System.out.println("4. Exit");
        doThings();
    }

    @Override
    public void doThings() {
        int choice = 0;
        System.out.print(">> ");
        choice = sc.nextInt();sc.nextLine();

        switch (choice) {
            case 1 -> menu.setMenuState(menu.getInsertReservation());
            case 4 -> this.menuExit();
        }
    }

    @Override
    public void menuExit() {
        System.out.println("Thank you");
        menuExit();
    }
}
