package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.KnightAmmunitionManager;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.comparator.CostComparator;
import com.epam.knight.model.comparator.WeightComparator;
import com.epam.knight.model.menu.ItemMenuFields;
import com.epam.knight.model.menu.MainMenuFields;
import com.epam.knight.view.AmmunitionView;
import com.epam.knight.view.EquipView;
import com.epam.knight.view.KnightView;
import com.epam.knight.view.MainMenuView;

import java.util.Comparator;

/**
 * Handles main menu and all operations with knight.
 */
public class KnightController {
    private final AmmunitionGenerator newItem = new AmmunitionGenerator();
    private final Knight knight = KnightGenerator.generateKnight();
    private final KnightAmmunitionManager manager = new KnightAmmunitionManager(knight);
    private final AmmunitionView ammunitionView = new AmmunitionView();
    private final KnightView knightView = new KnightView();
    private final EquipView equipView = new EquipView();
    private final MainMenuView menu = new MainMenuView();
    private boolean run = true;

    public void selectOperationOnKnight(int choice) {
        if (choice == MainMenuFields.KNIGHT_STATS_MENU_POINT.getId()) {
            showKnightStats();
        } else if (choice == MainMenuFields.SHOW_ITEM_MENU_POINT.getId()) {
            showAmmunition();
        } else if (choice == MainMenuFields.EQUIP_ITEM_MENU_POINT.getId()) {
            equipAmmunition();
        } else if (choice == MainMenuFields.SORT_ITEM_MENU_POINT.getId()) {
            sortAmmunition();
        } else if (choice == MainMenuFields.SEARCH_ITEM_MENU_POINT.getId()) {
            searchAmmunition();
        } else if (choice == MainMenuFields.EXIT_MENU_POINT.getId()) {
            exitProgram();
        } else {
            menu.printIncorrectInput();
        }
    }

    public void showKnightStats() {
        knightView.printKnightStats(manager);
    }

    public void showAmmunition() {
        for (Ammunition item : knight.getAmmunition()) {
            ammunitionView.printAmmunition(item);
        }
    }

    public void equipAmmunition() {
        Ammunition item;
        equipView.printEquipMenu();
        if (equipView.selectEquipMenu() == AmmunitionType.SWORD.getId()) {
            item = newItem.generateAmmunition(AmmunitionType.SWORD, equipView.inputStats(AmmunitionType.SWORD));
        } else {
            item = newItem.generateAmmunition(AmmunitionType.HELMET, equipView.inputStats(AmmunitionType.HELMET));
        }
        manager.equipAmmunitionToKnight(item);
    }

    public void sortAmmunition() {
        ammunitionView.printSortMenu();
        Comparator<Ammunition> comparator;
        if (ammunitionView.selectOption() == ItemMenuFields.COST_MENU_POINT.getId()) {
            comparator = new CostComparator();
        } else {
            comparator = new WeightComparator();
        }
        manager.sortKnightAmmunition(comparator);
        showAmmunition();
    }

    public void searchAmmunition() {
        ammunitionView.printSearchMenu();
        if (ammunitionView.selectOption() == ItemMenuFields.COST_MENU_POINT.getId()) {
            showSearchField(ItemMenuFields.COST_MENU_POINT);
        } else {
            showSearchField(ItemMenuFields.WEIGHT_MENU_POINT);
        }
    }

    public void showSearchField(ItemMenuFields field) {
        int minRange;
        ammunitionView.printInputMin(field.getTextField());
        minRange = ammunitionView.setRange();

        int maxRange;
        ammunitionView.printInputMax(field.getTextField());
        maxRange = ammunitionView.setRange();

        if (minRange > maxRange) {
            int temp = maxRange;
            maxRange = minRange;
            minRange = temp;
        }

        for (Ammunition item : knight.getAmmunition()) {
            if (field == ItemMenuFields.COST_MENU_POINT) {
                ammunitionView.printAmmunition(manager.searchCostField(item, minRange, maxRange));
            }
            if (field == ItemMenuFields.WEIGHT_MENU_POINT) {
                ammunitionView.printAmmunition(manager.searchWeightField(item, minRange, maxRange));
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
