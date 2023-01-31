package proxy;

import model.Room;

public class RoomProxy implements GetRoomData {

    @Override
    public int getMinimumPrice() {
        return new Room().getMinimumPrice();
    }

    @Override
    public void getFacilitates() {

    }
}
