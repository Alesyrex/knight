package com.epam.knight.view;

import com.epam.knight.model.ammunition.AbstractAmmunitionForAttack;
import com.epam.knight.model.ammunition.AbstractAmmunitionForProtection;
import com.epam.knight.model.ammunition.Ammunition;

import java.util.Scanner;

public class AmmunitionView {
    public static final int MIN_MENU_OPTION = 1;
    public static final int MAX_MENU_OPTION = 2;
    public static final String STANDARD_FIELD = "1. Cost\n2. Weight\nChoose option:";

    public void printAmmunition(Ammunition item) {
        if (item != null) {
            if (item instanceof AbstractAmmunitionForAttack) {
                System.out.print(((AbstractAmmunitionForAttack) item).getName());
                System.out.print("{damage=" + ((AbstractAmmunitionForAttack) item).getDamage());
            }
            if (item instanceof AbstractAmmunitionForProtection) {
                System.out.print(((AbstractAmmunitionForProtection) item).getName());
                System.out.print("{protection=" + ((AbstractAmmunitionForProtection) item).getProtection());
            }
            System.out.print(", weight=" + item.getWeight() + ", ");
            System.out.println("cost=" + item.getCost() + "}");
        }
    }

    public void printSortMenu() {
        System.out.println("Choose sort type:");
        System.out.println(STANDARD_FIELD);
    }

    public int choiceOption() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            choice = scanner.nextInt();
            if (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION) {
                System.out.println("Incorrect input.Try again:");
            }
        } while (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION);
        return choice;
    }

    public void printSearchMenu() {
        System.out.println("Choose search field:");
        System.out.println(STANDARD_FIELD);
    }

    public void printInputMin(String field) {
        System.out.println("Input minimum " + field);
    }

    public void printInputMax(String field) {
        System.out.println("Input maximum " + field);
    }

    public int setRange() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
