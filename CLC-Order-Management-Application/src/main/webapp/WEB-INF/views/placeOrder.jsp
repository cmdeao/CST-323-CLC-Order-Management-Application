<%--
  Created by IntelliJ IDEA.
  User: John Harrison
  Date: 03/7/2020
  Time: 10:49
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
</style>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Place an Order</title>
</head>
<body>
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
</body>
</html>
