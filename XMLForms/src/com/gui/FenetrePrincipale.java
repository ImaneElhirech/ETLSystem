package com.gui;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


import com.bo.Annotation;
import com.bo.Ligne;
import com.xml.XmlException;
import com.xml.XmlWriter;

public class FenetrePrincipale extends JFrame {
	private JPanel panMenu = new JPanel();
	private JPanel commentPan = new JPanel();
	private PanDessin1 panDessin;
	private JLabel commentLab = new JLabel();
	// private ToolBarDemo toolbar = new ToolBarDemo();
	private JToolBar toolbar = new JToolBar();

	private String comment;
	private List<Annotation> annotations = new ArrayList<Annotation>();

	public FenetrePrincipale() {
		panDessin = new PanDessin1(this);
		setTitle("App xml");
		JButton convertToXML = new JButton("Convert to XML");
		JButton changeMode = new JButton("Activer/desactiver dessin");
		JButton addComment = new JButton("ajouter commentaire");
		JButton Rectangle = new JButton("Rectangle");
		JButton Cercle = new JButton("Cercle");
		JButton Ligne = new JButton("Droite");
		JButton Triangle = new JButton("Triangle");

		panMenu.add(convertToXML, JPanel.LEFT_ALIGNMENT);
		panMenu.add(changeMode, JPanel.LEFT_ALIGNMENT);
		panMenu.add(addComment, JPanel.LEFT_ALIGNMENT);
		panMenu.add(Rectangle, JPanel.LEFT_ALIGNMENT);
		panMenu.add(Cercle, JPanel.LEFT_ALIGNMENT);
		panMenu.add(Ligne, JPanel.LEFT_ALIGNMENT);
		panMenu.add(Triangle, JPanel.LEFT_ALIGNMENT);
		
	

		Rectangle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panDessin.setRectangle(true);
				panDessin.setCercle(false);
				panDessin.setTriangle(false);
				panDessin.setLigne(false);

			}
		});
		Cercle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panDessin.setRectangle(false);
				panDessin.setCercle(true);
				panDessin.setTriangle(false);
				panDessin.setLigne(false);

			}
		});
		Ligne.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panDessin.setRectangle(false);
				panDessin.setCercle(false);
				panDessin.setTriangle(false);
				panDessin.setLigne(true);

			}
		});
		Triangle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panDessin.setRectangle(false);
				panDessin.setCercle(false);
				panDessin.setTriangle(true);
				panDessin.setLigne(false);

			}
		});
		addComment.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!panDessin.isDrawMode()) {

					if (panDessin.isAddComment()) {
						panDessin.setAddComment(false);
					} else {
						panDessin.setAddComment(true);
						comment = JOptionPane.showInputDialog("Entrez votre commentaire");
						Annotation annotation = new Annotation(panDessin.getSelectedForms(), comment);
						annotations.add(annotation);

						writeInCommentsLab(annotation.toString());
					}
				}
			}
		});

		changeMode.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (panDessin.isDrawMode()) {
					panDessin.setDrawMode(false);
				} else {
					panDessin.setDrawMode(true);
				}
			}
		});

		convertToXML.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Convertir formes en xml
				XmlWriter xmlWriter = new XmlWriter();
				try {
					System.out.println(annotations);
					xmlWriter.convert("Fenetre.xml", panDessin.getFormes(), annotations);
					JOptionPane.showMessageDialog(null, "conversion de fichier en xml réalisée", "success",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (XmlException e1) {
					JOptionPane.showMessageDialog(null, "erreur de conversion de fichier en xml", "erreur",
							JOptionPane.ERROR_MESSAGE);
					System.out.println(e1);
				}

			}
		});

		commentPan.add(commentLab);
		add(panMenu, BorderLayout.NORTH);
		add(commentPan, BorderLayout.SOUTH);

		add(panDessin);
		setSize(1000, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void writeInCommentsLab(String pString) {
		commentLab.setText(commentLab.getText() + " | " + pString);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new FenetrePrincipale();
			}
		});
	}

}
