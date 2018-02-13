package com.bo;

public class Cercle extends Forme {
private String id;
private float rayon;
private Point center;
private Point p1;
private Point p2;
	
	public Cercle(){
	}
	
public Cercle( Point p1, Point p2, String nom,float rayon){
this.p1=p1;
this.p2=p2;
this.id= nom;
this.rayon=rayon;
	Point p = new Point((p1.getX()+p2.getX())/2,(p1.getY()+p2.getY())/2);
	center=p;

	}

	public float getRayon() {
		return rayon;
	}

	public void setRayon(float rayon) {
		this.rayon = rayon;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
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
		return id;
	};
	
}
