package com.epam.knight.view;

import java.util.Scanner;

public class MainMenuView {
    public static final int MIN_MENU_OPTION = 1;
    public static final int MAX_MENU_OPTION = 6;
    public static final String MAIN_MENU = "Main menu:\n1. Print knight stats\n2. Show ammunition\n" +
                                           "3. Equip ammunition\n4. Sort ammunition\n" +
                                           "5. Search ammunition\n6. Exit\nChoose option:";
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";


    public void mainMenu() {
        System.out.println(MAIN_MENU);
    }

    public int selectMainMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            choice = scanner.nextInt();
            if (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION) {
                System.out.println(INCORRECT_INPUT);
            }
        } while (choice < MIN_MENU_OPTION || choice > MAX_MENU_OPTION);
        return choice;
    }
}
