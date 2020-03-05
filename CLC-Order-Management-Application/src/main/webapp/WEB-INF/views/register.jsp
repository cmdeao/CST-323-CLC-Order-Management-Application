<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<br>
<label>Last Name: </label>
<form:input path = "lastName"/>
<br>
<label>Email Address: </label>
<form:input path = "emailAddress"/>
<br>
<label>Phone Number:</label>
<form:input path = "phoneNumber"/>
<br>
<label>Username: </label>
<form:input path = "username"/>
<br>
<label>Password: </label>
<form:input type="password" path = "password"/>
<br>
<input type = "submit" value = "Submit"/>
</form:form>
</body>
</html>