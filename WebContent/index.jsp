<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to my social media app</title>
</head>
<body>
	<s:form action = "login">
		<s:textfield key="user.userName" label="User Name"/>
		<s:password key="user.password" label="Password"/>
		<s:submit/>
	</s:form>
	
	
	<s:form action = "/register.jsp">
		<input type="submit" value="Register"/>
		
	</s:form>
</body>
</html>