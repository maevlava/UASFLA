package chainofresponsibility;

import model.Family;
import model.Pelanggan;
import model.Room;
import model.Royal;
import proxy.GetRoomData;
import proxy.RoomProxy;

import java.util.Scanner;

public class FamilyHandler implements RoomHandler {

    Scanner sc = new Scanner(System.in);
    RoomHandler nextHandler;
    GetRoomData familyProxy;
    public FamilyHandler() {
        familyProxy = new RoomProxy("Family");
    }

    @Override
    public void nextHandler(RoomHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void checkBooking(Resepsionis resepsionis) {

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

    @Override
    public void prepareFacilities(Room roomToBePrepared) {
        if (roomToBePrepared instanceof Family) {
            roomToBePrepared.prepared = true;
            for (int i = 0; i < familyProxy.getFacilities().size() ; i++) {
                System.out.println(i+1 + " " + familyProxy.getFacilities().get(i));
            }
            System.out.println("Baik fasilitas jenis " + roomToBePrepared.getClass().getSimpleName() + " Telah disiapkan");
            return;
        }
        nextHandler.prepareFacilities(roomToBePrepared);
    }
}
