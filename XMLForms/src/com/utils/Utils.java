package com.utils;

import com.bo.*;

public class Utils {
public static double distancePointLigne(Point p,Ligne l) {
	int x1 = l.getP1().getX();
	int y1 = l.getP1().getY();
	int x2 = l.getP2().getX();
	int y2 = l.getP2().getY();
return Math.abs((y2-y1)*p.getX() - (x2-x1)*p.getY()+x2*y1-y2*x1)/Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
	
}
}
