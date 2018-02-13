package com.utils;

import com.bo.Cercle;
import com.bo.Forme;
import com.bo.Ligne;
import com.bo.Point;
import com.bo.Rectangle;
import com.bo.Triangle;

public class Utils1 {
	public static double distancePointForme(Point p,Forme f) {
		if(f instanceof Ligne) {
					int x1 = ((Ligne) f).getP1().getX();
		int y1 = ((Ligne) f).getP1().getY();
		int x2 = ((Ligne) f).getP2().getX();
		int y2 = ((Ligne) f).getP2().getY();
	return Math.abs((y2-y1)*p.getX() - (x2-x1)*p.getY()+x2*y1-y2*x1)/Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
		}else if(f instanceof Rectangle) {
			double dx = Math.max(Math.abs(p.getX() - ((Rectangle) f).getCentre().getX()) - ((Rectangle) f).getLargeur() / 2, 0);
			double dy = Math.max(Math.abs(p.getY() - ((Rectangle) f).getCentre().getY()) - ((Rectangle) f).getLongueur() / 2, 0);
			//System.out.println(dx * dx + dy * dy);
			return dx * dx + dy * dy;
		}else if(f instanceof Cercle) {
			return Math.sqrt(Math.pow(p.getX()-((Cercle) f).getCenter().getX(), 2)+Math.pow(p.getY()-((Cercle) f).getCenter().getY(), 2));
		}else if(f instanceof Triangle) {
			return Math.sqrt(Math.pow(p.getX()-((Triangle) f).getP1().getX(), 2)+Math.pow(p.getY()-((Triangle) f).getP1().getY(), 2));
		}else {
			return -1;
		}

		
	}
}
