package chainofresponsibility;

import model.Pelanggan;
import model.Reguler;
import model.Royal;
import proxy.GetRoomData;
import proxy.RoomProxy;

import java.util.Scanner;

public class RegulerHandler implements RoomHandler {

    Scanner sc = new Scanner(System.in);
    RoomHandler handler;
    GetRoomData regulerProxy;

    @Override
    public void nextHandler(RoomHandler handler) {
        this.handler = handler;
    }

    @Override
    public void checkBooking(Resepsionis resepsionis) {

            regulerProxy = new RoomProxy("Reguler");

            if (resepsionis.priceOffered >= regulerProxy.getMinimumPrice()) {

                System.out.println("Book Reguler room?: Y | N");

                if(sc.nextLine().toLowerCase().equals("y")) {
                    System.out.println("You have successfully book Reguler room");
                    resepsionis.pelanggan.reservation.add(new Reguler());
                    return;
                }

            }

        System.out.println("Silahkan datang lain waktu, terima kasih");

    }

}
