package chainofresponsibility;

import model.Family;
import model.Pelanggan;
import model.Royal;

public class FamilyHandler implements RoomHandler {

    RoomHandler handler;

    @Override
    public void nextHandler(RoomHandler handler) {
        this.handler = handler;
    }

    @Override
    public void checkBooking(Pelanggan pelanggan, String room, int price) {
        if (room.equals("Family") && price >= 4000000) {
            System.out.println("You have successfully book the room");
            pelanggan.reservation.add(new Family());
            return;
        }
        nextHandler(handler);
    }
}
