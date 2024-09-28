package app;

import User.User;
import goal.Goal;
import profile.Profile;
import task.Task;

public class AppContext {

    private User currentUser;
    private boolean isLoggedIn;
    private Profile currentProfile;
    private Goal currentGoal;
    private Task currentTask;

    public AppContext() {
        currentUser = null;
        isLoggedIn = false;
        currentProfile = null;
        currentGoal = null;
        currentTask = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Profile profile) {
        currentProfile = profile;
    }

    public Goal getCurrentGoal() {
        return currentGoal;
    }

    public void setCurrentGoal(Goal goal) {
        currentGoal = goal;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(Task task) {
        currentTask = task;
    }

    public void clearContext() {
        currentUser = null;
        isLoggedIn = false;
        currentProfile = null;
        currentGoal = null;
        currentTask = null;
    }
}
