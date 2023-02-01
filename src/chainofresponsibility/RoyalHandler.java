package chainofresponsibility;

import model.Pelanggan;
import model.Royal;
import proxy.GetRoomData;
import proxy.RoomProxy;

public class RoyalHandler implements RoomHandler {

    RoomHandler nextHandler;
    GetRoomData royalProxy;

    @Override
    public void nextHandler(RoomHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void checkBooking(Resepsionis resepsionis) {

        if(resepsionis.roomRequest.equals("Royal")) {
            royalProxy = new RoomProxy("Royal");

            if (resepsionis.priceOffered >= royalProxy.getMinimumPrice()) {
                System.out.println("You have successfully book Royal room");
                resepsionis.pelanggan.reservation.add(new Royal());
                return;
            }

            System.out.println("Harga tidak memadai");
        }
        nextHandler.checkBooking(resepsionis);
    }
}
