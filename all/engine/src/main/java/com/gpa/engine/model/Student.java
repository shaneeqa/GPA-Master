package com.gpa.engine.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Column(name = "registrationNumber")
    String registrationNumber;
    @Column(name = "priorKnowledge")
    String priorKnowledge;
    @Column(name = "hoursOfWeeklyStudyI")
    String hoursOfWeeklyStudyI;
    @Column(name = "hoursOfWeeklyStudyII")
    String hoursOfWeeklyStudyII;
    @Column(name = "interactionWithLecturer")
    String interactionWithLecturer;
    @Column(name = "gpaYearI")
    Double gpaYearI;
    @Column(name = "gpaYearII")
    Double gpaYearII;
    @Column(name = "finalGpa")
    Double finalGpa;
    @Column(name = "developedProjects")
    Integer developedProjects;
    @Column(name = "preferredArea")
    String preferredArea;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPriorKnowledge() {
        return priorKnowledge;
    }

    public void setPriorKnowledge(String priorKnowledge) {
        this.priorKnowledge = priorKnowledge;
    }

    public String getHoursOfWeeklyStudyI() {
        return hoursOfWeeklyStudyI;
    }

    public void setHoursOfWeeklyStudyI(String hoursOfWeeklyStudyI) {
        this.hoursOfWeeklyStudyI = hoursOfWeeklyStudyI;
    }

    public String getHoursOfWeeklyStudyII() {
        return hoursOfWeeklyStudyII;
    }

    public void setHoursOfWeeklyStudyII(String hoursOfWeeklyStudyII) {
        this.hoursOfWeeklyStudyII = hoursOfWeeklyStudyII;
    }

    public String getInteractionWithLecturer() {
        return interactionWithLecturer;
    }

    public void setInteractionWithLecturer(String interactionWithLecturer) {
        this.interactionWithLecturer = interactionWithLecturer;
    }

    public Double getGPAYearI() {
        return gpaYearI;
    }

    public void setGPAYearI(Double gpaYearI) {
        this.gpaYearI = gpaYearI;
    }

    public Double getGPAYearII() {
        return gpaYearII;
    }

    public void setGPAYearII(Double GPAYearII) {
        this.gpaYearII = GPAYearII;
    }

    public Double getFinalGpa() {
        return finalGpa;
    }

    public void setFinalGpa(Double finalGpa) {
        this.finalGpa = finalGpa;
    }

    public Integer getDevelopedProjects() {
        return developedProjects;
    }

    public void setDevelopedProjects(Integer developedProjects) {
        this.developedProjects = developedProjects;
    }

    public String getPreferredArea() {
        return preferredArea;
    }

    public void setPreferredArea(String preferredArea) {
        this.preferredArea = preferredArea;
    }
}
