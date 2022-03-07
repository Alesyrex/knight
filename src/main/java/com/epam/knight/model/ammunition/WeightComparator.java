package com.epam.knight.model.ammunition;

import java.io.Serializable;
import java.util.Comparator;

public class WeightComparator implements Comparator<Ammunition>, Serializable {
    private static final long serialVersionUID = 1;
    @Override
    public int compare(Ammunition item1, Ammunition item2) {
        return item1.getWeight() - item2.getWeight();
    }
}
