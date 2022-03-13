package com.epam.knight.model.ammunition;

/**
 * Lists different types of ammunition.
 */
public enum AmmunitionType {
    SWORD(Constants.ID_ONE, Constants.NAME_SWORD, Constants.DAMAGE),
    HELMET(Constants.ID_TWO, Constants.NAME_HELMET, Constants.PROTECTION);

    private final int id;
    private final String name;
    private final String feature;

    AmmunitionType(int id, String name, String feature) {
        this.id = id;
        this.name = name;
        this.feature = feature;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFeature() {
        return feature;
    }

    private static class Constants {
        public static final String NAME_SWORD = "sword";
        public static final String NAME_HELMET = "helmet";
        public static final String DAMAGE = "damage";
        public static final String PROTECTION = "protection";
        public static final int ID_ONE = 1;
        public static final int ID_TWO = 2;
    }
}
