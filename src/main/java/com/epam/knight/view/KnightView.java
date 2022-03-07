package com.epam.knight.view;

import com.epam.knight.model.Knight;

public class KnightView {
    public void printKnightStats(Knight knight) {
        System.out.println("Ammunition cost: " + knight.getCost());
        System.out.println("Ammunition weight: " + knight.getWeight());
        System.out.println("Ammunition damage: " + knight.getDamage());
        System.out.println("Ammunition protection: " + knight.getProtection());
    }
}
