package com.bo;

public class Passager extends Personne{
	
	int idPassager;
	
	
	

	public int getIdPassager() {
		return idPassager;
	}




	public void setIdPassager(int idPassager) {
		this.idPassager = idPassager;
	}




	@Override
	public String toString() {
		return "Passager [idPassager=" + idPassager + "]";
	}
	
	
	

}
