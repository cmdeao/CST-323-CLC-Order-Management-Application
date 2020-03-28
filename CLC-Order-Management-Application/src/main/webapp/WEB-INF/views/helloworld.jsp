<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String name = (String)session.getAttribute("sessName");
%>
<head>
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- <title>Welcome ${user.firstName}!</title> -->
	<title><% out.print("Welcome!"); %></title>
</head>
<body>

<ul class="nav">
	<li><a href="homePage" class="active">Home</a></li>
	<li><a href="placeOrder">Place Order</a></li>
	<li><a href="viewOrders">View Orders</a></li>
</ul>
<br>
<div>
	<center>
		<h2>
			${message}
		</h2>
		<div>
			<a href="placeOrder">Place Order</a>
			<a href="viewOrders">View Orders</a>
		</div>
	</center>
</div>
</body>
</html>