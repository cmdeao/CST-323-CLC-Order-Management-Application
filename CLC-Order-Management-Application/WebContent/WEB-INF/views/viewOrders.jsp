<%--
  Created by IntelliJ IDEA.
  User: John Harrison
  Date: 03/7/2020
  Time: 15:03
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
    table
    {
        text-align: center;
        width: 100%;
    }
    td
    {
        border: black solid 1px;
    }
</style>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Orders</title>
</head>
<body>
<ul class="nav">
    <li><a href="homePage">Home</a></li>
    <li><a href="placeOrder">Place Order</a></li>
    <li><a href="viewOrders" class="active">View Orders</a></li>
</ul>
<br>
<div>
<table>
    <tr>
        <th>Order ID</th>
        <th>Item</th>
        <th>Description</th>
        <th>Total</th>
        <th>Last 4 digits of Card</th>
        <th>Status</th>
    </tr>
    <c:forEach var="order" items="${list}">
        <tr>
            <td>${order.id}</td>
            <td>${order.item}</td>
            <td>${order.description}</td>
            <td>${order.total}</td>
            <td>${order.card_last_four}</td>
            <td>${order.status}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
