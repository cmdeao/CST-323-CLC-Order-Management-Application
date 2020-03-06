<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<style><
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
<title>Insert title here</title>
</head>
<body>
Please Register to Continue:
<form:form method="POST" action = "helloworld" modelAttribute="user">
<form:errors path ="*" cssClass = "errorblock" element = "div"/>
<label>First Name: </label>
<form:input path = "firstName"/>
<td><form:errors path = "firstName" cssClass = "error"/></td>
<br>
<label>Last Name: </label>
<form:input path = "lastName"/>
<td><form:errors path = "lastName" cssClass = "error"/></td>
<br>
<label>Email Address: </label>
<form:input path = "emailAddress"/>
<td><form:errors path = "emailAddress" cssClass = "error"/></td>
<br>
<label>Phone Number:</label>
<form:input path = "phoneNumber"/>
<td><form:errors path = "phoneNumber" cssClass = "error"/></td>
<br>
<label>Username: </label>
<form:input path = "username"/>
<td><form:errors path = "username" cssClass = "error"/></td>
<br>
<label>Password: </label>
<form:input type="password" path = "password"/>
<td><form:errors path = "password" cssClass = "password"/></td>
<br>
<input type = "submit" value = "Submit"/>
</form:form>
</body>
</html>