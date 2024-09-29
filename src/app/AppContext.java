package app;

import user.User;
import goal.Goal;
import profile.Profile;
import task.Task;

public class AppContext {

    private static User currentUser;
    private static boolean isLoggedIn;
    private static Profile currentProfile;
    private static Goal currentGoal;
    private static Task currentTask;

    public static User getCurrentUser() {
        return AppContext.currentUser;
    }

    public void setCurrentUser(User user) {
        AppContext.currentUser = user;
    }

    public boolean isLoggedIn() {
        return AppContext.isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        AppContext.isLoggedIn = loggedIn;
    }

    public static Profile getCurrentProfile() {
        return AppContext.currentProfile;
    }

    public void setCurrentProfile(Profile profile) {
        currentProfile = profile;
    }

    public static Goal getCurrentGoal() {
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
