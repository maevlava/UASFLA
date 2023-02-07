package chainofresponsibility;

import model.*;
import proxy.RoomProxy;

public class RegulerHandler extends MasterHandler{


    public RegulerHandler() {
        this.roomProxy = new RoomProxy("Reguler");
    }
    @Override
    public void nextHandler(RoomHandler handler) {
        this.nexHandler = handler;
    }

    @Override
    public void checkBooking(Resepsionis resepsionis) {

            if (resepsionis.priceOffered >= roomProxy.getMinimumPrice()) {

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
            for (int i = 0; i < this.roomProxy.getFacilities().size() ; i++) {
                System.out.println(i+1 + " " + this.roomProxy.getFacilities().get(i));
            }
            System.out.println("Baik fasilitas jenis " + roomToBePrepared.getClass().getSimpleName() + " Telah disiapkan");
            return;
        }
        this.nexHandler.prepareFacilities(roomToBePrepared);
    }

}
