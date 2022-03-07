package com.epam.knight.view;

import com.epam.knight.model.ammunition.AmmunitionType;

import java.util.Scanner;

public class EquipView {
    public static final int MIN_MENU_OPTION = 1;
    public static final int MAX_MENU_OPTION = 2;
    public static final int STATS_COUNT = 3;

    public void equipMenu() {
        System.out.println("What kind of ammunition do you want to equip?");
        System.out.println("1. Sword\n2. Helmet");
        System.out.println("Choose option:");
    }

    public AmmunitionType selectEquipMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            choice = scanner.nextInt();
            if (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION) {
                System.out.println("Incorrect input.Try again:");
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
        String item;
        String itemStats;
        switch (type) {
            case SWORD:
                item = "sword";
                itemStats = "damage";
                break;
            case HELMET:
                item = "helmet";
                itemStats = "protection";
                break;
            default:
                item = "";
                itemStats = "";
                break;
        }
        String[] statsList = {"weight", "cost", itemStats};

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < STATS_COUNT; ++i) {
            System.out.println("Input " + item + " " + statsList[i] + ":");
            stats[i] = scanner.nextInt();
        }
        return stats;
    }

    public void printFullAmmunition() {
        System.out.println("Ammunition list is full!");
    }
}
