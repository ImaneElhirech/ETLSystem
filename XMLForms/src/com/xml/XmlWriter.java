package com.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import com.bo.Annotation;
import com.bo.Cercle;
import com.bo.Forme;
import com.bo.Ligne;
import com.bo.Rectangle;
import com.bo.Triangle;

public class XmlWriter {
	private Document doc;

	public void convert(String pFile, List<Forme> formes, List<Annotation> annotations) throws XmlException {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();
			// root element
			Element rootElement = doc.createElement("figures");
			doc.appendChild(rootElement);

			for (Forme it : formes) {
				if (it instanceof Ligne) {
					Element ligne = doc.createElement("ligne");
					Element point1 = doc.createElement("point1");
					point1.setAttribute("x", String.valueOf(((Ligne) it).getP1().getX()));
					point1.setAttribute("y", String.valueOf(((Ligne) it).getP1().getY()));

					Element point2 = doc.createElement("point2");
					point2.setAttribute("x", String.valueOf(((Ligne) it).getP2().getX()));
					point2.setAttribute("y", String.valueOf(((Ligne) it).getP2().getY()));
					ligne.setAttribute("name", String.valueOf(((Ligne) it).getId()));

					ligne.appendChild(point1);
					ligne.appendChild(point2);

					rootElement.appendChild(ligne);
				} else if (it instanceof Rectangle) {
					Element rectangle = doc.createElement("rectangle");

					Element point1 = doc.createElement("point1");
					point1.setAttribute("x", String.valueOf(((Rectangle) it).getP1().getX()));
					point1.setAttribute("y", String.valueOf(((Rectangle) it).getP1().getY()));
					Element point2 = doc.createElement("point2");
					point2.setAttribute("x", String.valueOf(((Rectangle) it).getP2().getX()));
					point2.setAttribute("y", String.valueOf(((Rectangle) it).getP2().getY()));
					Element centre = doc.createElement("centre");
					centre.setAttribute("x", String.valueOf(((Rectangle) it).getCentre().getX()));
					centre.setAttribute("y", String.valueOf(((Rectangle) it).getCentre().getY()));
					rectangle.setAttribute("name", String.valueOf(((Rectangle) it).getId()));
					rectangle.setAttribute("longueur", String.valueOf(((Rectangle) it).getLongueur()));
					rectangle.setAttribute("largeur", String.valueOf(((Rectangle) it).getLargeur()));
					rectangle.appendChild(point1);
					rectangle.appendChild(point2);
					rectangle.appendChild(centre);
					rootElement.appendChild(rectangle);
				} else if (it instanceof Cercle) {
					Element cercle = doc.createElement("cercle");

					Element point1 = doc.createElement("point1");
					point1.setAttribute("x", String.valueOf(((Cercle) it).getP1().getX()));
					point1.setAttribute("y", String.valueOf(((Cercle) it).getP1().getY()));
					Element point2 = doc.createElement("point2");
					point2.setAttribute("x", String.valueOf(((Cercle) it).getP2().getX()));
					point2.setAttribute("y", String.valueOf(((Cercle) it).getP2().getY()));
					Element centre = doc.createElement("centre");
					centre.setAttribute("x", String.valueOf(((Cercle) it).getCenter().getX()));
					centre.setAttribute("y", String.valueOf(((Cercle) it).getCenter().getY()));
					cercle.setAttribute("name", String.valueOf(((Cercle) it).getId()));
					cercle.setAttribute("rayon", String.valueOf(((Cercle) it).getRayon()));
					cercle.appendChild(point1);
					cercle.appendChild(point2);
					cercle.appendChild(centre);
					rootElement.appendChild(cercle);
				}else if(it instanceof Triangle) {
					Element triangle = doc.createElement("triangle");

					Element point1 = doc.createElement("point1");
					point1.setAttribute("x", String.valueOf(((Triangle) it).getP1().getX()));
					point1.setAttribute("y", String.valueOf(((Triangle) it).getP1().getY()));
					Element point2 = doc.createElement("point2");
					point2.setAttribute("x", String.valueOf(((Triangle) it).getP2().getX()));
					point2.setAttribute("y", String.valueOf(((Triangle) it).getP2().getY()));
					Element point3 = doc.createElement("point3");
					point3.setAttribute("x", String.valueOf(((Triangle) it).getP3().getX()));
					point3.setAttribute("y", String.valueOf(((Triangle) it).getP3().getY()));
					triangle.setAttribute("name", String.valueOf(((Triangle) it).getId()));
					triangle.appendChild(point1);
					triangle.appendChild(point2);
					triangle.appendChild(point3);
					rootElement.appendChild(triangle);
				}
			}
			for (Annotation it : annotations) {
				Element annotation = doc.createElement("annotation");
				String composants="";
				int i=0;
				for (Forme itt : it.getFormes()) {
					i++;
					 composants = composants+"  composant"+i+" "+itt.getId();
					
//					Element ligne1 = doc.createElement(itt.getId());
//					annotation.appendChild(ligne1);
				}
				annotation.setAttribute("composant",composants);
				annotation.setAttribute("relation", it.getAnnotation());
//				Element ann = doc.createElement(it.getAnnotation());
//				annotation.appendChild(ann);
				rootElement.appendChild(annotation);
			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(pFile));
			transformer.transform(source, result);

			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);

		} catch (Exception e) {
			throw new XmlException(e);
		}

	}

	public XmlWriter() {
	}

}
