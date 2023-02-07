package state;

import chainofresponsibility.*;
import model.Pelanggan;
import model.Reguler;

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
        if (pelanggan.nama.equals("")) {
            do{
                System.out.print("Mohon masukkan nama: ");
                pelanggan.nama = sc.nextLine();
            }while(pelanggan.nama.length() < 1);
        }
        String kamar = "";
        do{
            System.out.print("\nMasukkan tipe Kamar: \"Royal\" | \"Family\" | \"Reguler\" ");
            kamar = sc.nextLine();
        }while(!(kamar.equals("Royal") || kamar.equals("Reguler") || kamar.equals("Family")));

        System.out.print("\nMasukkan Harga: ");
        int harga = sc.nextInt();sc.nextLine();

        Resepsionis resepsionis = new Resepsionis(pelanggan);
        resepsionis.askRoomHandlerHelp(kamar, harga);
    }

    @Override
    public void exit() {

    }
}
