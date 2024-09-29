package ui.screens;

import app.AppContext;
import ui.AppUI;
import ui.MenuScreen;

public class AddTaskMenu extends MenuScreen {

    public AddTaskMenu() {
        super();
    }

    @Override
    public MenuScreen handleInput(int input) {
        return null;
    }

    @Override
    public void display() {
        System.out.println("Add Task");
        addTask();
    }

    public void addTask() {
        clearScreen();
        System.out.println("Enter task name:");
        AppContext.getCurrentGoal().addTask(AppUI.getScanner().nextLine());
    }
}
