package com.epam.knight.controller;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;

/**
 * Generates pieces of {@link Ammunition}.
 */
public class AmmunitionGenerator {
    public static final int INDEX_ZERO = 0;
    public static final int INDEX_ONE = 1;
    public static final int INDEX_TWO = 2;
    private Ammunition item;

    public Ammunition generateAmmunition(AmmunitionType type, int[] stats) {
        switch (type) {
            case SWORD:
                item = new Sword(stats[INDEX_TWO], stats[INDEX_ZERO], stats[INDEX_ONE]);
                break;
            case HELMET:
                item = new Helmet(stats[INDEX_TWO], stats[INDEX_ZERO], stats[INDEX_ONE]);
                break;
            default:
                break;
        }
        return item;
    }
}
