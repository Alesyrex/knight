package com.epam.knight.view;

import com.epam.knight.model.ammunition.AmmunitionType;

public class EquipView {
    public static final String WEIGHT = "weight";
    public static final String COST = "cost";
    public static final String INPUT_STATS_FORMAT = "Input %s %s:";
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";
    public static final String EQUIP_MENU = "What kind of ammunition do you want to equip?\n" +
            "%d. %s\n%d. %s\nChoose option:";
    private final ConsoleView consoleView = new ConsoleView();
    private final String equipMenu;

    public EquipView() {
        this.equipMenu = String.format(EQUIP_MENU,
                AmmunitionType.SWORD.getId(), AmmunitionType.SWORD.getName(),
                AmmunitionType.HELMET.getId(), AmmunitionType.HELMET.getName());
    }

    public void printEquipMenu() {
        consoleView.print(equipMenu);
    }

    public int selectEquipMenu() {
        int choice;
        int minMenuOption = AmmunitionType.SWORD.getId();
        int maxMenuOption = AmmunitionType.HELMET.getId();
        do {
            choice = consoleView.inputData();
            if (choice < minMenuOption || choice > maxMenuOption) {
                System.out.println(INCORRECT_INPUT);
            }
        } while (choice < minMenuOption || choice > maxMenuOption);
        return choice;
    }

    public int[] inputStats(AmmunitionType type) {
        String[] statsList = {WEIGHT, COST, type.getFeature()};
        int[] stats = new int[statsList.length];
        String input;

        for (int i = 0; i < stats.length; ++i) {
            input = String.format(INPUT_STATS_FORMAT, type.getName(), statsList[i]);
            consoleView.print(input);
            stats[i] = consoleView.inputData();
        }
        return stats;
    }
}
