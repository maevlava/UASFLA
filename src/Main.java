import state.Application;

public class Main {

    Application reservationApp;
    public Main() {
        reservationApp = new Application();
        reservationApp.run();
    }

    public static void main(String[] args) {
        new Main();
    }
}
