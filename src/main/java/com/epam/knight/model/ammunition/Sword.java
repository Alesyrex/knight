package com.epam.knight.model.ammunition;

public class Sword extends AbstractAmmunitionForAttack {
    public static final String SWORD_TO_STRING = "Sword{damage=";

    public Sword() {

    }

    public Sword(int inDamage, int inWeight, int inCost) {
        super(inDamage, inWeight, inCost);
    }

    @Override
    public String toString() {
        return SWORD_TO_STRING + this.getDamage() + WEIGHT_TO_STRING + this.getWeight() +
                COST_TO_STRING + this.getCost() + BRACE_TO_STRING;
    }
}
