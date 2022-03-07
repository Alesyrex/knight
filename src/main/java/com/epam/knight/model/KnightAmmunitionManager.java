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
        for (Ammunition am : knight.getAmmunition()) {
            if (am != null) {
                sumWeight += am.getWeight();
            }
        }
        return sumWeight;
    }

    public int calculateAmmunitionCost() {
        int sumCost = 0;
        for (Ammunition am : knight.getAmmunition()) {
            if (am != null) {
                sumCost += am.getCost();
            }
        }
        return sumCost;
    }

    public int calculateAmmunitionDamage() {
        int sumDamage = 0;
        for (Ammunition am : knight.getAmmunition()) {
            if (am instanceof AbstractAmmunitionForAttack) {
                sumDamage = ((AbstractAmmunitionForAttack) am).getDamage();
            }
        }
        return sumDamage;
    }

    public int calculateAmmunitionProtection() {
        int sumProtection = 0;
        for (Ammunition am : knight.getAmmunition()) {
            if (am instanceof AbstractAmmunitionForProtection) {
                sumProtection = ((AbstractAmmunitionForProtection) am).getProtection();
            }
        }
        return sumProtection;
    }

    public void setKnightStats() {
        knight.setCost(calculateAmmunitionCost());
        knight.setWeight(calculateAmmunitionWeight());
        knight.setDamage(calculateAmmunitionDamage());
        knight.setProtection(calculateAmmunitionProtection());
    }

    public void sortKnightAmmunition(Comparator<Ammunition> comparator) {
        Ammunition[] copyItems = new Ammunition[knight.getAmmunitionCount()];
        System.arraycopy(knight.getAmmunition(),0, copyItems, 0, copyItems.length);
        Arrays.sort(copyItems, comparator);
        knight.setAmmunition(copyItems);
    }

    public Ammunition searchWeightField(Ammunition item, int minRange, int maxRange) {
        if (item != null && item.getWeight() >= minRange && item.getWeight() <= maxRange) {
            return item;
        } else {
            return null;
        }
    }

    public Ammunition searchCostField(Ammunition item, int minRange, int maxRange) {
        if (item != null && item.getCost() >= minRange && item.getCost() <= maxRange) {
            return item;
        } else {
            return null;
        }
    }
}
