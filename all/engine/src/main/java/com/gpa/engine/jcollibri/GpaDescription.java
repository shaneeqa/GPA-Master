package com.gpa.engine.jcollibri;

import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import es.ucm.fdi.gaia.jcolibri.datatypes.Instance;

public class GpaDescription implements CaseComponent
{
	public enum priorKnowledge{TOOK_ICT_AS_A_SUBJECT_IN_ADVANCED_LEVEL,NVQ_LEVEL_5_IN_ICT_OR_EQUIVALENT_DIPLOMA_IN_ICT,ADVANCED_LEVEL_ICT_AND_DIPLOMA};
	public enum hoursOfWeeklyStudyI{LESS_THAN_SEVEN_HOURS, EIGHT_TO_FOURTEEN_HOURS,FIFTEEN_TO_TWENTY_ONE_HOURS, TWENTY_TWO_TO_TWENTY_EIGHT_HOURS, MORE_THAN_TWENTY_EIGHT_HOURS};
	public enum hoursOfWeeklyStudyII{LESS_THAN_SEVEN_HOURS, EIGHT_TO_FOURTEEN_HOURS,FIFTEEN_TO_TWENTY_ONE_HOURS, TWENTY_TWO_TO_TWENTY_EIGHT_HOURS, MORE_THAN_TWENTY_EIGHT_HOURS};
	public enum interactionWithLecturer{RARELY_ATTENDED_TO_THE_LECTURES_BUT_SIT_FOR_ASSIGNMENTS_AND_EXAMS_NO_INTERACTION_WITH_LECTURER, ATTENDED_LECTURES_WITH_LESS_PERCENTAGE_OF_ABSENT, ATTENDED_LECTURES_WITHOUT_FAIL_AND_CLEARED_DOUBTS_IN_MODULES_WITH_RESPECTIVE_LECTURERS};
    String id;
	String priorKnowledge;
	String hoursOfWeeklyStudyI;
	String hoursOfWeeklyStudyII;
	String interactionWithLecturer;
	Integer developedProjects;
	Double gpaYearI;
	Double gpaYearII;
	Double finalGpa;
	Instance preferredArea;

	@Override
	public String toString() {
		return "GpaDescription{" +
				"id='" + id + '\'' +
				", priorKnowledge=" + priorKnowledge +
				", hoursOfWeeklyStudyI=" + hoursOfWeeklyStudyI +
				", hoursOfWeeklyStudyII=" + hoursOfWeeklyStudyII +
				", interactionWithLecturer=" + interactionWithLecturer +
				", developedProjects=" + developedProjects +
				", gpaYearI=" + gpaYearI +
				", gpaYearII=" + gpaYearII +
				", finalGpa=" + finalGpa +
				", preferredArea=" + preferredArea +
				'}';
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getDevelopedProjects() {
		return developedProjects;
	}

	public void setDevelopedProjects(Integer developedProjects) {
		this.developedProjects = developedProjects;
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

	public Instance getPreferredArea() {
		return preferredArea;
	}

	public void setPreferredArea(Instance preferredArea) {
		this.preferredArea = preferredArea;
	}

	public Attribute getIdAttribute()
    {
	return new Attribute("id",this.getClass());
    }

}
