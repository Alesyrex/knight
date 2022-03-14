package com.epam.knight.view;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.menu.ItemMenuFields;

public class AmmunitionView {
    public static final String STANDARD_FIELD_FORMAT = "%d. %s\n%d. %s\nChoose option:";
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";
    public static final String CHOOSE_SORT_TYPE = "Choose sort type:\n";
    public static final String CHOOSE_SEARCH_FIELD = "Choose search field:\n";
    public static final String INPUT_MINIMUM = "Input minimum ";
    public static final String INPUT_MAXIMUM = "Input maximum ";

    private final ConsoleView consoleView = new ConsoleView();

    private final String sortMenu;
    private final String searchMenu;

    public AmmunitionView() {
        String standardField = String.format(STANDARD_FIELD_FORMAT,
                ItemMenuFields.COST_MENU_POINT.getId(), ItemMenuFields.COST_MENU_POINT.getTextField(),
                ItemMenuFields.WEIGHT_MENU_POINT.getId(), ItemMenuFields.WEIGHT_MENU_POINT.getTextField());
        this.sortMenu = CHOOSE_SORT_TYPE + standardField;
        this.searchMenu = CHOOSE_SEARCH_FIELD + standardField;
    }

    public void printAmmunition(Ammunition item) {
        // У меня searchCostField и searchWeightField в KnightAmmunitionManager могут вернуть null;
        if (item != null) {
            consoleView.print(item.toString());
        }
    }

    public void printSortMenu() {
        consoleView.print(sortMenu);
    }

    public int selectOption() {
        int choice;
        int minMenuOption = ItemMenuFields.COST_MENU_POINT.getId();
        int maxMenuOption = ItemMenuFields.WEIGHT_MENU_POINT.getId();
        do {
            choice = consoleView.inputData();
            if (choice < minMenuOption || choice > maxMenuOption) {
                consoleView.print(INCORRECT_INPUT);
            }
        } while (choice < minMenuOption || choice > maxMenuOption);
        return choice;
    }

    public void printSearchMenu() {
        consoleView.print(searchMenu);
    }

    public void printInputMin(String field) {
        consoleView.print(INPUT_MINIMUM + field);
    }

    public void printInputMax(String field) {
        consoleView.print(INPUT_MAXIMUM + field);
    }

    public int setRange() {
        return consoleView.inputData();
    }
}
