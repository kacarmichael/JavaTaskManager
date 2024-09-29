package ui;

import java.util.Scanner;


public class AppUI {

    private static final Scanner scanner = new Scanner(System.in);
    private static MenuScreen currentScreen = MenuFactory.getMenu("MainMenu");
    private static MenuScreen previousScreen;

    public static Scanner getScanner() {
        return AppUI.scanner;
    }

    public static MenuScreen getCurrentScreen() {
        return AppUI.currentScreen;
    }

    public static MenuScreen getPreviousScreen() {
        return AppUI.previousScreen;
    }

    public static void displayMenu(MenuScreen menu) {
        AppUI.previousScreen = AppUI.currentScreen;
        AppUI.currentScreen = menu;
        AppUI.currentScreen.display();
    }

    public static void handleInput() {
        try {
            int input = Integer.parseInt(AppUI.scanner.nextLine());
            AppUI.currentScreen = AppUI.currentScreen.handleInput(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            handleInput();
        }
    }
}
