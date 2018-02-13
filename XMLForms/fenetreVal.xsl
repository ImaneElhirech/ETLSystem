<?xml version="1.0" encoding="UTF-8"  standalone="yes"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html>

	<head>
<title>Xslt_Html</title>
	</head>

	<body>
	<center><h1>XENSAH Fomrs</h1></center>
	<div>
	<center><img src="testim.jpg" height="100" width="100"/></center>
	
	</div>
	<div>
	<center>
	<table border="1" cellpadding="15" cellspacing="10">
	<tr>
  <td>Forme geometrique</td>
  <td>Point1</td>
  <td>Point2</td>
  <td>Point3</td>
  <td>Centre</td>
  <td>Rayon</td>
  <td>longueur</td>
  <td>largeur</td>
  
  	</tr>
  	<tr>
  	<td>cercle</td>
	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x1:<xsl:value-of select="figures/cercle/point1/@x" /></td>
	<td>y1:<xsl:value-of select="figures/cercle/point1/@y" /></td>
	</tr>
	</table>
	</td>
	
	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x2:<xsl:value-of select="figures/cercle/point2/@x" /></td>
	<td>y2:<xsl:value-of select="figures/cercle/point2/@y" /></td>
	</tr>
	</table>
	</td>
	
  	<td>****</td>
  	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x:<xsl:value-of select="figures/cercle/centre/@x" /></td>
	<td>y:<xsl:value-of select="figures/cercle/centre/@y" /></td>
	</tr>
	</table>
	</td>
	    
  	<td><xsl:value-of select="figures/cercle/@rayon" /></td>
	<td>****</td>
	<td>****</td>
  	</tr>
	
	
	<tr>
  	<td>Rectangle</td>
	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x1:<xsl:value-of select="figures/rectangle/point1/@x" /></td>
	<td>y1:<xsl:value-of select="figures/rectangle/point1/@y" /></td>
	</tr>
	</table>
	</td>
	
	<td>****</td>
	
  	<td>****</td>
  	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x:<xsl:value-of select="figures/rectangle/centre/@x" /></td>
	<td>y:<xsl:value-of select="figures/rectangle/centre/@y" /></td>
	</tr>
	</table>
	</td>
	    
  	<td>****</td>
	<td><xsl:value-of select="figures/rectangle/@longueur" /></td>
	<td><xsl:value-of select="figures/rectangle/@largeur" /></td>
  	</tr>
  	
	
	
	<tr>
  	<td>Ligne</td>
	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x1:<xsl:value-of select="figures/ligne/point1/@x" /></td>
	<td>y1:<xsl:value-of select="figures/ligne/point1/@y" /></td>
	</tr>
	</table>
	</td>
	
	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x2:<xsl:value-of select="figures/ligne/point2/@x" /></td>
	<td>y2:<xsl:value-of select="figures/ligne/point2/@y" /></td>
	</tr>
	</table>
	</td>
	
  	<td>****</td>
  	
	 <td>****</td>   
  	<td>****</td>
	<td>****</td>
	<td>****</td>
  	</tr>
	
	<tr>
  	<td>Triangle</td>
	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x1:<xsl:value-of select="figures/triangle/point1/@x" /></td>
	<td>y1:<xsl:value-of select="figures/triangle/point1/@y" /></td>
	</tr>
	</table>
	</td>
	
	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x2:<xsl:value-of select="figures/triangle/point2/@x" /></td>
	<td>y2:<xsl:value-of select="figures/triangle/point2/@y" /></td>
	</tr>
	</table>
	</td>
	
  	<td>
	    <table border="1" cellpadding="15" cellspacing="10">
		<tr>
  	<td>x2:<xsl:value-of select="figures/triangle/point3/@x" /></td>
	<td>y2:<xsl:value-of select="figures/triangle/point3/@y" /></td>
	</tr>
	</table>
	</td>
  	
	 <td>****</td>   
  	<td>****</td>
	<td>****</td>
	<td>****</td>
  	</tr>
	
	
	
	</table>
	</center>
	
	</div>
	</body>

</html>
</xsl:template>
</xsl:stylesheet>