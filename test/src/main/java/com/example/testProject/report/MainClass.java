package com.example.testProject.report;

public class MainClass {

    private String prof_name;
    private String allStudents;
    private String performance;

    public MainClass(String prof_name, String allStudents, String performance) {
        this.prof_name = prof_name;
        this.allStudents = allStudents;
        this.performance = performance;
    }

    public String getProf_name() {
        return prof_name;
    }

    public void setProf_name(String prof_name) {
        this.prof_name = prof_name;
    }

    public String getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(String allStudents) {
        this.allStudents = allStudents;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
