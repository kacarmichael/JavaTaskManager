package ui;

import java.util.List;
import java.util.Scanner;

import User.User;
import app.AppContext;
import goal.Goal;
import profile.Profile;
import task.Task;


public class AppUI {

    private static Scanner scanner;
    private static AppContext context;
    private static MenuFactory menuFactory;
    private static MenuScreen currentScreen;

    public AppUI(AppContext context) {
        scanner = new Scanner(System.in);
        menuFactory = new MenuFactory(context, scanner);
        context = context;
        currentScreen = menuFactory.getMenu("MainMenu");
    }

    public void displayMenu(String menu) {
        currentScreen = menuFactory.getMenu(menu);
        currentScreen.display();
    }

    public void handleInput() {
        try {
            int input = Integer.parseInt(scanner.nextLine());
            currentScreen = currentScreen.handleInput(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            handleInput();
        }
    }

//    public String mainMenu() {
//        clearScreen();
//        System.out.printf("Welcome to Goal Tracker - %s!%n", context.getCurrentUser().getName());
//        if (context.getCurrentProfile() != null) {
//            System.out.printf("Current profile: %s%n", context.getCurrentProfile().getName());
//        }
//        if (context.getCurrentGoal() != null) {
//            System.out.printf("Current goal: %s%n", context.getCurrentGoal().getName());
//        }
//
//        System.out.println("Enter command: ");
//        System.out.println("add_user");
//        System.out.println("switch_user");
//        System.out.println("add_profile");
//        System.out.println("switch_profile");
//        System.out.println("add_goal");
//        System.out.println("switch_goal");
//        System.out.println("add_task");
//        System.out.println("show_tasks");
//        System.out.println("save");
//        System.out.println("log_out");
//        System.out.println("exit");
//        return scanner.nextLine();
//    }

    public String setCurrentProfile() {
        clearScreen();
        System.out.println("Enter profile name: ");
        return scanner.nextLine();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void listUsers(List<User> users) {
        clearScreen();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public String getNewUser() {
        clearScreen();
        System.out.println("Enter user name: ");
        return scanner.nextLine();
    }

    public String getNewProfile() {
        clearScreen();
        if (context.getCurrentUser() == null) {
            System.out.println("You must be logged in to do that");
            return null;
        }
        System.out.println("Enter profile name: ");
        return scanner.nextLine();
    }

    public void listProfiles(List<Profile> profiles) {
        clearScreen();
        for (Profile profile : profiles) {
            System.out.println(profile);
        }
    }

    public String getNewGoal() {
        clearScreen();
        System.out.println("Enter goal name: ");
        return scanner.nextLine();
    }

    public void listGoals(List<Goal> goals) {
        clearScreen();
        for (Goal goal : goals) {
            System.out.println(goal);
        }
    }

    public String logIn(List<User> users, String err) {
        if (err != null) {
            System.out.println(err);
        }
        clearScreen();
        this.listUsers(users);
        System.out.println("Enter user name: ");
        return scanner.nextLine();
    }

    public String getNewTask() {
        clearScreen();
        System.out.println("Enter task name: ");
        return scanner.nextLine();
    }

    public void listTasks(List<Task> tasks) {
        clearScreen();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
