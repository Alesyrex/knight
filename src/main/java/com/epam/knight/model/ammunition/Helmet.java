package com.epam.knight.model.ammunition;

public class Helmet extends AbstractAmmunitionForProtection {
    public static final String HELMET_TO_STRING = "Helmet{protection=%d, weight=%d, cost=%d}";

    public Helmet() {

    }

    public Helmet(int inProtection, int inWeight, int inCost) {
        super(inProtection, inWeight, inCost);
    }

    @Override
    public String toString() {
        return String.format(HELMET_TO_STRING, this.getProtection(), this.getWeight(), this.getCost());
    }
}
