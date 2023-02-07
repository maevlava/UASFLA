package state;

import chainofresponsibility.Resepsionis;
import model.Pelanggan;
import model.Room;

import java.util.Scanner;

public class ManageReservation implements ApplicationState {

    Application application;
    Scanner sc = new Scanner(System.in);

    public ManageReservation(Application application) {
        this.application = application;
    }


    @Override
    public void runSubProgram(Pelanggan pelanggan) {
        Resepsionis resepsionis = new Resepsionis(pelanggan);
        int choice = menuChoice();
        switch (choice) {
            case 1 -> {
                resepsionis.showReservation();
                resepsionis.upgradeReservation();
            }
            case 2 -> {
                resepsionis.showReservation();
                resepsionis.deleteReservation();
            }
        }
    }
    private int menuChoice() {
        int choice = 0;
        System.out.println("1. Meningkatkan reservasi");
        System.out.println("2. Membatalkan reservasi ");
        choice = sc.nextInt();sc.nextLine();
        return choice;
    }

    @Override
    public void exit() {

    }
}
