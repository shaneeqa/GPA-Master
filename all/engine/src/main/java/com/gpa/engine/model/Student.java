package com.gpa.engine.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "registrationNumber")
    String registrationNumber;
    @Column(name = "priorKnowledge")
    Integer priorKnowledge;
    @Column(name = "hoursOfWeeklyStudyI")
    Integer hoursOfWeeklyStudyI;
    @Column(name = "hoursOfWeeklyStudyII")
    Integer hoursOfWeeklyStudyII;
    @Column(name = "interactionWithLecturer")
    Integer interactionWithLecturer;
    @Column(name = "gpaYearI")
    Double gpaYearI;
    @Column(name = "gpaYearII")
    Double gpaYearII;
    @Column(name = "finalGpa")
    Double finalGpa;
    @Column(name = "developedProjects")
    Integer developedProjects;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Integer getPriorKnowledge() {
        return priorKnowledge;
    }

    public void setPriorKnowledge(Integer priorKnowledge) {
        this.priorKnowledge = priorKnowledge;
    }

    public Integer getHoursOfWeeklyStudyI() {
        return hoursOfWeeklyStudyI;
    }

    public void setHoursOfWeeklyStudyI(Integer hoursOfWeeklyStudyI) {
        this.hoursOfWeeklyStudyI = hoursOfWeeklyStudyI;
    }

    public Integer getHoursOfWeeklyStudyII() {
        return hoursOfWeeklyStudyII;
    }

    public void setHoursOfWeeklyStudyII(Integer hoursOfWeeklyStudyII) {
        this.hoursOfWeeklyStudyII = hoursOfWeeklyStudyII;
    }

    public Integer getInteractionWithLecturer() {
        return interactionWithLecturer;
    }

    public void setInteractionWithLecturer(Integer interactionWithLecturer) {
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
}
