package ui.screens;

import app.AppContext;
import ui.MenuFactory;
import ui.MenuScreen;

public class ShowObjectsMenu extends MenuScreen {
    public String objectType;

    public ShowObjectsMenu() {
        super();
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public void display() {
        System.out.println("Show Objects");
    }

    @Override
    public MenuScreen handleInput(int input) {

        switch (this.objectType) {

            case "Profile":
                System.out.println("Profile");
                break;

            case "User":
                System.out.println("User");
                break;

            case "Goal":
                System.out.println("Goal");
                break;

            case "Task":
                clearScreen();
                AppContext.getCurrentUser().listAllObjects();
                break;
        }

        return MenuFactory.getMenu("MainMenu");
    }
}
