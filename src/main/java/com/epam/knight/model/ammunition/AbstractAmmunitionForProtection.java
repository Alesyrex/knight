package com.epam.knight.model.ammunition;

public abstract class AbstractAmmunitionForProtection implements Ammunition {
    private int protection;
    private int weight;
    private int cost;

    public AbstractAmmunitionForProtection() {

    }

    public AbstractAmmunitionForProtection(int inProtection, int inWeight, int inCost) {
        protection = inProtection;
        weight = inWeight;
        cost = inCost;
    }

    public int getProtection() {
        return protection;
    }

    public abstract String getName();

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
