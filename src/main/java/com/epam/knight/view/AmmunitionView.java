package com.epam.knight.view;

import com.epam.knight.model.ammunition.AbstractAmmunitionForAttack;
import com.epam.knight.model.ammunition.AbstractAmmunitionForProtection;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.menu.ItemMenuFields;

import java.util.Scanner;

public class AmmunitionView {
    public static final String STANDARD_FIELD_FORMAT = "%d. %s\n%d. %s\nChoose option:";
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";
    public static final String CHOOSE_SORT_TYPE = "Choose sort type:";
    public static final String CHOOSE_SEARCH_FIELD = "Choose search field:";
    public static final String INPUT_MINIMUM = "Input minimum ";
    public static final String INPUT_MAXIMUM = "Input maximum ";

    private final Scanner scanner = new Scanner(System.in);
    private final String standardField = String.format(STANDARD_FIELD_FORMAT,
            ItemMenuFields.COST_MENU_POINT.getId(),ItemMenuFields.COST_MENU_POINT.getTextField(),
            ItemMenuFields.WEIGHT_MENU_POINT.getId(),ItemMenuFields.WEIGHT_MENU_POINT.getTextField());

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
        System.out.println(standardField);
    }

    public int choiceOption() {
        int choice;
        int minMenuOption = ItemMenuFields.COST_MENU_POINT.getId();
        int maxMenuOption = ItemMenuFields.WEIGHT_MENU_POINT.getId();
        do {
            choice = scanner.nextInt();
            if (choice < minMenuOption || choice > maxMenuOption) {
                System.out.println(INCORRECT_INPUT);
            }
        } while (choice < minMenuOption || choice > maxMenuOption);
        return choice;
    }

    public void printSearchMenu() {
        System.out.println(CHOOSE_SEARCH_FIELD);
        System.out.println(standardField);
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
