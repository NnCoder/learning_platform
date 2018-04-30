package com.edu.common.pojo;

public class Teacher {
    private String tchAccount;

    private String tchName;

    private String tchPassword;

    private String role;

    private Integer state;

    public String getTchAccount() {
        return tchAccount;
    }

    public void setTchAccount(String tchAccount) {
        this.tchAccount = tchAccount == null ? null : tchAccount.trim();
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName == null ? null : tchName.trim();
    }

    public String getTchPassword() {
        return tchPassword;
    }

    public void setTchPassword(String tchPassword) {
        this.tchPassword = tchPassword == null ? null : tchPassword.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}