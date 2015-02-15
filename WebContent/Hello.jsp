<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h2>Welcome to our page!</h2>
<!-- scriptlet -->
<%--  <% if(request.getParameter("username")==null){%>
	<jsp:forward page="HandleLogin.jsp"></jsp:forward>
<%} %>
--%>
<!--  -->
<!-- JSTL -->
<c:if test="${empty param.username}">
	<jsp:forward page="HandleLogin.jsp"/>
</c:if>
Hello ${param.username}
</body>
</html>