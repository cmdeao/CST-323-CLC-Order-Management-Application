<%--
  Created by IntelliJ IDEA.
  User: John Harrison
  Date: 03/7/2020
  Time: 10:49
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Place an Order</title>
</head>
<body>
<ul class="nav">
    <li><a href="hello">Home</a></li>
    <li><a href="placeOrder" class="active">Place Order</a></li>
    <li><a href="viewOrders">View Orders</a></li>
</ul>
<br>
<div>
Place an Order Below:
<form:form method="POST" action = "placeOrder" modelAttribute="order">
    <form:errors path ="*" cssClass = "errorblock" element = "div"/>
    <table>
    <tr>
        <td>Item:</td>
        <td><form:input path = "item" /></td>
        <td><form:errors path = "item" cssClass = "error"/></td>
    </tr>
    <tr>
        <td>Total: $</td>
        <td><form:input path="total"/></td>
        <td><form:errors path = "total" cssClass = "error"/></td>
    </tr>
    <tr>
        <td>Last 4 Digits of Card:</td>
        <td><form:input path="card_last_four"/></td>
        <td><form:errors path = "card_last_four" cssClass = "error"/></td>
    </tr>
    <tr>
        <td>Description of Order: </td>
        <td><form:input path = "description"/></td>
        <td><form:errors path = "description" cssClass = "error"/></td>
    </tr>

    <tr>
        <td>Status:</td>
        <td><form:input path="status"/></td>
        <td><form:errors path = "status" cssClass = "error"/></td>
    </tr>
    <tr>
        <td><input type="hidden" name="user_id" id="user_id" value="${user.id}"/></td>
        <td><input type = "submit" value = "Place Order"/></td>
    </tr>
    </table>
</form:form>
</div>
</body>
</html>
