package app;

import User.User;
import goal.Goal;
import io.Writer;
import profile.Profile;
import task.Task;
import ui.AppUI;
import ui.MenuFactory;

import java.util.*;
import java.util.stream.Stream;

public class App {

    private List<User> users; // List of   User;
    private Writer writer = new Writer("data.csv");

    private AppContext appContext;
    private AppUI ui;

    public App() {
        users = new ArrayList<User>();
        appContext = new AppContext();
        ui = new AppUI(appContext);
    }

    public void run() {
        while (true) {
            ui.displayMenu("MainMenu");
            try {
                ui.handleInput();
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
        }
//            if (!appContext.isLoggedIn()) {
//                if (users.isEmpty()) {
//                    System.out.println("No users found. Please add a user first.");
//                    users.add(new User(scanner.nextLine()));
//                }
//                String username = ui.logIn(users, null);
//                for (User user : users) {
//                    if (user.getName().equals(username)) {
//                        appContext.setCurrentUser(user);
//                        appContext.setLoggedIn(true);
//                        break;
//                    }
//                }
//            }
//
//            String command = ui.mainMenu();
//            if (command.equals("exit")) {
//                System.exit(0);
//            }
//            switch (command) {
//                case "add_user":
//                    addUser();
//                    break;
//                case "switch_user":
//                    switchUser();
//                    break;
//                case "add_profile":
//                    addProfile();
//                    break;
//                case "switch_profile":
//                    switchProfile();
//                    break;
//                case "add_goal":
//                    addGoal();
//                    break;
//                case "switch_goal":
//                    switchGoal();
//                    break;
//                case "add_task":
//                    addTask();
//                    break;
//                case "save":
//                    save();
//                    break;
//                case "log_out":
//                    appContext.clearContext();
//                    break;
//                default:
//                    System.out.println("Invalid command");
//            }
//        }
    }

    public void addUser() {
        users.add(new User(ui.getNewUser()));
    }

    public void switchUser() {
        String input = ui.getNewUser();
        for (User user : users) {
            if (user.getName().equals(input)) {
                appContext.clearContext();
                appContext.setCurrentUser(user);
                appContext.setLoggedIn(true);
                break;
            }
        }
    }

    public void addProfile() {
        while (appContext.getCurrentUser() == null) {
            ui.logIn(users, "You must be logged in to do that");
        }
        Profile profile = new Profile(appContext.getCurrentUser(), ui.getNewProfile());
        appContext.getCurrentUser()
                .getProfiles()
                .add(profile);
        appContext.setCurrentProfile(profile);
    }

    public void switchProfile() {
        while (appContext.getCurrentUser() == null) {
            ui.logIn(users, "You must be logged in to do that");
        }
        ui.listProfiles(appContext.getCurrentUser().getProfiles());
        String profileName = ui.getNewProfile();
        for (Profile profile : appContext.getCurrentUser().getProfiles()) {
            if (profile.getName().equals(profileName)) {
                appContext.setCurrentProfile(profile);
                appContext.setCurrentGoal(null);
                appContext.setCurrentTask(null);
                break;
            }
        }
    }

    public void addGoal() {
        while (appContext.getCurrentProfile() == null) {
            String input = ui.getNewProfile();
            for (Profile profile : appContext.getCurrentUser().getProfiles()) {
                if (profile.getName().equals(input)) {
                    appContext.setCurrentProfile(profile);
                    break;
                }
            }
        }
        Goal goal = new Goal(ui.getNewGoal());
        appContext.getCurrentProfile().getGoals().add(goal);
    }

    public void switchGoal() {
        while (appContext.getCurrentProfile() == null) {
            String input = ui.getNewProfile();
            for (Profile profile : appContext.getCurrentUser().getProfiles()) {
                if (profile.getName().equals(input)) {
                    appContext.setCurrentProfile(profile);
                    break;
                }
            }
        }
        ui.listGoals(appContext.getCurrentProfile().getGoals());
        String goalName = ui.getNewGoal();
        for (Goal goal : appContext.getCurrentProfile().getGoals()) {
            if (goal.getName().equals(goalName)) {
                appContext.setCurrentGoal(goal);
                appContext.setCurrentTask(null);
                break;
            }
        }
    }

    public void addTask() {
        while (appContext.getCurrentProfile() == null) {
            String input = ui.getNewProfile();
            for (Profile profile : appContext.getCurrentUser().getProfiles()) {
                if (profile.getName().equals(input)) {
                    appContext.setCurrentProfile(profile);
                    break;
                }
            }
        }
        while (appContext.getCurrentGoal() == null) {
            String input = ui.getNewGoal();
            for (Goal goal : appContext.getCurrentProfile().getGoals()) {
                if (goal.getName().equals(input)) {
                    appContext.setCurrentGoal(goal);
                    break;
                }
            }
        }
        System.out.println("Enter task name: ");
//        String name = scanner.nextLine();
//        Task task = new Task(name);
    }

    public void save() {
        for (User user : users) {
            if (user.getProfiles().isEmpty()) {
                writer.write(new String[]{user.getName(), "", "", ""});
                continue;
            }
            for (Profile profile : user.getProfiles()) {
                if (profile.getGoals().isEmpty()) {
                    writer.write(new String[]{user.getName(), profile.getName(), "", ""});
                    continue;
                }
                for (Goal goal : profile.getGoals()) {
                    if (goal.getTasks().isEmpty()) {
                        writer.write(new String[]{user.getName(), profile.getName(), goal.getName(), ""});
                        continue;
                    }
                    for (Task task : goal.getTasks()) {
                        writer.write(new String[]{user.getName(), profile.getName(), goal.getName(), task.getName()});
                    }
                }
            }
        }
    }
}
