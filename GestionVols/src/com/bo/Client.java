package com.bo;

public class Client extends Personne {
	
	int idClient;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + "]";
	}
	
	

}
