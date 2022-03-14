package com.epam.knight.controller;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;

/**
 * Generates pieces of {@link Ammunition}.
 */
public class AmmunitionGenerator {
    public static final int INDEX_WEIGHT = 0;
    public static final int INDEX_COST = 1;
    public static final int INDEX_DAMAGE_OR_PROTECTION = 2;


    public Ammunition generateAmmunition(AmmunitionType type, int[] stats) {
        Ammunition item;
        switch (type) {
            case SWORD:
                item = new Sword(stats[INDEX_DAMAGE_OR_PROTECTION], stats[INDEX_WEIGHT], stats[INDEX_COST]);
                break;
            case HELMET:
                item = new Helmet(stats[INDEX_DAMAGE_OR_PROTECTION], stats[INDEX_WEIGHT], stats[INDEX_COST]);
                break;
            default:
                item = null;
                break;
        }
        return item;
    }
}
