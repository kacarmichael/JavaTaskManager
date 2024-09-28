package ui.screens;

import ui.MenuFactory;
import ui.MenuScreen;

import java.util.Scanner;

public class MainMenu extends MenuScreen {

    public MainMenu(Scanner scanner, MenuFactory menuFactory) {
        super(scanner, menuFactory);
        options.add("Log In");
        options.add("Create Account");
        options.add("Exit");
    }

    @Override
    public void display() {
        System.out.println("Main Menu");
        super.listOptions();
    }

    @Override
    public MenuScreen handleInput(int input) {
        switch (input) {
            case 1:
                return new LoginMenu(getScanner(), getMenuFactory());
            case 2:
                return new RegisterMenu(getScanner(), getMenuFactory());
            case 3:
                System.exit(0);
            default:
                return null;
        }
    }
}
