package model;

public class Reservation {
    public Room room;
    public int priceOffered;

    public Reservation(Room room, int priceOffered) {
        this.room = room;
        this.priceOffered = priceOffered;
    }
}
