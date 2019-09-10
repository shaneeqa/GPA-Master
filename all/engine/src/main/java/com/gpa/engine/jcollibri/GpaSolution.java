package com.gpa.engine.jcollibri;

import es.ucm.fdi.gaia.jcolibri.cbrcore.Attribute;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CaseComponent;

public class GpaSolution implements CaseComponent
{
	String id;
    String fix;

	

	@Override
	public String toString() {
		return "GpaSolution [id=" + id + ", fix=" + fix + "]";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getFix() {
		return fix;
	}



	public void setFix(String fix) {
		this.fix = fix;
	}

    public Attribute getIdAttribute()
    {
	return new Attribute("id",this.getClass());
    }

}
