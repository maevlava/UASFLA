package chainofresponsibility;

public class FamilyHandler implements RoomHandler {

    RoomHandler handler;

    @Override
    public void nexthandler(RoomHandler handler) {
        this.handler = handler;
    }

    @Override
    public void checkBooking() {

    }
}
