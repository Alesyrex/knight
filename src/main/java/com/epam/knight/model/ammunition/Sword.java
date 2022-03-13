package com.epam.knight.model.ammunition;

public class Sword extends AbstractAmmunitionForAttack {
    public static final String SWORD_TO_STRING = "Sword{damage=%d, weight=%d, cost=%d}";

    public Sword() {

    }

    public Sword(int inDamage, int inWeight, int inCost) {
        super(inDamage, inWeight, inCost);
    }

    @Override
    public String toString() {
        return String.format(SWORD_TO_STRING, this.getDamage(), this.getWeight(), this.getCost());
    }
}
