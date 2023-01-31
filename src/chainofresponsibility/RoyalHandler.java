package chainofresponsibility;

public class RoyalHandler implements RoomHandler {

    RoomHandler nextHandler;

    @Override
    public void nexthandler(RoomHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void checkBooking() {

    }
}
