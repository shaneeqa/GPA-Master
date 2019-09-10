package com.gpa.engine.jcollibri;

import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;
import es.ucm.fdi.gaia.jcolibri.datatypes.Instance;

public class GpaDescription implements CaseComponent
{
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
