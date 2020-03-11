<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Login</title>
</head>
<body>
Please Login to Continue:
<form:form method="POST" action = "displayHome" modelAttribute="user">
<form:errors path ="*" cssClass = "errorblock" element = "div"/>
    <table>
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
            <td> <input type = "submit" value = "Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>