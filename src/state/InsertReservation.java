package state;

import chainofresponsibility.FamilyHandler;
import chainofresponsibility.RegulerHandler;
import chainofresponsibility.RoomHandler;
import chainofresponsibility.RoyalHandler;
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
        insertPelangganData(pelanggan);

    }

    private void insertPelangganData(Pelanggan pelanggan) {
        System.out.print("Mohon masukkan nama: ");
        pelanggan.nama += sc.nextLine();
        System.out.print("\nMasukkan tipe Kamar: \"Royal\" | \"Family\" | \"Reguler\" ");
        String kamar = sc.nextLine();
        System.out.print("\nMasukkan Harga: ");
        int harga = sc.nextInt();sc.nextLine();

        askRoomHandlerHelp(pelanggan, kamar, harga);
    }
    private void askRoomHandlerHelp(Pelanggan pelanggan, String room, int price) {
        // ini kalau pake factory keknya enak anjay, berarti combonya sama factory
        RoomHandler regulerHandler = new RegulerHandler();
        RoomHandler familyHandler = new FamilyHandler();
        RoomHandler royalHandler = new RoyalHandler();

        // ask every handler
        royalHandler.nextHandler(familyHandler);
        familyHandler.nextHandler(regulerHandler);

        royalHandler.checkBooking(pelanggan, room, price);

    }


    @Override
    public void exit() {

    }
}
