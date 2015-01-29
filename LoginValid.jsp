<%
	String USERNAME = "vivian.yu";
	String PASSWORD = "123456";

	request.setCharacterEncoding("utf8");

	String userName = request.getParameter("txtName").trim();  
    String userPwd = request.getParameter("txtPass").trim();  

    if(userName.equals(USERNAME) && userPwd.equals(USERPWD)) {  
        return true;
    } else {  
        return false;
    }  
%>