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
    .error{
        color: #ff0000;
    }
    .errorblock{
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Orders</title>
</head>
<body>
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
<br>
<a href="placeOrder">Place another order</a>
</body>
</html>
