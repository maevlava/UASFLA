package model;

import java.util.ArrayList;
import java.util.List;

public class Reguler extends Room {

    public Reguler() {
        this.minimumPrice = 1000000;
        String[] facilities = new String[]{"Mini Fridge", "Free Breakfast for 2"};
        this.facilities.addAll(List.of(facilities));
    }
    @Override
    public ArrayList<String> getFacilities() {
        this.prepared = true;
        return this.facilities;
    }
}
