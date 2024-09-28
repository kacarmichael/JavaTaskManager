package ui.screens;

import ui.MenuFactory;
import ui.MenuScreen;

import java.util.Scanner;

public class LoginMenu extends MenuScreen {

    public LoginMenu(Scanner scanner, MenuFactory menuFactory) {
        super(scanner, menuFactory);
        options.add("Log In");
        options.add("Create Account");
        options.add("Exit");
    }

    @Override
    public MenuScreen handleInput(int input) {
        if (input == 1) {
            return new MainMenu(getScanner(), getMenuFactory());
        }
        return null;
    }
}
