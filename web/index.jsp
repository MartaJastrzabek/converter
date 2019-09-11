<%--
  Created by IntelliJ IDEA.
  User: Marta
  Date: 11.09.2019
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Przelicznik miar</title>
</head>
<body>
<h2>Przelicznik metryczny</h2>
<form action="/metricconverter" method="get">
  <input type="number" placeholder="metry" name="meters"></br>
  <input type="number" placeholder="centymetry" name="centimeters"></br>
  <input type="number" placeholder="milimetry" name="millimeters"></br>
  <input type="submit" value="Przelicz">
</form>

<h2>Przelicznik wag</h2>
<form action="/weightconverter" method="get">
  <input type="number" placeholder="Kilogramy" name="kilograms"></br>
  <input type="number" placeholder="gramy" name="grams"></br>
  <input type="number" placeholder="miligramy" name="milligrams"></br>
  <input type="submit" value="Przelicz">
</form>
</body>
</html>