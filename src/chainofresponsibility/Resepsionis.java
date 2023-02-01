package chainofresponsibility;

import model.Pelanggan;

public class Resepsionis {
    String roomRequest;
    int priceOffered;
    Pelanggan pelanggan;

    public Resepsionis(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public void askRoomHandlerHelp(String roomRequest, int priceOffered) {

        this.priceOffered = priceOffered;
        this.roomRequest = roomRequest;

        // ini kalau pake factory keknya enak anjay, berarti combonya sama factory
        RoomHandler regulerHandler = new RegulerHandler();
        RoomHandler familyHandler = new FamilyHandler();
        RoomHandler royalHandler = new RoyalHandler();

        // ask every handler
        royalHandler.nextHandler(familyHandler);
        familyHandler.nextHandler(regulerHandler);
        regulerHandler.nextHandler(null);


        royalHandler.checkBooking(this);
    }

    public String getRoomRequest() {
        return roomRequest;
    }

    public int getPriceOffered() {
        return priceOffered;
    }
}
