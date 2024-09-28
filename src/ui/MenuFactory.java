package ui;

import app.AppContext;
import ui.screens.*;

import java.util.HashMap;
import java.util.Scanner;

public class MenuFactory {
    private HashMap<String, MenuScreen> screens;
    private static AppContext context;
    private static Scanner scanner;

    public MenuFactory(AppContext context, Scanner scanner) {
        scanner = scanner;
        context = context;
        screens = new HashMap<>();
        screens.put("LoginMenu", new LoginMenu(scanner, this));
        screens.put("MainMenu", new MainMenu(scanner, this));
    }

    public MenuScreen getMenu(String name) {
        return screens.get(name);
    }
}
