package com.epam.knight.model;

import com.epam.knight.model.ammunition.AbstractAmmunitionForAttack;
import com.epam.knight.model.ammunition.AbstractAmmunitionForProtection;
import com.epam.knight.model.ammunition.Ammunition;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Manipulates with knight's ammunition and updates knight stats.
 */
public class KnightAmmunitionManager {
    private final Knight knight;

    public KnightAmmunitionManager(Knight knight) {
        this.knight = knight;
    }

    /**
     * Equips item to knight and update knight's stats
     */
    public void equipAmmunitionToKnight(Ammunition item) {
        knight.equip(item);
    }

    public int calculateAmmunitionWeight() {
        int sumWeight = 0;
        if (knight.getAmmunition() != null) {
            for (Ammunition ammunition : knight.getAmmunition()) {
                sumWeight += ammunition.getWeight();
            }
        }
        return sumWeight;
    }

    public int calculateAmmunitionCost() {
        int sumCost = 0;
        if (knight.getAmmunition() != null) {
            for (Ammunition ammunition : knight.getAmmunition()) {
                sumCost += ammunition.getCost();
            }
        }
        return sumCost;
    }

    public int calculateAmmunitionDamage() {
        int sumDamage = 0;

        for (Ammunition am : knight.getAmmunition()) {
            if (am instanceof AbstractAmmunitionForAttack) {
                sumDamage += ((AbstractAmmunitionForAttack) am).getDamage();
            }
        }
        return sumDamage;
    }

    public int calculateAmmunitionProtection() {
        int sumProtection = 0;

        for (Ammunition am : knight.getAmmunition()) {
            if (am instanceof AbstractAmmunitionForProtection) {
                sumProtection += ((AbstractAmmunitionForProtection) am).getProtection();
            }
        }
        return sumProtection;
    }

    public void sortKnightAmmunition(Comparator<Ammunition> comparator) {
        Arrays.sort(knight.getAmmunition(), comparator);
    }

    public Ammunition searchWeightField(Ammunition ammunition, int minRange, int maxRange) {
        Ammunition item = null;
        if (ammunition.getWeight() >= minRange && ammunition.getWeight() <= maxRange) {
            item = ammunition;
        }
        return item;
    }

    public Ammunition searchCostField(Ammunition ammunition, int minRange, int maxRange) {
        Ammunition item = null;
        if (ammunition.getCost() >= minRange && ammunition.getCost() <= maxRange) {
            item = ammunition;
        }
        return item;
    }
}
