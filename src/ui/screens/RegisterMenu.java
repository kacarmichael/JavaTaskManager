package ui.screens;

import ui.MenuFactory;
import ui.MenuScreen;

import java.util.Scanner;

public class RegisterMenu extends MenuScreen {
    public RegisterMenu(Scanner scanner, MenuFactory menuFactory) {
        super(scanner, menuFactory);
        options.add("Register");
        options.add("Back");
    }

    @Override
    public MenuScreen handleInput(int input) {
        if (input == 1) {
            return new MainMenu(getScanner(), getMenuFactory());
        }
        return null;
    }

    @Override
    public void display() {
        clearScreen();
        if (context.getCurrentUser() == null) {
            System.out.println("You must be logged in to do that");
            return null;
        }
        System.out.println("Enter profile name: ");
        return getScanner().nextLine();
    }
}
