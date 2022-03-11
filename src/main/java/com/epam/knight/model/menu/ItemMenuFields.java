package com.epam.knight.model.menu;

public enum ItemMenuFields {
    COST_MENU_POINT(ItemMenuFields.Constants.ID_ONE, ItemMenuFields.Constants.PRINT_COST),
    WEIGHT_MENU_POINT(ItemMenuFields.Constants.ID_TWO, ItemMenuFields.Constants.PRINT_WEIGHT);

    private final int id;
    private final String textField;

    ItemMenuFields(int id, String textField) {
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
        public static final String PRINT_COST = "cost";
        public static final String PRINT_WEIGHT = "weight";
        public static final int ID_ONE = 1;
        public static final int ID_TWO = 2;
    }
}
