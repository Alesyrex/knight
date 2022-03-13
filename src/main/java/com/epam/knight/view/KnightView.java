package com.epam.knight.view;

import com.epam.knight.model.KnightAmmunitionManager;

public class KnightView {

    public static final String AMMUNITION_COST = "Ammunition cost: ";
    public static final String AMMUNITION_WEIGHT = "\nAmmunition weight: ";
    public static final String AMMUNITION_DAMAGE = "\nAmmunition damage: ";
    public static final String AMMUNITION_PROTECTION = "\nAmmunition protection: ";

    private final ConsoleView consoleView = new ConsoleView();

    public void printKnightStats(KnightAmmunitionManager manager) {
        String knightStats = AMMUNITION_COST + manager.calculateAmmunitionCost() +
                AMMUNITION_WEIGHT + manager.calculateAmmunitionWeight() +
                AMMUNITION_DAMAGE + manager.calculateAmmunitionDamage() +
                AMMUNITION_PROTECTION + manager.calculateAmmunitionProtection();
        consoleView.print(knightStats);
    }
}
