package model;

import proxy.GetRoomData;

public class Room implements GetRoomData {

    public int minimumPrice;

    @Override
    public int getMinimumPrice() {
        return this.minimumPrice;
    }

    @Override
    public void getFacilitates() {

    }
}
