package state;

import chainofresponsibility.Resepsionis;
import model.Pelanggan;
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
        showReservation(resepsionis);

        System.out.print("\n>> ");
        int indexKamar = sc.nextInt() - 1;sc.nextLine();

        resepsionis.askRoomHandlerPrepare(indexKamar);
    }
    private void showReservation(Resepsionis resepsionis) {
        System.out.println("Berikut adalah Kamar-kamar yang telah di book");
        int i = 1;
        for (Room room :
                resepsionis.pelanggan.reservation) {
            if (room.prepared) {
                System.out.println(i + " Kamar:  " + room.getClass().getSimpleName() + " (prepared)");
                System.out.print("Facilities:");
                for (int j = 0; j < room.facilities.size(); j++) {
                    if (j == 0) {
                        System.out.println(" " + room.facilities.get(j));
                    }
                    System.out.println("\t\t\t" + room.facilities.get(j));
                }
                System.out.println("");
            } else {
                System.out.println(i + " Kamar:  " + room.getClass().getSimpleName());
            }
            i++;
        }
    }


    @Override
    public void exit() {

    }
}
