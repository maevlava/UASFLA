package chainofresponsibility;

import model.*;
import proxy.RoomProxy;

import java.util.Scanner;

public class Resepsionis {
    String roomRequest;
    Scanner sc;
    int priceOffered;
    public Pelanggan pelanggan;

    public Resepsionis(Pelanggan pelanggan) {
        this.sc = new Scanner(System.in);
        this.pelanggan = pelanggan;
    }

    public void askRoomHandlerHelp(String roomRequest, int priceOffered) {

        this.priceOffered = priceOffered;
        this.roomRequest = roomRequest;

        // ini kalau pake factory keknya enak anjay, berarti combonya sama factory
        RoomHandler regulerHandler = new RegulerHandler();
        RoomHandler familyHandler = new FamilyHandler();
        RoomHandler royalHandler = new RoyalHandler();

        // ask every handler
        royalHandler.nextHandler(familyHandler);
        familyHandler.nextHandler(regulerHandler);
        regulerHandler.nextHandler(null);


        royalHandler.checkBooking(this);
    }

    public void askRoomHandlerPrepare(int indexKamar) {
        Room roomToBePrepared = pelanggan.reservation.get(indexKamar).room;

        RoomHandler regulerHandler = new RegulerHandler();
        RoomHandler familyHandler = new FamilyHandler();
        RoomHandler royalHandler = new RoyalHandler();

        // ask every handler
        royalHandler.nextHandler(familyHandler);
        familyHandler.nextHandler(regulerHandler);
        regulerHandler.nextHandler(null);

        royalHandler.prepareFacilities(roomToBePrepared);
    }
    public void showReservation() {
        if (pelanggan.reservation.size() < 1) {
            System.out.println("Belum ada reservasi, silahkan reservasi dulu");
            return;
        }
        System.out.println("Berikut adalah Kamar-kamar yang telah di book");
        int i = 1;
        for (Reservation reservation :
                this.pelanggan.reservation) {
            if (reservation.room.prepared) {
                System.out.println(i + " Kamar:  " + reservation.room.getClass().getSimpleName() + " (prepared)");
                System.out.print("Facilities:");
                for (int j = 0; j < reservation.room.facilities.size(); j++) {
                    if (j == 0)
                        System.out.println(" " + reservation.room.facilities.get(j));
                     else
                        System.out.println("\t\t\t" + reservation.room.facilities.get(j));
                }
                System.out.println("");
            } else {
                System.out.println(i + " Kamar:  " + reservation.room.getClass().getSimpleName());
            }
            i++;
        }
    }

    public void upgradeReservation(){
        int indexKamar = 0;

        do {
            System.out.print("\n>> ");
            indexKamar = sc.nextInt() - 1;sc.nextLine();

        }while(indexKamar > this.pelanggan.reservation.size());

        System.out.println("Masukkan harga tambahannya");
        int tambahanHarga = sc.nextInt();sc.nextLine();

        Reservation upReservation = pelanggan.reservation.get(indexKamar);
        if (upReservation.room instanceof Royal)
            System.out.println("Royal is the highest level we have");
        else if (upReservation.room instanceof Family) {
            if (upReservation.priceOffered + tambahanHarga <= new Royal().getMinimumPrice()) {
                System.out.println("Maaf Harga tidak cukup");
            } else {
                upReservation.room = new Royal();
            }
        } else if (upReservation.room instanceof Reguler) {
            if (upReservation.priceOffered + tambahanHarga <= new Family().getMinimumPrice()) {
                System.out.println("Maaf Harga tidak cukup");
            } else {
                upReservation.room = new Family();
            }
        }

        System.out.println("Kamar telah diupgrade jangan lupa untuk di prepare di menu prepare");
        System.out.println("PDF Telah dikirim ke email pelanggan");
    }
    public void deleteReservation() {
        int indexKamar = 0;

        do {
            System.out.print("\n>> ");
            indexKamar = sc.nextInt() - 1;sc.nextLine();

        }while(indexKamar > this.pelanggan.reservation.size());

        this.pelanggan.reservation.remove(indexKamar);
        System.out.println("Reservation telah dihilangkan, PDF telah dikirim ke email pelanggan");
    }

    public String getRoomRequest() {
        return roomRequest;
    }

    public int getPriceOffered() {
        return priceOffered;
    }
}
