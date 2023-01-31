package chainofresponsibility;

public interface RoomHandler {
    void nexthandler(RoomHandler handler);
    void checkBooking();
}
