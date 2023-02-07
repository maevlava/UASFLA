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

        System.out.print("\n>> ");
        int indexKamar = sc.nextInt() - 1;sc.nextLine();

        resepsionis.askRoomHandlerPrepare(indexKamar);
    }


    @Override
    public void exit() {

    }
}
