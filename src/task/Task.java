package task;

import java.util.Date;

public class Task {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + this.name;
    }

    public String getName() { return this.name; }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Task task)) {
            return false;
        }
        return this.name.equals(task.name);
    }
}
