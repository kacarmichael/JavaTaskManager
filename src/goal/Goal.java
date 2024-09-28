package goal;

import task.Task;

import java.util.*;

public class Goal {
    private String name;
    private List<Task> tasks = new ArrayList<Task>();

    public Goal(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + this.name + "\nDescription: ";
    }

    public List<Task> getTasks() { return this.tasks; }

    public String getName() { return this.name; }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Goal goal)) {
            return false;
        }
        return this.name.equals(goal.name);
    }
}
