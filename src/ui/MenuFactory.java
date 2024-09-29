package ui;

import ui.screens.*;

import java.util.HashMap;

public class MenuFactory {
    private static final HashMap<String, MenuScreen> screens  = new HashMap<>() {{
        put("LoginMenu", new LoginMenu());
        put("MainMenu", new MainMenu());
        put("RegisterMenu", new RegisterMenu());
        put("AddUserMenu", new AddUserMenu());
        put("AddProfileMenu", new AddProfileMenu());
        put("AddGoalMenu", new AddGoalMenu());
        put("AddTaskMenu", new AddTaskMenu());
        put("ShowObjectsMenu", new ShowObjectsMenu());
    }};

    public static MenuScreen getMenu(String name) {
        return screens.get(name);
    }
}
