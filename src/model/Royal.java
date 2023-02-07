package model;

import java.util.ArrayList;
import java.util.List;

public class Royal extends Room {
    public Royal() {
        this.minimumPrice = 4000000;
        String[] facilities = new String[]{"Private Jacuzzi", "Private Pool", "Free Breakfast for 4", "Eligible to request menu(all day serve)"};
        this.facilities.addAll(List.of(facilities));
    }

    @Override
    public ArrayList<String> getFacilities() {
        this.prepared = true;
        return this.facilities;
    }
}
