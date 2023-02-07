package chainofresponsibility;

import model.*;
import proxy.GetRoomData;
import proxy.RoomProxy;

import java.util.Scanner;

public class RegulerHandler implements RoomHandler {

    Scanner sc = new Scanner(System.in);
    RoomHandler nextHandler;
    GetRoomData regulerProxy;
    public RegulerHandler() {
        regulerProxy = new RoomProxy("Reguler");
    }
    @Override
    public void nextHandler(RoomHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void checkBooking(Resepsionis resepsionis) {

            if (resepsionis.priceOffered >= regulerProxy.getMinimumPrice()) {

                System.out.println("Book Reguler room?: Y | N");

                if(sc.nextLine().toLowerCase().equals("y")) {
                    System.out.println("You have successfully book Reguler room");
                    Reservation newReservation = new Reservation(new Reguler(), resepsionis.priceOffered);
                    resepsionis.pelanggan.reservation.add(newReservation);
                    return;
                }

            }

        System.out.println("Silahkan datang lain waktu, terima kasih");

    }

    @Override
    public void prepareFacilities(Room roomToBePrepared) {
        if (roomToBePrepared instanceof Family) {
            roomToBePrepared.prepared = true;
            for (int i = 0; i < regulerProxy.getFacilities().size() ; i++) {
                System.out.println(i+1 + " " + regulerProxy.getFacilities().get(i));
            }
            System.out.println("Baik fasilitas jenis " + roomToBePrepared.getClass().getSimpleName() + " Telah disiapkan");
            return;
        }
        nextHandler.prepareFacilities(roomToBePrepared);
    }

}
