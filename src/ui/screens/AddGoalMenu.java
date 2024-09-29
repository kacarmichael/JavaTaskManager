package ui.screens;

import app.AppContext;
import ui.AppUI;
import ui.MenuScreen;

public class AddGoalMenu extends MenuScreen {
    public AddGoalMenu() {
        super();
    }

    @Override
    public MenuScreen handleInput(int input) {
        return null;
    }

    @Override
    public void display() {
        System.out.println("Add Goal");
        addGoal();
    }

    public void addGoal() {
        clearScreen();
        System.out.println("Enter goal name: ");
        AppContext.getCurrentProfile().addGoal(AppUI.getScanner().nextLine());
    }
}
