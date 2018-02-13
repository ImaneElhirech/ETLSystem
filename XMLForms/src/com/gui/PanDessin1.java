package com.gui;


import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.bo.Cercle;
import com.bo.Forme;
import com.bo.Ligne;
import com.bo.Point;
import com.bo.Rectangle;
import com.bo.Triangle;
import com.utils.Utils;
import com.utils.Utils1;


public class PanDessin1 extends JPanel{
	private List<Forme> formes = new ArrayList<Forme>();
	private boolean drawMode = true;
	private boolean addComment = false;
	private boolean rectangle = false;
	private boolean cercle = false;
	private boolean ligne = false;
	private boolean triangle = false;
	private Forme SelectedForme;
	private List<Forme> SelectedForms = new ArrayList<Forme>();
	 Point startDrag, endDrag;
	 Point p1,p2;

	public void add(Forme f) {
		formes.add(f);
	}

	public PanDessin1(FenetrePrincipale parent) {
		SelectedForms.clear();
		
		addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {

				startDrag = new Point(e.getX(), e.getY());
				
				
			}

			public void mouseReleased(MouseEvent e) {

				 endDrag = new Point(e.getX(), e.getY());
				
				Forme formeDistanceMin = null;

				if (drawMode) {
					SelectedForms.clear();
					if(rectangle) {
						String nom = JOptionPane.showInputDialog("Entrez nom de forme");
						double longueur = Double.valueOf(JOptionPane.showInputDialog("longueur:"));
						double largeur = Double.valueOf(JOptionPane.showInputDialog("largeur:"));
						formes.add(new Rectangle(startDrag, endDrag, nom, longueur, largeur));
						repaint();
					}else if(cercle) {
						String nom = JOptionPane.showInputDialog("Entrez nom de forme");
						float rayon = Float.valueOf(JOptionPane.showInputDialog("rayon:"));
						
						formes.add(new Cercle(startDrag, endDrag, nom, rayon));
						repaint();
					}else if(ligne) {
						String nom = JOptionPane.showInputDialog("Entrez nom de forme");
						formes.add(new Ligne(startDrag, endDrag, nom));
						repaint();
					}else if(triangle) {
						String nom = JOptionPane.showInputDialog("Entrez nom de forme");
						int x3 =Integer.valueOf(JOptionPane.showInputDialog("x3:"));
						int y3 = Integer.valueOf(JOptionPane.showInputDialog("y3:"));
						formes.add(new Triangle(startDrag, endDrag, nom, x3, y3));
						repaint();
					}
					

				} else {

					if (!formes.isEmpty()) {
					
						formeDistanceMin = formes.get(0);

						for (Forme it : formes) {

							if (Utils1.distancePointForme(endDrag, it) < Utils1.distancePointForme(endDrag, formeDistanceMin)) {
								formeDistanceMin = it;
							}
							SelectedForme = formeDistanceMin;

						}
						SelectedForms.add(SelectedForme);

					}
				}
			}
		});
	
		

	}

	public void convertToXml() {

	}

	public void drawForms(Graphics g) {
		for (Forme it : formes) {
			if(it instanceof Ligne) {
				g.drawLine(((Ligne) it).getP1().getX(), ((Ligne) it).getP1().getY(), ((Ligne) it).getP2().getX(), ((Ligne) it).getP2().getY());
			}else if(it instanceof Rectangle) {
				//System.out.println(((Rectangle) it).getP1());
				g.drawRect(((Rectangle) it).getP1().getX(),((Rectangle) it).getP1().getY(),(int)((Rectangle) it).getLargeur(), (int)((Rectangle) it).getLongueur());
			}else if(it instanceof Cercle) {
				g.drawOval(((Cercle) it).getP1().getX(), ((Cercle) it).getP1().getY(), (int)((Cercle) it).getRayon(), (int)((Cercle) it).getRayon());
				
			}else if(it instanceof Triangle) {
				Polygon P;
				int []t1={((Triangle) it).getP1().getX(), ((Triangle) it).getP2().getX(), ((Triangle) it).getP3().getX()};
				int []t2={((Triangle) it).getP1().getY(), ((Triangle) it).getP2().getY(), ((Triangle) it).getP3().getY()};
				P=new Polygon();
				P.xpoints=t1;
				P.ypoints=t2;
				P.npoints=3;
				g.drawPolygon(P);
				
			}
		}

	}
	
	

	public void paint(Graphics g) {
		
		if (!formes.isEmpty()) {
			super.paint(g);
		//System.out.println(formes.size());
					drawForms(g);
				
			}
			
			
		}

	

	public List<Forme> getLignes() {
		return formes;
	}

	public void setLignes(List<Forme> formes) {
		this.formes = formes;
	}

	public boolean isDrawMode() {
		return drawMode;
	}

	public void setDrawMode(boolean drawMode) {
		this.drawMode = drawMode;
	}

	public Forme getSelectedLine() {
		return SelectedForme;
	}

	public void setSelectedLine(Forme selectedforme) {
		SelectedForme = selectedforme;
	}

	public boolean isAddComment() {
		return addComment;
	}

	public void setAddComment(boolean addComment) {
		this.addComment = addComment;
	}

	

	public void setSelectedLines(List<Forme> selectedForms) {
		SelectedForms= selectedForms;
	}

	public List<Forme> getFormes() {
		return formes;
	}

	public void setFormes(List<Forme> formes) {
		this.formes = formes;
	}

	public boolean isRectangle() {
		return rectangle;
	}

	public void setRectangle(boolean rectangle) {
		this.rectangle = rectangle;
	}

	public boolean isCercle() {
		return cercle;
	}

	public void setCercle(boolean cercle) {
		this.cercle = cercle;
	}

	public boolean isLigne() {
		return ligne;
	}

	public void setLigne(boolean ligne) {
		this.ligne = ligne;
	}

	public boolean isTriangle() {
		return triangle;
	}

	public void setTriangle(boolean triangle) {
		this.triangle = triangle;
	}

	public Forme getSelectedForme() {
		return SelectedForme;
	}

	public void setSelectedForme(Forme selectedForme) {
		SelectedForme = selectedForme;
	}

	public List<Forme> getSelectedForms() {
		return SelectedForms;
	}

	public void setSelectedForms(List<Forme> selectedForms) {
		SelectedForms = selectedForms;
	}

	public Point getStartDrag() {
		return startDrag;
	}

	public void setStartDrag(Point startDrag) {
		this.startDrag = startDrag;
	}

	public Point getEndDrag() {
		return endDrag;
	}

	public void setEndDrag(Point endDrag) {
		this.endDrag = endDrag;
	}


	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}
	

}
