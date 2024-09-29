package ui.screens;

import app.App;
import ui.AppUI;
import ui.MenuFactory;
import ui.MenuScreen;
import user.User;

public class AddUserMenu extends MenuScreen {
    @Override
    public MenuScreen handleInput(int input) {
        return MenuFactory.getMenu("MainMenu");
    }

    @Override
    public void display() {
        System.out.println("Add User");
        AddUser();
    }

    public void AddUser() {
        clearScreen();
        System.out.println("Enter user name: ");
        App.getUsers().add(new User(AppUI.getScanner().nextLine()));
    }
}
