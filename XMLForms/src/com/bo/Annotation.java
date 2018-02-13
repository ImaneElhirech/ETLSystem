package com.bo;

import java.util.ArrayList;

import java.util.List;


public class Annotation {
private List<Forme> formes;
private String annotation;

public Annotation(List<Forme> formes,String annotation) {
	super();
	this.formes = formes;
	this.annotation=annotation;
}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Forme it: formes) {
						sb.append(it.toString());
		    sb.append(" et ");
			}
		return sb.toString()+" sont "+annotation;
	}

	public List<Forme> getFormes() {
		return formes;
	}

	public void setFormes(List<Forme> formes) {
		this.formes = formes;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}
	

}
