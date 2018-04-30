package com.edu.common.pojo;

import java.util.Date;

public class Course {
    private Integer courseId;

    private String courseName;

    private String courseImgsrc;

    private String tchAccount;

    private Integer visitTime;

    private Date createTime;

    private Date updateTime;

    private Byte state;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseImgsrc() {
        return courseImgsrc;
    }

    public void setCourseImgsrc(String courseImgsrc) {
        this.courseImgsrc = courseImgsrc == null ? null : courseImgsrc.trim();
    }

    public String getTchAccount() {
        return tchAccount;
    }

    public void setTchAccount(String tchAccount) {
        this.tchAccount = tchAccount == null ? null : tchAccount.trim();
    }

    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
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
}