package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.CostComparator;
import com.epam.knight.model.ammunition.WeightComparator;
import com.epam.knight.model.menu.ItemMenuFields;
import com.epam.knight.model.menu.MainMenuFields;
import com.epam.knight.view.AmmunitionView;
import com.epam.knight.view.EquipView;
import com.epam.knight.view.KnightView;

import java.util.Comparator;

/**
 * Handles main menu and all operations with knight.
 */
public class KnightController {
    private final AmmunitionGenerator newItem = new AmmunitionGenerator();
    private final Knight knight = KnightGenerator.generateKnight();
    private final KnightAmmunitionManager manager = new KnightAmmunitionManager(knight);
    private final AmmunitionView itemShow = new AmmunitionView();
    private boolean run = true;

    public void operationsKnight(int choice) {

        if (choice == MainMenuFields.KNIGHT_STATS_MENU_POINT.getId()) {
            knightStats();
        } else if (choice == MainMenuFields.SHOW_ITEM_MENU_POINT.getId()) {
            showAmmunition();
        } else if (choice == MainMenuFields.EQUIP_ITEM_MENU_POINT.getId()) {
            equipAmmunition();
        } else if (choice == MainMenuFields.SORT_ITEM_MENU_POINT.getId()) {
            sortAmmunition();
        } else if (choice == MainMenuFields.SEARCH_ITEM_MENU_POINT.getId()) {
            searchAmmunition();
        } else {
            exitProgram();
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

    public void equipAmmunition() {
        EquipView equip = new EquipView();
        if (!knight.isFullAmmunition()) {
            Ammunition item;
            equip.equipMenu();
            if (equip.selectEquipMenu() == AmmunitionType.SWORD.getId()) {
                item = newItem.generateAmmunition(AmmunitionType.SWORD, equip.inputStats(AmmunitionType.SWORD));
                manager.equipAmmunitionToKnight(item);
            } else {
                item = newItem.generateAmmunition(AmmunitionType.HELMET, equip.inputStats(AmmunitionType.HELMET));
                manager.equipAmmunitionToKnight(item);
            }
            manager.setKnightStats();
        } else {
            equip.printFullAmmunition();
        }
    }

    public void sortAmmunition() {
        itemShow.printSortMenu();
        if (itemShow.choiceOption() == ItemMenuFields.COST_MENU_POINT.getId()) {
            Comparator<Ammunition> costComparator = new CostComparator();
            manager.sortKnightAmmunition(costComparator);
            showAmmunition();
        } else {
            Comparator<Ammunition> weightComparator = new WeightComparator();
            manager.sortKnightAmmunition(weightComparator);
            showAmmunition();
        }
    }

    public void searchAmmunition() {
        itemShow.printSearchMenu();
        if (itemShow.choiceOption() == ItemMenuFields.COST_MENU_POINT.getId()) {
            showSearchField(ItemMenuFields.COST_MENU_POINT);
        } else {
            showSearchField(ItemMenuFields.WEIGHT_MENU_POINT);
        }
    }

    public void showSearchField(ItemMenuFields field) {
        int minRange;
        itemShow.printInputMin(ItemMenuFields.COST_MENU_POINT.getTextField());
        minRange = itemShow.setRange();

        int maxRange;
        itemShow.printInputMax(ItemMenuFields.WEIGHT_MENU_POINT.getTextField());
        maxRange = itemShow.setRange();

        if (minRange > maxRange) {
            int temp = maxRange;
            maxRange = minRange;
            minRange = temp;
        }
        for (Ammunition item : knight.getAmmunition()) {
            if (field == ItemMenuFields.COST_MENU_POINT) {
                itemShow.printAmmunition(manager.searchCostField(item, minRange, maxRange));
            }
            if (field == ItemMenuFields.WEIGHT_MENU_POINT) {
                itemShow.printAmmunition(manager.searchWeightField(item, minRange, maxRange));
            }
        }
    }

    public void exitProgram() {
        run = false;
    }
    public boolean isRun() {
        return run;
    }
}
