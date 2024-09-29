package app;

import user.User;
import ui.AppUI;

import java.util.*;

public class App {

    private static final List<User> users = new ArrayList<>(); // List of   User;

    public static List<User> getUsers() { return users; } // List<User>

    public static void run() {
        while (true) {
            try {
                AppUI.displayMenu(AppUI.getCurrentScreen());
                AppUI.handleInput();
            } catch (Exception e) {
                return;
            }
        }
    }
}
