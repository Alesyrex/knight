package com.epam.knight.model.ammunition;

public class Helmet extends AbstractAmmunitionForProtection {
    public static final String HELMET_TO_STRING = "Helmet{protection=";

    public Helmet() {

    }

    public Helmet(int inProtection, int inWeight, int inCost) {
        super(inProtection, inWeight, inCost);
    }

    @Override
    public String toString() {
        return HELMET_TO_STRING + this.getProtection() + WEIGHT_TO_STRING + this.getWeight() +
                COST_TO_STRING + this.getCost() + BRACE_TO_STRING;
    }
}
