package com.epam.knight.controller;

import com.epam.knight.view.MainMenuView;

/**
 * Launches main menu with {@link KnightController}.
 */
public class KnightApplication {

    public static void main(String[] args) {
        KnightApplication application = new KnightApplication();
        application.start();
    }

    private void start() {
        MainMenuView menu = new MainMenuView();
        KnightController controller = new KnightController();
        do {
            menu.printMainMenu();
            controller.selectOperationOnKnight(menu.selectMainMenu());
        } while (controller.isRun());
        menu.printBye();
    }
}
