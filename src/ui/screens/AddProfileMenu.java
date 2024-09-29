package ui.screens;


import app.AppContext;
import ui.AppUI;
import ui.MenuScreen;

public class AddProfileMenu extends MenuScreen {

    public AddProfileMenu() {
        super();
        options.add("Add Profile");
        options.add("Back");
    }

    @Override
    public MenuScreen handleInput(int input) {
        return null;
    }

    @Override
    public void display() {
        System.out.println("Add Profile");
        addProfile();
    }

    public void addProfile() {
        clearScreen();
        if (AppContext.getCurrentUser() == null) {
            System.out.println("You must be logged in to do that");
            return;
        }
        System.out.println("Enter profile name: ");
        AppContext.getCurrentUser().addProfile(AppUI.getScanner().nextLine());
    }
}
