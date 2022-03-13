package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;

/**
 * Stores equipped ammunition and calculated stats.
 */
public class Knight {

    private Ammunition[] ammunition;

    public Knight() {

    }

    public Ammunition[] getAmmunition() {
        return ammunition;
    }

    /**
     * Add new ammunition element to knight
     *
     * @param element that should be equipped to the knight
     */
    public void equip(Ammunition element) {
        if (ammunition != null) {
            Ammunition[] newAmmunition = new Ammunition[ammunition.length + 1];
            System.arraycopy(ammunition,0,newAmmunition,0,ammunition.length);
            newAmmunition[newAmmunition.length - 1] = element;
            ammunition = newAmmunition;
        } else {
            ammunition = new Ammunition[]{element};
        }
    }
}

