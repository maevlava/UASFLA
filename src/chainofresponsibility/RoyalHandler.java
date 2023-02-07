package chainofresponsibility;

import model.*;
import proxy.GetRoomData;
import proxy.RoomProxy;

public class RoyalHandler implements RoomHandler {

    RoomHandler nextHandler;
    GetRoomData royalProxy;
    public RoyalHandler() {
        royalProxy = new RoomProxy("Royal");
    }

    @Override
    public void nextHandler(RoomHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void checkBooking(Resepsionis resepsionis) {

        if(resepsionis.roomRequest.equals("Royal")) {

            if (resepsionis.priceOffered >= royalProxy.getMinimumPrice()) {
                System.out.println("You have successfully book Royal room");
                Reservation newReservation = new Reservation(new Royal(), resepsionis.priceOffered);
                resepsionis.pelanggan.reservation.add(newReservation);
                return;
            }

            System.out.println("Harga tidak memadai");
        }
        nextHandler.checkBooking(resepsionis);
    }

    @Override
    public void prepareFacilities(Room roomToBePrepared) {
        if (roomToBePrepared instanceof Royal) {
            roomToBePrepared.prepared = true;

            for (int i = 0; i < royalProxy.getFacilities().size(); i++) {
                System.out.println( i+1 + " " + royalProxy.getFacilities().get(i));
            }

            System.out.println("Baik fasilitas jenis " + roomToBePrepared.getClass().getSimpleName() + " Telah disiapkan");
            return;
        }
        nextHandler.prepareFacilities(roomToBePrepared);
    }
}
