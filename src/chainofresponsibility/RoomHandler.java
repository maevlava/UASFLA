package chainofresponsibility;

import model.Pelanggan;
import model.Room;

public interface RoomHandler {
    void nextHandler(RoomHandler handler);
    void checkBooking(Resepsionis resepsionis);

    void prepareFacilities(Room roomToBePrepared);
}
