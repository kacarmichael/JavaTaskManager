package user;

import goal.Goal;
import profile.Profile;
import task.Task;

import java.util.*;

public class User {
    private String name;
    private final List<Profile> profiles;

    public User(String name) {
        this.name = name;
        this.profiles = new ArrayList<>();
    }
    public String toString() {
        return "Name: " + this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProfile(String name) {
        this.profiles.add(new Profile(this, name));
    }

    public String getName() { return this.name; }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        User other = (User) obj;
        return other.name.equals(this.name);
    }

    public void listAllObjects() {
        for (Profile profile : this.profiles) {
            for (Goal goal : profile.getGoals()) {
                for (Task task : goal.getTasks()) {
                    System.out.println(task);
                }
            }
        }
    }

}
