package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuScreen {
    public ArrayList<String> options;
    private static Scanner scanner;
    private static MenuFactory menuFactory;

    public MenuScreen(Scanner scanner, MenuFactory menuFactory) {
        menuFactory = menuFactory;
        options = new ArrayList<String>();
        scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public MenuFactory getMenuFactory() {
        return menuFactory;
    }

    public void setMenuFactory(MenuFactory newMenuFactory) {
        menuFactory = newMenuFactory;
    }

    public void listOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void display() {
        throw new UnsupportedOperationException("display not implemented");
    }

    public MenuScreen handleInput(int input) {
        throw new UnsupportedOperationException("handleInput not implemented");
    }
}
