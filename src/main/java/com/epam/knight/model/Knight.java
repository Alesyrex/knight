package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;

/**
 * Stores equipped ammunition and calculated stats.
 */
public class Knight {
    public static final int MAX_AMMUNITION = 5;

    private final Ammunition[] ammunition;
    private int cost;
    private int weight;
    private int damage;
    private int protection;
    private int ammunitionCount;
    private boolean fullAmmunition;

    public Knight() {
        this.ammunition = new Ammunition[MAX_AMMUNITION];
    }

    public Ammunition[] getAmmunition() {
        return ammunition.clone();
    }

    public void setAmmunition(Ammunition[] inAmmunition) {
        System.arraycopy(inAmmunition,0,this.ammunition,0,inAmmunition.length);
    }

    /**
     * Add new ammunition element to knight
     *
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        for (int i = 0;i < ammunition.length;++i) {
            if (ammunition[i] == null) {
                ammunitionCount++;
                ammunition[i] = element;
                break;
            }
        }
        if (ammunitionCount == MAX_AMMUNITION) {
            fullAmmunition = true;
        }
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getDamage() {
        return damage;
    }

    public int getProtection() {
        return protection;
    }

    public boolean isFullAmmunition() {
        return fullAmmunition;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getAmmunitionCount() {
        return ammunitionCount;
    }
}

