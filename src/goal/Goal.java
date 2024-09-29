package goal;

import task.Task;

import java.util.*;

public class Goal {
    private String name;
    private final List<Task> tasks = new ArrayList<>();

    public Goal(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + this.name + "\nDescription: ";
    }

    public List<Task> getTasks() { return this.tasks; }

    public void addTask(String name) {
        this.tasks.add(new Task(name));
    }

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
