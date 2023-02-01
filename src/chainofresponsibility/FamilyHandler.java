package chainofresponsibility;

import model.Family;
import model.Pelanggan;
import model.Royal;
import proxy.GetRoomData;
import proxy.RoomProxy;

import java.util.Scanner;

public class FamilyHandler implements RoomHandler {

    Scanner sc = new Scanner(System.in);
    RoomHandler nextHandler;
    GetRoomData familyProxy;

    @Override
    public void nextHandler(RoomHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void checkBooking(Resepsionis resepsionis) {
            familyProxy = new RoomProxy("Family");

            if (resepsionis.priceOffered >= familyProxy.getMinimumPrice()) {

                System.out.println("Coba Book family room?: Y | N");

                if (sc.nextLine().toLowerCase().equals("y")) {
                    System.out.println("You have successfully book Family room");
                    resepsionis.pelanggan.reservation.add(new Family());
                    return;
                }

            } else {
                System.out.println("Harga tidak memadai");
            }

            nextHandler.checkBooking(resepsionis);
    }
}
