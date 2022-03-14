package com.epam.knight.model.ammunition;

public abstract class AbstractAmmunitionForAttack implements Ammunition {
    private int damage;
    private int weight;
    private int cost;

    protected AbstractAmmunitionForAttack() {

    }

    protected AbstractAmmunitionForAttack(int inDamage, int inWeight, int inCost) {
        damage = inDamage;
        weight = inWeight;
        cost = inCost;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
