package profile;

import User.User;
import goal.Goal;
import java.util.*;

public class Profile {
    private String name;
    private List<Goal> goals = new ArrayList<Goal>();
    private User parentUser;

    public Profile(User user, String name) {
        this.parentUser = user;
        this.name = name;
    }

    public String toString() {
        return "Name: " + this.name;
    }

    public List<Goal> getGoals() { return this.goals; }

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
