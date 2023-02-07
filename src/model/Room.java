package model;

import proxy.GetRoomData;

import java.util.ArrayList;

public class Room implements GetRoomData {

    public int minimumPrice;
    public ArrayList<String> facilities;
    public boolean prepared;

    public Room() {
        this.facilities = new ArrayList<>();
        this.prepared = false;
    }

    @Override
    public int getMinimumPrice() {
        return this.minimumPrice;
    }

    @Override
    public ArrayList<String> getFacilities() {
        return facilities;
    }
}
