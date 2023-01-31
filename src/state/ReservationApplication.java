package state;

import java.util.Scanner;

public class ReservationApplication implements ApplicationState {

    Scanner sc;
    Application application;

    public ReservationApplication(Application application) {
        this.application = application;
        sc = new Scanner(System.in);
    }

    @Override
    public void runSubProgram() {
        int choice = 0;
        System.out.print(">> ");
        choice = sc.nextInt();sc.nextLine();

        switch (choice) {
            case 1 -> application.setApplicationState(application.getInsertReservation());
            case 4 -> this.exit();
        }
    }

    @Override
    public void exit() {
        System.out.println("Thank you");
    }
}
