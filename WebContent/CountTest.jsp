<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="main.Counter,java.util.*" %>
<%@ taglib prefix="mine" uri="DiceFunctions" %>
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
		
	<hr/>
	
	Names are : ${names[1]} <br/>
	Method is : ${pageContext.request.method} <br/>
	Host is : ${header.host}  <br/>  
	Breed is : ${initParam.breed}  <br/>

	Mine DiceRoller : ${mine.rollIt()}<br/>
	
	<br/>
	<% Float one = new Float(0.15); %>  
	<% pageContext.setAttribute("foo",one); %>
	
	<!-- 获得一个页面作用域属性 -->
	<%= pageContext.getAttribute("foo") %>
	
	<% Float two = new Float(2.14); %>
	<% pageContext.setAttribute("foo",two,pageContext.SESSION_SCOPE); %>
	<%= pageContext.getAttribute("foo") %>
	<hr/>
	
	<table>
		<a:forEach var="listElement" items="${movies}">
			<a:forEach var="movie" items="${listElement}">
				<tr>
					<td>${movie}</td>
				</tr>
			</a:forEach>
		</a:forEach>
	</table>
	
</body>
</html>