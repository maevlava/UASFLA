package chainofresponsibility;

import model.Pelanggan;

public interface RoomHandler {
    void nextHandler(RoomHandler handler);
    void checkBooking(Pelanggan pelanggan, String room, int price);
}
