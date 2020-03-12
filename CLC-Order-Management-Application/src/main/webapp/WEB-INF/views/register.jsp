<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<div>
Please Register to Continue:
<form:form method="POST" action = "helloworld" modelAttribute="user">
<form:errors path ="*" cssClass = "errorblock" element = "div"/>
    <table>
        <tr>
            <td>First Name: </td>
            <td><form:input path = "firstName"/></td>
            <td><form:errors path = "firstName" cssClass = "error"/></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><form:input path = "lastName"/></td>
            <td><form:errors path = "lastName" cssClass = "error"/></td>
        </tr>
        <tr>
            <td>Eamil Address: </td>
            <td><form:input path = "emailAddress"/></td>
            <td><form:errors path = "emailAddress" cssClass = "error"/></td>
        </tr>
        <tr>
            <td>Phone Number: </td>
            <td><form:input path = "phoneNumber"/></td>
            <td><form:errors path = "phoneNumber" cssClass = "error"/></td>
        </tr>
        <tr>
            <td>Username: </td>
            <td><form:input path = "username"/></td>
            <td><form:errors path = "username" cssClass = "error"/></td>
        </tr>
        <tr>
            <td>Password: </td>
            <td><form:input type="password" path = "password"/></td>
            <td><form:errors path = "password" cssClass = "error"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type = "submit" value = "Submit"/></td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>