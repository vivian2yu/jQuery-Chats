<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="main.Counter,java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	The page count is : 
	<% out.println(Counter.getCount()); %>  <br/>
	The page count is :
	<%= Counter.getCount() %>  <br/>
	<%= new Counter() %>  <br/>
	
	
	<%! int doubleCount(){
		num = num + 2;
		return num;
	} %>
	
	<%! int num=0; %>  
	The num is :
	<%= ++num %>  <br/>
	The doubleCount() is : 
	<%= doubleCount() %>   <br/>
	

	
	The friends who share your hobby of 
	<%= request.getParameter("hobby") %>
	are ：<br>
	<% ArrayList al = (ArrayList) request.getAttribute("names"); %>
	<% Iterator it = al.iterator();
	
		while(it.hasNext()){ %>
		<%= it.next() %>	
		<br>
		<%}%>
</body>
</html>