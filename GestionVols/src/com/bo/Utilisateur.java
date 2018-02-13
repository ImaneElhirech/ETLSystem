package com.bo;

public class Utilisateur {
	
	private static String user;
	private  static String password;
	public Utilisateur(String user, String password) {
		this.user=user;
		this.password=password;
	}
	public static String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public  static String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Utilisateur [user=" + user + ", password=" + password + "]";
	}
	
	

}
