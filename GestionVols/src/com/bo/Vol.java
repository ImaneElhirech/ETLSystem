package com.bo;

public class Vol {
	
	int IdVol;
	String DateDepart;
	String DateArrivee;
	public int getIdVol() {
		return IdVol;
	}
	public void setIdVol(int idVol) {
		IdVol = idVol;
	}
	public String getDateDepart() {
		return DateDepart;
	}
	public void setDateDepart(String dateDepart) {
		DateDepart = dateDepart;
	}
	public String getDateArrivee() {
		return DateArrivee;
	}
	public void setDateArrivee(String dateArrivee) {
		DateArrivee = dateArrivee;
	}
	@Override
	public String toString() {
		return "Vol [IdVol=" + IdVol + ", DateDepart=" + DateDepart + ", DateArrivee=" + DateArrivee + "]";
	}
	
	
	

}
