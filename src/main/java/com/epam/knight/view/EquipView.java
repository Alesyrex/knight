package com.epam.knight.view;

import com.epam.knight.model.ammunition.AmmunitionType;

import java.util.Scanner;

public class EquipView {
    public static final int MIN_MENU_OPTION = 1;
    public static final int MAX_MENU_OPTION = 2;
    public static final int STATS_COUNT = 3;
    public static final String AMMUNITION_LIST_IS_FULL = "Ammunition list is full!";
    public static final String WEIGHT = "weight";
    public static final String COST = "cost";
    public static final String INPUT = "Input ";
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";
    public static final String EQUIP_MENU = "What kind of ammunition do you want to equip?\n" +
                                             "1. Sword\n2. Helmet\nChoose option:";

    private final Scanner scanner = new Scanner(System.in);

    public void equipMenu() {
        System.out.println(EQUIP_MENU);
    }

    public AmmunitionType selectEquipMenu() {
        int choice;
        do {
            choice = scanner.nextInt();
            if (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION) {
                System.out.println(INCORRECT_INPUT);
            }
        } while (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION);
        if (choice == 1) {
            return AmmunitionType.SWORD;
        } else {
            return AmmunitionType.HELMET;
        }
    }

    public int[] inputStats(AmmunitionType type) {
        int[] stats = new int[STATS_COUNT];
        String[] statsList = {WEIGHT, COST, type.getFeature()};

        for (int i = 0; i < STATS_COUNT; ++i) {
            System.out.println(INPUT + type.getName() + " " + statsList[i] + ":");
            stats[i] = scanner.nextInt();
        }
        return stats;
    }

    public void printFullAmmunition() {
        System.out.println(AMMUNITION_LIST_IS_FULL);
    }
}
