package com.bo;


import java.util.ArrayList;
import java.util.List;

public abstract class Forme{
	
	protected List<String> comments = new ArrayList<String>();
	protected int nbComments=0;
	protected int numforme=0;
	protected String id;
	protected Point startDrag;
	protected Point endDrag;
	public Forme() {
		
	}
	public Forme(Point startDrag,Point endDrag,String nom) {
	this.startDrag= startDrag;
	this.endDrag= endDrag;
	this.id=nom;
	}
	public void addComments(String comment) {
		comments.add(comment);
		nbComments++;
	}
	public String lastComment() {
		return comments.get(nbComments-1);
	}
	public String getComments() {
		StringBuffer sb = new StringBuffer();
		for(String it : comments) {
			sb.append(it);
			sb.append(" | ");
		}
		return sb.toString();
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

public String toString() {
	return this.id;
}
}
