package User;

import profile.Profile;
import java.util.*;

public class User {
    private String name;
    private List<Profile> profiles;

    public User(String name) {
        this.name = name;
        this.profiles = new ArrayList<Profile>();
    }
    public String toString() {
        return "Name: " + this.name;
    }

    public List<Profile> getProfiles() { return this.profiles; }

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

    public String[] getFields() {
        return new String[] {this.name};
    }

}
