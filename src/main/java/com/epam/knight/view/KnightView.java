package com.epam.knight.view;

import com.epam.knight.model.Knight;

public class KnightView {

    public static final String AMMUNITION_COST = "Ammunition cost: ";
    public static final String AMMUNITION_WEIGHT = "Ammunition weight: ";
    public static final String AMMUNITION_DAMAGE = "Ammunition damage: ";
    public static final String AMMUNITION_PROTECTION = "Ammunition protection: ";

    public void printKnightStats(Knight knight) {
        System.out.println(AMMUNITION_COST + knight.getCost());
        System.out.println(AMMUNITION_WEIGHT + knight.getWeight());
        System.out.println(AMMUNITION_DAMAGE + knight.getDamage());
        System.out.println(AMMUNITION_PROTECTION + knight.getProtection());
    }
}
