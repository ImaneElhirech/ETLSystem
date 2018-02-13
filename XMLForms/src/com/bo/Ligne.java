package com.bo;


public class Ligne extends Forme{
	private String id;
private Point p1;
private Point p2;


	public Ligne() {
	}

	public Ligne(Point p1, Point p2) {
		
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
public Ligne(Point p1, Point p2,String nom) {
		
this.p1=p1;
this.p2=p2;
id=nom;
	}
	
	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
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
