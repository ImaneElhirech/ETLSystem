package com.bo;
public class Rectangle extends Forme {
	private String id;
	private double longueur;
    private  double largeur;
   private Point centre;
    private Point p1;
    private Point p2;
    
    public Rectangle( ){
    	super();
     }
    public Rectangle(Point pa,Point pb,String nom,double longueur, double largeur ) {
    	this.longueur=longueur;
  	   this.largeur=largeur;
  	   p1=pa;
  	   p2=pb;
  	   this.id=nom;
  	   
Point p= new Point((int) (p1.getX()+(largeur/2)),(int) (p1.getY()+(longueur/2)));
centre=p;

    }



	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public   double getLargeur() {
		return largeur;
	}

	public  void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	
	
	public Point getCentre() {
		return centre;
	}
	public void setCentre(Point centre) {
		this.centre = centre;
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
};
}
