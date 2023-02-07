package state;

import chainofresponsibility.Resepsionis;
import model.Pelanggan;
import model.Reservation;
import model.Room;

import java.util.Scanner;

public class PrepareReservation implements ApplicationState {

    Scanner sc = new Scanner(System.in);
    Application application;
    public PrepareReservation(Application application) {
        this.application = application;
    }

    @Override
    public void runSubProgram(Pelanggan pelanggan) {
        Resepsionis resepsionis = new Resepsionis(pelanggan);
        resepsionis.showReservation();

        int indexKamar = 0;

        do {
            System.out.print("\n>> ");
            indexKamar = sc.nextInt() - 1;sc.nextLine();

        }while(indexKamar > pelanggan.reservation.size());

        resepsionis.askRoomHandlerPrepare(indexKamar);
    }


    @Override
    public void exit() {

    }
}
