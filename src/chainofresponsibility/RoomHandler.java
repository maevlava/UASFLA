package chainofresponsibility;

import model.Pelanggan;

public interface RoomHandler {
    void nextHandler(RoomHandler handler);
    void checkBooking(Resepsionis resepsionis);
}
