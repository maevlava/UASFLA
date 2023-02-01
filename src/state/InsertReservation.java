package state;

import chainofresponsibility.*;
import model.Pelanggan;

import java.util.Scanner;

public class InsertReservation implements ApplicationState {

    Application application;
    Scanner sc;
    public InsertReservation(Application app) {
        application = app;
        sc = new Scanner(System.in);
    }
    @Override
    public void runSubProgram(Pelanggan pelanggan) {
        bookKamar(pelanggan);
    }

    private void bookKamar(Pelanggan pelanggan) {
        System.out.print("Mohon masukkan nama: ");
        pelanggan.nama += sc.nextLine();
        System.out.print("\nMasukkan tipe Kamar: \"Royal\" | \"Family\" | \"Reguler\" ");
        String kamar = sc.nextLine();
        System.out.print("\nMasukkan Harga: ");
        int harga = sc.nextInt();sc.nextLine();

        Resepsionis resepsionis = new Resepsionis(pelanggan);
        resepsionis.askRoomHandlerHelp(kamar, harga);
    }

    @Override
    public void exit() {

    }
}
