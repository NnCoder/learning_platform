package com.edu.common.pojo;

import java.util.Date;

public class Video {
    private Integer vedioId;

    private String vedioName;

    private String vedioSrc;

    private Byte vedioGrade;

    private Integer visitTime;

    private Integer kpId;

    private Date createTime;

    private Date updateTime;

    private Byte state;

    private String createAccount;

    public Integer getVedioId() {
        return vedioId;
    }

    public void setVedioId(Integer vedioId) {
        this.vedioId = vedioId;
    }

    public String getVedioName() {
        return vedioName;
    }

    public void setVedioName(String vedioName) {
        this.vedioName = vedioName == null ? null : vedioName.trim();
    }

    public String getVedioSrc() {
        return vedioSrc;
    }

    public void setVedioSrc(String vedioSrc) {
        this.vedioSrc = vedioSrc == null ? null : vedioSrc.trim();
    }

    public Byte getVedioGrade() {
        return vedioGrade;
    }

    public void setVedioGrade(Byte vedioGrade) {
        this.vedioGrade = vedioGrade;
    }

    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getKpId() {
        return kpId;
    }

    public void setKpId(Integer kpId) {
        this.kpId = kpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount == null ? null : createAccount.trim();
    }
}