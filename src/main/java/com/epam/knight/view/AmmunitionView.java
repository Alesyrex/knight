package com.epam.knight.view;

import com.epam.knight.model.ammunition.AbstractAmmunitionForAttack;
import com.epam.knight.model.ammunition.AbstractAmmunitionForProtection;
import com.epam.knight.model.ammunition.Ammunition;

import java.util.Scanner;

public class AmmunitionView {
    public static final int MIN_MENU_OPTION = 1;
    public static final int MAX_MENU_OPTION = 2;
    public static final String STANDARD_FIELD = "1. Cost\n2. Weight\nChoose option:";
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";
    public static final String CHOOSE_SORT_TYPE = "Choose sort type:";
    public static final String CHOOSE_SEARCH_FIELD = "Choose search field:";
    public static final String INPUT_MINIMUM = "Input minimum ";
    public static final String INPUT_MAXIMUM = "Input maximum ";

    private final Scanner scanner = new Scanner(System.in);

    public void printAmmunition(Ammunition item) {
        if (item != null) {
            if (item instanceof AbstractAmmunitionForAttack) {
                System.out.println(item);
            }
            if (item instanceof AbstractAmmunitionForProtection) {
                System.out.println(item);
            }
        }
        
    }

    public void printSortMenu() {
        System.out.println(CHOOSE_SORT_TYPE);
        System.out.println(STANDARD_FIELD);
    }

    public int choiceOption() {
        int choice;
        do {
            choice = scanner.nextInt();
            if (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION) {
                System.out.println(INCORRECT_INPUT);
            }
        } while (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION);
        return choice;
    }

    public void printSearchMenu() {
        System.out.println(CHOOSE_SEARCH_FIELD);
        System.out.println(STANDARD_FIELD);
    }

    public void printInputMin(String field) {
        System.out.println(INPUT_MINIMUM + field);
    }

    public void printInputMax(String field) {
        System.out.println(INPUT_MAXIMUM + field);
    }

    public int setRange() {
        return scanner.nextInt();
    }
}
