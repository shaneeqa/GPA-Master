package com.gpa.engine.dto;

public class StudentDTO {
    private String registrationNumber;
    private Integer priorKnowledge;
    private Integer hoursOfWeeklyStudyI;
    private Integer hoursOfWeeklyStudyII;
    private Integer interactionWithLecturer;
    private Double gpaYearI;
    private Double gpaYearII;
    private Double finalGpa;
    private Integer developedProjects;

    public StudentDTO() {
    }

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

    @Override
    public String toString() {
        return "StudentDTO{" +
                "registrationNumber='" + registrationNumber +
                ", priorKnowledge=" + priorKnowledge +
                ", hoursOfWeeklyStudyI=" + hoursOfWeeklyStudyI +
                ", hoursOfWeeklyStudyII=" + hoursOfWeeklyStudyII +
                ", interactionWithLecturer=" + interactionWithLecturer +
                ", gpaYearI=" + gpaYearI +
                ", gpaYearII=" + gpaYearII +
                ", finalGpa=" + finalGpa +
                ", developedProjects=" + developedProjects +
                '}';
    }
}
