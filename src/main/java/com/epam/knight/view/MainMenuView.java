package com.epam.knight.view;

import java.util.Scanner;

public class MainMenuView {
    public static final int MIN_MENU_OPTION = 1;
    public static final int MAX_MENU_OPTION = 6;

    public void mainMenu() {
        System.out.println("Main menu:");
        System.out.println("1. Print knight stats\n2. Show ammunition");
        System.out.println("3. Equip ammunition\n4. Sort ammunition");
        System.out.println("5. Search ammunition\n6. Exit\nChoose option:");
    }

    public int selectMainMenu() {
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
}
