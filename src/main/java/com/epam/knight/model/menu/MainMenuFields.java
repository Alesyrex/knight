package com.epam.knight.model.menu;

public enum MainMenuFields {
    KNIGHT_STATS_MENU_POINT(Constants.ID_ONE, Constants.PRINT_KNIGHT_STATS),
    SHOW_ITEM_MENU_POINT(Constants.ID_TWO, Constants.SHOW_AMMUNITION),
    EQUIP_ITEM_MENU_POINT(Constants.ID_THREE, Constants.EQUIP_AMMUNITION),
    SORT_ITEM_MENU_POINT(Constants.ID_FOUR, Constants.SORT_AMMUNITION),
    SEARCH_ITEM_MENU_POINT(Constants.ID_FIVE, Constants.SEARCH_AMMUNITION),
    EXIT_MENU_POINT(Constants.ID_SIX, Constants.EXIT);

    private final int id;
    private final String textField;

    MainMenuFields(int id, String textField) {
        this.id = id;
        this.textField = textField;
    }

    public int getId() {
        return id;
    }

    public String getTextField() {
        return textField;
    }

    private static class Constants {
        public static final String PRINT_KNIGHT_STATS = "Print knight stats";
        public static final String SHOW_AMMUNITION = "Show ammunition";
        public static final String EQUIP_AMMUNITION = "Equip ammunition";
        public static final String SORT_AMMUNITION = "Sort ammunition";
        public static final String SEARCH_AMMUNITION = "Search ammunition";
        public static final String EXIT = "Exit";
        public static final int ID_ONE = 1;
        public static final int ID_TWO = 2;
        public static final int ID_THREE = 3;
        public static final int ID_FOUR = 4;
        public static final int ID_FIVE = 5;
        public static final int ID_SIX = 6;
    }
}
