package com.epam.knight.model.ammunition;

import java.util.Comparator;

public class WeightComparator implements Comparator<Ammunition> {
    @Override
    public int compare(Ammunition item1, Ammunition item2) {
        return item1.getWeight() - item2.getWeight();
    }
}
