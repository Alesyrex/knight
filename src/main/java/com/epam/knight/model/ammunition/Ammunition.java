package com.epam.knight.model.ammunition;

public interface Ammunition {
    String WEIGHT_TO_STRING = ", weight=";
    String COST_TO_STRING = ", cost=";
    String BRACE_TO_STRING = "}";

    int getWeight();

    int getCost();

}
