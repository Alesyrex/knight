package com.epam.knight.view;

import com.epam.knight.model.menu.MainMenuFields;

import java.util.Scanner;

public class MainMenuView {
    public static final String MAIN_MENU_PRINT_FORMAT = "Main menu:\n%d. %s\n%d. %s\n" +
                                           "%d. %s\n%d. %s\n%d. %s\n%d. %s\nChoose option:\n";
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";

    public void mainMenu() {
        System.out.printf(MAIN_MENU_PRINT_FORMAT,
                MainMenuFields.KNIGHT_STATS_MENU_POINT.getId(), MainMenuFields.KNIGHT_STATS_MENU_POINT.getTextField(),
                MainMenuFields.SHOW_ITEM_MENU_POINT.getId(),MainMenuFields.SHOW_ITEM_MENU_POINT.getTextField(),
                MainMenuFields.EQUIP_ITEM_MENU_POINT.getId(),MainMenuFields.EQUIP_ITEM_MENU_POINT.getTextField(),
                MainMenuFields.SORT_ITEM_MENU_POINT.getId(),MainMenuFields.SORT_ITEM_MENU_POINT.getTextField(),
                MainMenuFields.SEARCH_ITEM_MENU_POINT.getId(),MainMenuFields.SEARCH_ITEM_MENU_POINT.getTextField(),
                MainMenuFields.EXIT_MENU_POINT.getId(),MainMenuFields.EXIT_MENU_POINT.getTextField());
    }

    public int selectMainMenu() {
        int choice;
        int minMenuOption = MainMenuFields.KNIGHT_STATS_MENU_POINT.getId();
        int maxMenuOption = MainMenuFields.EXIT_MENU_POINT.getId();
        Scanner scanner = new Scanner(System.in);
        do {
            choice = scanner.nextInt();
            if (choice < minMenuOption || choice > maxMenuOption) {
                System.out.println(INCORRECT_INPUT);
            }
        } while (choice < minMenuOption || choice > maxMenuOption);
        return choice;
    }
}
