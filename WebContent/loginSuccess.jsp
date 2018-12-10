<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "s" uri = "/struts-tags" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Add friends</h1>

	<s:form action = "addFriend">
		<s:textfield key="name" label="User Name"/>
		<s:submit/>
	</s:form>
	
	<h1>List of friends</h1>
	
<%-- 	<s:iterator value="${friendList}" var="user"> --%>
<%-- 		<li><s:property value="user.id" /></li> --%>
<%-- 	</s:iterator> --%>
	
	<s:iterator value="#session.user.friends" var="user">
		<li><s:property value="#user.userName" /></li>
	</s:iterator>
	
	
	
</body>
</html>