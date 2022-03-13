package com.epam.knight.view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void print(String text) {
        System.out.println(text);
    }

    public int inputData() {
        return scanner.nextInt();
    }
}
