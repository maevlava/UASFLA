package state;

import model.Pelanggan;

import java.util.Scanner;

public class ReservationApplication implements ApplicationState {

    Scanner sc;
    Application application;

    public ReservationApplication(Application application) {
        this.application = application;
        sc = new Scanner(System.in);
    }

    @Override
    public void runSubProgram(Pelanggan pelanggan) {

        int choice = 4;

        do {
            choice = menu();
            switch (choice) {
                case 1 -> application.setApplicationState(application.getInsertReservation());
                case 2 -> application.setApplicationState(application.getPrepareReservation());
                case 3 -> application.setApplicationState(application.getManageReservation());
                case 4 -> exit();
            }
            application.runSubProgram(pelanggan);
        }while(choice != 4);

    }

    int menu() {
        int choice;
        System.out.println("1. Insert Reservation");
        System.out.println("2. Prepare Reservation");
        System.out.println("3. Manage Reservation");
        System.out.println("4. Exit");
        System.out.print(">> ");
        choice = sc.nextInt();sc.nextLine();

        return choice;
    }


    @Override
    public void exit() {
        System.out.println("Thank you");
        System.exit(1);
    }
}
