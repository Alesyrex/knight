package com.epam.knight.model.ammunition;

public class Sword extends AbstractAmmunitionForAttack {

    public Sword() {

    }

    public Sword(int inDamage, int inWeight, int inCost) {
        super(inDamage, inWeight, inCost);
    }

    public String getName() {
        return "Sword";
    }
}
