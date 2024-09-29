package profile;

import user.User;
import goal.Goal;
import java.util.*;

public class Profile {
    private String name;
    private final List<Goal> goals = new ArrayList<>();
    private User parentUser;

    public Profile(User user, String name) {
        this.parentUser = user;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentUser(User user) {
        this.parentUser = user;
    }

    public String toString() {
        return "Name: " + this.name;
    }

    public List<Goal> getGoals() { return this.goals; }

    public void addGoal(String name) {
        this.goals.add(new Goal(name));
    }

    public String getName() { return this.name; }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Profile profile)) {
            return false;
        }
        return this.name.equals(profile.name);
    }
}
