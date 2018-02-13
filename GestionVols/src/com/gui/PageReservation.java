package com.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class PageReservation extends JFrame{
	private JTextField field1;
	private JTextField field2;
	private JTextField origine;
	private JTextField destinat;
	private  JLabel depart;
	private JLabel retour;
 
	//...
 
	public PageReservation(){
		setTitle("Réservation"); //On donne un titre à l'application
		setSize(500,200); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
		JPanel panel = new JPanel(new GridLayout (1,1));
		 
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);
		Container contenu = this.getContentPane();
		contenu.add(panel, BorderLayout.NORTH);
		
		
		
		
		origine =new JTextField("Origine");
				origine.setColumns(20);
 
		panel.add(origine);
 
		destinat =new JTextField("Destination");
		destinat.setColumns(20);
 
		panel.add(destinat);
		
		JPanel panel2 = new JPanel(new GridLayout (0,1));
		
		depart =new JLabel("Départ le :");
		panel2.add(depart);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		 
		panel2.add(datePicker);
		
		contenu.add(panel2, BorderLayout.CENTER);

		retour =new JLabel("Retour le :");
		 panel2.add(retour);
		
		
		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
		JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
		 
		panel2.add(datePicker2);

       

        
 
		JButton bouton = new JButton("Rechecher");
 
		panel2.add(bouton);
		
		bouton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){
				new listeVols();
			}
		});
 
		
		setVisible(true);
 
		
	}
	public static void main(String[] args) {
	new PageReservation();
	}
}
