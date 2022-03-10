package com.epam.knight.model.ammunition;

/**
 * Lists different types of ammunition.
 */
public enum AmmunitionType {
    SWORD("sword", "damage"),
    HELMET("helmet", "protection");

    private final String name;
    private final String feature;

    AmmunitionType(String name, String feature) {
        this.name = name;
        this.feature = feature;
    }


    public String getName() {
        return name;
    }

    public String getFeature() {
        return feature;
    }
}
