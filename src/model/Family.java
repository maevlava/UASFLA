package model;

import java.util.ArrayList;
import java.util.List;

public class Family extends Room {
    public Family() {
        this.minimumPrice = 2000000;
        String[] facilities = new String[]{"Private Jacuzzi", "Private Pool", "Free Breakfast for 3", "Eligible to request menu(dinner only)"};
        this.facilities.addAll(List.of(facilities));
    }

    @Override
    public ArrayList<String> getFacilities() {
        this.prepared = true;
        return this.facilities;
    }
}
