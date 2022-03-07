package com.epam.knight.model.ammunition;

public class Helmet extends AbstractAmmunitionForProtection {

    public Helmet() {

    }

    public Helmet(int inProtection, int inWeight, int inCost) {
        super(inProtection, inWeight, inCost);
    }

    public String getName() {
        return "Helmet";
    }
}
