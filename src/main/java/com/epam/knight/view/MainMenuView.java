package com.epam.knight.view;

import com.epam.knight.model.menu.MainMenuFields;

public class MainMenuView {
    public static final String MAIN_MENU_PRINT_FORMAT = "Main menu:\n%d. %s\n%d. %s\n" +
            "%d. %s\n%d. %s\n%d. %s\n%d. %s\nChoose option:";
    public static final String INCORRECT_INPUT = "Incorrect input.";
    public static final String TRY_AGAIN = "Try again:";
    public static final String BYE = "Bye!";

    private final ConsoleView consoleView = new ConsoleView();
    private final String mainMenu;

    public MainMenuView() {
        this.mainMenu = String.format(MAIN_MENU_PRINT_FORMAT,
                MainMenuFields.KNIGHT_STATS_MENU_POINT.getId(), MainMenuFields.KNIGHT_STATS_MENU_POINT.getTextField(),
                MainMenuFields.SHOW_ITEM_MENU_POINT.getId(), MainMenuFields.SHOW_ITEM_MENU_POINT.getTextField(),
                MainMenuFields.EQUIP_ITEM_MENU_POINT.getId(), MainMenuFields.EQUIP_ITEM_MENU_POINT.getTextField(),
                MainMenuFields.SORT_ITEM_MENU_POINT.getId(), MainMenuFields.SORT_ITEM_MENU_POINT.getTextField(),
                MainMenuFields.SEARCH_ITEM_MENU_POINT.getId(), MainMenuFields.SEARCH_ITEM_MENU_POINT.getTextField(),
                MainMenuFields.EXIT_MENU_POINT.getId(), MainMenuFields.EXIT_MENU_POINT.getTextField());
    }

    public void printMainMenu() {
        consoleView.print(mainMenu);
    }

    public int selectMainMenu() {
        int choice;
        int minMenuOption = MainMenuFields.KNIGHT_STATS_MENU_POINT.getId();
        int maxMenuOption = MainMenuFields.EXIT_MENU_POINT.getId();
        do {
            choice = consoleView.inputData();
            if (choice < minMenuOption || choice > maxMenuOption) {
                consoleView.print(INCORRECT_INPUT + TRY_AGAIN);
            }
        } while (choice < minMenuOption || choice > maxMenuOption);
        return choice;
    }

    public void printBye() {
        consoleView.print(BYE);
    }

    public void printIncorrectInput() {
        consoleView.print(INCORRECT_INPUT);
    }
}
