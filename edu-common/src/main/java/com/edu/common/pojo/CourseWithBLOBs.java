package com.edu.common.pojo;

public class CourseWithBLOBs extends Course {
    private String courseProcess;

    private String courseIntro;

    public String getCourseProcess() {
        return courseProcess;
    }

    public void setCourseProcess(String courseProcess) {
        this.courseProcess = courseProcess == null ? null : courseProcess.trim();
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro == null ? null : courseIntro.trim();
    }
}