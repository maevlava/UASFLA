package chainofresponsibility;

public class RegulerHandler implements RoomHandler {

    RoomHandler handler;

    @Override
    public void nexthandler(RoomHandler handler) {
        this.handler = handler;
    }

    @Override
    public void checkBooking() {

    }
    
}
