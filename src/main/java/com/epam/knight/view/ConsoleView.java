package com.epam.knight.view;

import java.util.Scanner;

public class ConsoleView {
    public static final String INCORRECT_INPUT = "Incorrect input.Try again:";
    private final Scanner scanner = new Scanner(System.in);

    public void print(String text) {
        System.out.println(text);
    }

    public int inputData() {
        int temp;
        while (true) {
            if (scanner.hasNextInt()) {
                temp = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                print(INCORRECT_INPUT);
                scanner.nextLine();
            }
        }
        return temp;
    }
}
