package com.bo;



public class Triangle extends Forme{
	String id;

	private Point p1;
	private Point p2;
	private Point p3;
	
	public Triangle(){
		
	}
	
	public Triangle(Point p1,Point p2,String nom,int x,int y){
		this.p1=p1;
		this.p2=p2;
		Point p= new Point(x,y);
		p3=p;
		id=nom;
		
                                              }
	
	
	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	
	public String toString() {
		return this.id;
	}
	
}
