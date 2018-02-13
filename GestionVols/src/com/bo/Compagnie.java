package com.bo;

public class Compagnie {
	
	int id;
	String nom;
	String logo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "Compagnie [id=" + id + ", nom=" + nom + ", logo=" + logo + "]";
	}
	
	

}
