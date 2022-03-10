package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.CostComparator;
import com.epam.knight.model.ammunition.WeightComparator;
import com.epam.knight.view.AmmunitionView;
import com.epam.knight.view.EquipView;
import com.epam.knight.view.KnightView;

import java.util.Comparator;

/**
 * Handles main menu and all operations with knight.
 */
public class KnightController {
    public static final int CASE_ONE = 1;
    public static final int CASE_TWO = 2;
    public static final int CASE_THREE = 3;
    public static final int CASE_FOUR = 4;
    public static final int CASE_FIVE = 5;
    public static final String COST = "cost";
    public static final String WEIGHT = "weight";

    private final AmmunitionGenerator newItem = new AmmunitionGenerator();
    private final Knight knight = KnightGenerator.generateKnight();
    private final KnightAmmunitionManager manager = new KnightAmmunitionManager(knight);
    private final AmmunitionView itemShow = new AmmunitionView();
    private boolean run = true;

    public void operationsKnight(int choice) {

        switch (choice) {
            case CASE_ONE :
                knightStats();
                break;
            case CASE_TWO :
                showAmmunition();
                break;
            case CASE_THREE :
                equipAmmunition();
                break;
            case CASE_FOUR :
                sortAmmunition();
                break;
            case CASE_FIVE :
                searchAmmunition();
                break;
            default :
                run = false;
                break;
        }
    }

    public void equipAmmunition() {
        EquipView equip = new EquipView();
        if (!knight.isFullAmmunition()) {
            Ammunition item;
            equip.equipMenu();
            switch (equip.selectEquipMenu()) {
                case SWORD:
                    item = newItem.generateAmmunition(AmmunitionType.SWORD, equip.inputStats(AmmunitionType.SWORD));
                    manager.equipAmmunitionToKnight(item);
                    break;
                case HELMET:
                    item = newItem.generateAmmunition(AmmunitionType.HELMET, equip.inputStats(AmmunitionType.HELMET));
                    manager.equipAmmunitionToKnight(item);
                    break;
                default:
                    break;
            }
            manager.setKnightStats();
        } else {
            equip.printFullAmmunition();
        }
    }

    public void knightStats() {
        KnightView knightStats = new KnightView();
        knightStats.printKnightStats(knight);
    }

    public void showAmmunition() {
        for (Ammunition item : knight.getAmmunition()) {
            if (item != null) {
                itemShow.printAmmunition(item);
            }
        }
    }

    public void sortAmmunition() {
        itemShow.printSortMenu();
        switch (itemShow.choiceOption()) {
            case CASE_ONE :
                Comparator<Ammunition> costComparator = new CostComparator();
                manager.sortKnightAmmunition(costComparator);
                showAmmunition();
                break;
            case CASE_TWO :
                Comparator<Ammunition> weightComparator = new WeightComparator();
                manager.sortKnightAmmunition(weightComparator);
                showAmmunition();
                break;
            default :
                break;
        }
    }

    public void searchAmmunition() {
        itemShow.printSearchMenu();
        switch (itemShow.choiceOption()) {
            case CASE_ONE :
                showSearchField(COST);
                break;
            case CASE_TWO :
                showSearchField(WEIGHT);
                break;
            default :
                break;
        }
    }

    public void showSearchField(String field) {
        int minRange;
        itemShow.printInputMin(field);
        minRange = itemShow.setRange();

        int maxRange;
        itemShow.printInputMax(field);
        maxRange = itemShow.setRange();

        if (minRange > maxRange) {
            int temp = maxRange;
            maxRange = minRange;
            minRange = temp;
        }
        for (Ammunition item : knight.getAmmunition()) {
            if (field.equals(COST)) {
                itemShow.printAmmunition(manager.searchCostField(item, minRange, maxRange));
            }
            if (field.equals(WEIGHT)) {
                itemShow.printAmmunition(manager.searchWeightField(item, minRange, maxRange));
            }
        }
    }

    public boolean isRun() {
        return run;
    }
}
