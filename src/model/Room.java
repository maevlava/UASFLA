package model;

import proxy.GetRoomData;

public class Room implements GetRoomData {

    public int minimumPrice;

    @Override
    public int getMinimumPrice() {
        return new Room().getMinimumPrice();
    }

    @Override
    public void getFacilitates() {

    }
}
