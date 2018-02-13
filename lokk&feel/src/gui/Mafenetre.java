package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mafenetre extends JFrame implements ActionListener{
	//creation des composants
	JLabel JlabelNom= new JLabel("nom:");
	JTextField JtextField = new JTextField(12);
	JButton jbuttonadd= new JButton("ajouter");
	JButton jbuttonsupp= new JButton("supprimer");
	JButton jbuttondep= new JButton("deplacer");
	List list1=new List();
	List list2=new List();
	JLabel JlabelErr= new JLabel("ok");
	
	public Mafenetre(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//creation d'un panneau
		JPanel JPanelN=new JPanel();
	
		JPanelN.setLayout(new FlowLayout());
		//Ajouter les composants
		JPanelN.add(JlabelNom);
		JPanelN.add(JtextField);
		JPanelN.add(jbuttonadd);
		JPanelN.add(jbuttonsupp);
		JPanelN.add(jbuttondep);
		//Placer le panneau dans la fenetre this signifie la fenetre
		this.add(JPanelN, BorderLayout.NORTH);
		//creation d'un nouveau panneau pour ajouer les listes
		JPanel JPanelC= new JPanel();
		JPanelC.setLayout(new GridLayout());
		//Ajouter les deux Listes
		JPanelC.add(list1);
		JPanelC.add(list2);
		//ajouter le panneau dans la fenetre
		this.add(JPanelC,BorderLayout.CENTER);
		//ajouter le label
		this.add(JlabelErr, BorderLayout.SOUTH);
		//dimensionner la fenetre
		this.setBounds(100,10,500,700);
		this.setTitle("ma premiere fenetre");
		//rendre la fenetre visible
		this.setVisible(true);
		jbuttonadd.addActionListener(this);
		jbuttonsupp.addActionListener(this);
		jbuttondep.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbuttonadd){
			String nom=JtextField.getText();
			list1.add(nom);
			
		}
		else if(e.getSource()==jbuttonsupp){
			int index=list1.getSelectedIndex();
			list1.remove(index);
			
		}
		else if (e.getSource()==jbuttondep){
			int index=list1.getSelectedIndex();
			String nom=list1.getSelectedItem();
			list2.add(nom);
			
		}
	}
}
	