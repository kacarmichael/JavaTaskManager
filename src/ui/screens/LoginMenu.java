package ui.screens;

import ui.MenuFactory;
import ui.MenuScreen;

public class LoginMenu extends MenuScreen {

    public LoginMenu() {
        super();
        options.add("Log In");
        options.add("Create Account");
        options.add("Exit");
    }

    @Override
    public MenuScreen handleInput(int input) {
        if (input == 1) {
            return MenuFactory.getMenu("LoginMenu");
        }
        return null;
    }
}
