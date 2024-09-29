package ui;

import java.util.ArrayList;

public class MenuScreen {
    public ArrayList<String> options;

    public MenuScreen() {
        options = new ArrayList<>();
    }

    public void listOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void display() {
        throw new UnsupportedOperationException("display not implemented");
    }

    public MenuScreen handleInput(int input) {
        throw new UnsupportedOperationException("handleInput not implemented");
    }
}
