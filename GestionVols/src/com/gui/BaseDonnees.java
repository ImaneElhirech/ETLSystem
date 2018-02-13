package com.gui;
import java.sql.Connection;
import java.sql.DriverManager;

class BaseDonnees {

//Variable pour la connexion	
public Connection conn;

public void ConnexionBD()
{
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(Exception ex)
{ 
System.out.print("Erreur de Chargement");
System.exit(0);
}
try
{
String url = "jdbc:mysql://localhost:3306/vol_db";
String user = "root";
String passwd = "";
conn = DriverManager.getConnection(url, user, passwd);
}
catch(Exception ex)
{
System.out.print("Erreur de connexion à la BD");
}
}

public Connection getConnect()
{
return conn;
}

public void DeconnexionBD()
{
try {
conn.close();
}
catch(Exception ex) {
System.out.print("Déconnexion impossible");
}
}
}

