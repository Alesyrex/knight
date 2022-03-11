package com.epam.knight.view;

import com.epam.knight.model.ammunition.AmmunitionType;

import java.util.Scanner;

public class EquipView {
    public static final String AMMUNITION_LIST_IS_FULL = "Ammunition list is full!";
    public static final String WEIGHT = "weight";
    public static final String COST = "cost";
    public static final String INPUT_STATS_FORMAT = "Input %s %s:\n";
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";
    public static final String EQUIP_MENU = "What kind of ammunition do you want to equip?\n" +
                                             "%d. %s\n%d. %s\nChoose option:\n";

    private final Scanner scanner = new Scanner(System.in);

    public void equipMenu() {
        System.out.printf(EQUIP_MENU,
                AmmunitionType.SWORD.getId(),AmmunitionType.SWORD.getName(),
                AmmunitionType.HELMET.getId(),AmmunitionType.HELMET.getName());
    }

    public int selectEquipMenu() {
        int choice;
        int minMenuOption = AmmunitionType.SWORD.getId();
        int maxMenuOption = AmmunitionType.HELMET.getId();
        do {
            choice = scanner.nextInt();
            if (choice < minMenuOption || choice > maxMenuOption) {
                System.out.println(INCORRECT_INPUT);
            }
        } while (choice < minMenuOption || choice > maxMenuOption);
        return choice;
    }

    public int[] inputStats(AmmunitionType type) {
        String[] statsList = {WEIGHT, COST, type.getFeature()};
        int[] stats = new int[statsList.length];

        for (int i = 0; i < stats.length; ++i) {
            System.out.printf(INPUT_STATS_FORMAT, type.getName(), statsList[i]);
            stats[i] = scanner.nextInt();
        }
        return stats;
    }

    public void printFullAmmunition() {
        System.out.println(AMMUNITION_LIST_IS_FULL);
    }
}
