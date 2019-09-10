package com.gpa.engine.dto;

import es.ucm.fdi.gaia.jcolibri.datatypes.Instance;

public class StudentDTO {
    private String registrationNumber;
    private String priorKnowledge;
    private String hoursOfWeeklyStudyI;
    private String hoursOfWeeklyStudyII;
    private String interactionWithLecturer;
    private Double gpaYearI;
    private Double gpaYearII;
    private Double finalGpa;
    private Integer developedProjects;
    private String preferredArea;

    public StudentDTO() {
    }

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

    public Double getGpaYearI() {
        return gpaYearI;
    }

    public void setGpaYearI(Double gpaYearI) {
        this.gpaYearI = gpaYearI;
    }

    public Double getGpaYearII() {
        return gpaYearII;
    }

    public void setGpaYearII(Double gpaYearII) {
        this.gpaYearII = gpaYearII;
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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", priorKnowledge='" + priorKnowledge + '\'' +
                ", hoursOfWeeklyStudyI='" + hoursOfWeeklyStudyI + '\'' +
                ", hoursOfWeeklyStudyII='" + hoursOfWeeklyStudyII + '\'' +
                ", interactionWithLecturer='" + interactionWithLecturer + '\'' +
                ", gpaYearI=" + gpaYearI +
                ", gpaYearII=" + gpaYearII +
                ", finalGpa=" + finalGpa +
                ", developedProjects=" + developedProjects +
                ", preferredArea=" + preferredArea +
                '}';
    }



}
