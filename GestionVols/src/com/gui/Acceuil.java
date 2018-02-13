package com.gui;
import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import javax.swing.*;
	import javax.swing.border.TitledBorder;

	import com.mysql.jdbc.Statement;
public class Acceuil extends JFrame {
	

	    public Acceuil() {
	    	
	super();

	/*Initialisation du JFrame*/
	this.setSize (new Dimension (600,200));
	
	//On ne pourra pas agrandir la fenetre intitulée.
	this.setResizable (false);

	//valider.addActionListener(new ValiderListener());

	/*Récupération du ContentPane*/
	Container contenu = this.getContentPane();
	
	
	JPanel panel1 = new JPanel(new GridLayout (1,1));
	JPanel panel2 = new JPanel(new FlowLayout ());

	contenu.add(panel1, BorderLayout.NORTH);
    contenu.add(panel2, BorderLayout.CENTER);
   
	
	

	    /*Ajout du formulaire de connexion à panelCentre*/
	ImageIcon icon = new ImageIcon("icon-plane.png");
	Image image = icon.getImage(); // transform it 
	Image newimg = image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	icon = new ImageIcon(newimg); 
	JLabel img = new JLabel(icon);
	panel1.add(img);
	
	
	ImageIcon icon2 = new ImageIcon("images.jpg");
	Image image2 = icon2.getImage(); // transform it 
	Image newimg2 = image2.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	icon2 = new ImageIcon(newimg2);
	JLabel img2 = new JLabel(icon2);
	panel1.add(img2);
	
	
	ImageIcon icon3 = new ImageIcon("images (1).jpg");
	Image image3 = icon3.getImage(); // transform it 
	Image newimg3 = image3.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	icon3 = new ImageIcon(newimg3);
	JLabel img3 = new JLabel(icon3);
	panel1.add(img3);
	

	
	
	JButton boutonRes=new JButton("Réserver");
	boutonRes.setPreferredSize(new Dimension(150,50)); 
	panel2.add(boutonRes);
	
	JButton boutonResListe=new JButton("Consulter Réservation");
	boutonResListe.setPreferredSize(new Dimension(200,50)); 
	panel2.add(boutonResListe);
	
	JButton boutonVolListe=new JButton("Consulter Vols");
	boutonVolListe.setPreferredSize(new Dimension(200,50)); 
	panel2.add(boutonVolListe);
	
	boutonRes.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e){
			new PageReservation();
		}
	});
	
boutonVolListe.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e){
			new listeVols();
		}
	});

boutonResListe.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e){
		new listeVols();
	}
});
	
	

	
	
	    
setVisible(true);

	    }
	    
	    public static void main(String[] args) {
			new Acceuil();
		}



}
