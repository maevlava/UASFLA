package proxy;

import model.Family;
import model.Reguler;
import model.Room;
import model.Royal;

import java.util.ArrayList;

public class RoomProxy implements GetRoomData {

    Room roomPlaceHolder;

    public RoomProxy(String types) {
        if (types.equals("Royal")) {
            roomPlaceHolder = new Royal();
        }else if (types.equals("Family")) {
            roomPlaceHolder = new Family();
        } else {
            roomPlaceHolder = new Reguler();
        }
    }

    @Override
    public int getMinimumPrice() {
        return roomPlaceHolder.getMinimumPrice();
    }

    @Override
    public ArrayList<String> getFacilities() {
        return roomPlaceHolder.getFacilities();
    }
}
