package fr.argonaultes.appsecmybackapi.models;

public class LoginRes {
    private int userId = 0;
    private boolean isAdmin = false;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
