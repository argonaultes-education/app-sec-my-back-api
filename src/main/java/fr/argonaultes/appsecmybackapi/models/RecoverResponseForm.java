package fr.argonaultes.appsecmybackapi.models;

import java.util.List;

public class RecoverResponseForm {
    private String username;
    private List<RecoverResponse> recoverResponseList;
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RecoverResponse> getRecoverResponseList() {
        return recoverResponseList;
    }

    public void setRecoverResponseList(List<RecoverResponse> recoverResponseList) {
        this.recoverResponseList = recoverResponseList;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
