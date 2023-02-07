package model;

import chainofresponsibility.Resepsionis;
import chainofresponsibility.RoomHandler;
import proxy.GetRoomData;

import java.util.Scanner;

public class MasterHandler implements RoomHandler {
    protected Scanner sc = new Scanner(System.in);
    public RoomHandler nexHandler;
    public GetRoomData roomProxy;

    @Override
    public void nextHandler(RoomHandler handler) {

    }

    @Override
    public void checkBooking(Resepsionis resepsionis) {

    }

    @Override
    public void prepareFacilities(Room roomToBePrepared) {

    }
}
