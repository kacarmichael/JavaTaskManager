package ui.screens;

import app.AppContext;
import ui.MenuScreen;


public class RegisterMenu extends MenuScreen {
    public RegisterMenu() {
        super();
        options.add("Register");
        options.add("Back");
    }

    @Override
    public MenuScreen handleInput(int input) {
        if (input == 1) {
            return new MainMenu();
        }
        return null;
    }

    @Override
    public void display() {
        clearScreen();
        if (AppContext.getCurrentUser() == null) {
            System.out.println("You must be logged in to do that");
        }
        System.out.println("Enter profile name: ");
    }
}
