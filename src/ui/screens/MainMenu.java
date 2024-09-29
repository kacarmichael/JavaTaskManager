package ui.screens;

import app.AppContext;
import ui.MenuFactory;
import ui.MenuScreen;

public class MainMenu extends MenuScreen {

    public MainMenu() {
        super();
        options.add("Add User");
        options.add("Switch User");
        options.add("Add Profile");
        options.add("Switch Profile");
        options.add("Add Goal");
        options.add("Switch Goal");
        options.add("Add Task");
        options.add("Show Tasks");
        options.add("Save");
        options.add("Log Out");
        options.add("Exit");
    }

    @Override
    public void display() {
        clearScreen();
        if (AppContext.getCurrentUser() != null) {
            System.out.printf("Welcome to Goal Tracker - %s!%n", AppContext.getCurrentUser().getName());
        }
        else {
            System.out.println("Welcome to Goal Tracker!");
        }
        if (AppContext.getCurrentProfile() != null) {
            System.out.printf("Current profile: %s%n", AppContext.getCurrentProfile().getName());
        }
        if (AppContext.getCurrentGoal() != null) {
            System.out.printf("Current goal: %s%n", AppContext.getCurrentGoal().getName());
        }
        System.out.println("Enter command: ");
        super.listOptions();
    }

    @Override
    public MenuScreen handleInput(int input) {
        switch (input) {
            case 1:
                return MenuFactory.getMenu("AddUserMenu");
            case 2:
                return new RegisterMenu();
            case 3:
                System.exit(0);
            case 4:
                return MenuFactory.getMenu("LoginMenu");
            case 5:
                return MenuFactory.getMenu("RegisterMenu");
            case 6:
                return MenuFactory.getMenu("AddGoalMenu");
            case 7:
                return MenuFactory.getMenu("AddTaskMenu");
            case 8:
                return MenuFactory.getMenu("ShowTasksMenu");
            case 9:
                return MenuFactory.getMenu("SaveMenu");
            case 10:
                return MenuFactory.getMenu("MainMenu");
            case 11:
                return MenuFactory.getMenu("SwitchProfileMenu");
            default:
                return null;
        }
    }
}
