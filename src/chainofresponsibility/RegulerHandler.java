package chainofresponsibility;

import model.Pelanggan;
import model.Reguler;
import model.Royal;

public class RegulerHandler implements RoomHandler {

    RoomHandler handler;

    @Override
    public void nextHandler(RoomHandler handler) {
        this.handler = handler;
    }

    @Override
    public void checkBooking(Pelanggan pelanggan, String room, int price) {
        if (room.equals("Reguler") && price >= 1000000) {
            System.out.println("You have successfully book the room");
            pelanggan.reservation.add(new Reguler());
            return;
        }
        System.out.println("Harga tidak memadai");
    }

}
