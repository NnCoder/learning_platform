package com.edu.common.pojo;

public class TchStuKey {
    private String tchAccount;

    private String stuAccount;

    public String getTchAccount() {
        return tchAccount;
    }

    public void setTchAccount(String tchAccount) {
        this.tchAccount = tchAccount == null ? null : tchAccount.trim();
    }

    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount == null ? null : stuAccount.trim();
    }
}