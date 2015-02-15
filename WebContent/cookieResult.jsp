<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookie Result</title>
</head>
<body>
	<a href="CheckCookie?username=111" >CLICK HERE</a>
	
		
	<form method="POST" action="CounterServ">
		Choose a hobby:<p>
		<select name="hobby" size="1">
			<option>horse skiing</option>
			<option>extreme knitting</option>
			<option>alpine scuba</option>
			<option>speed dating</option>
		</select>
		<br><br>
		<center>
			<input type="submit"/>
		</center>
	</form>
	
</body>
</html>