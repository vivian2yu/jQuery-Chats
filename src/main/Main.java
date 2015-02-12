package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static List<String> MESSAGELIST;
	private static List<String> USERLIST;
	private static String USERNAME = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// doPost(request, response);
		PrintWriter out = response.getWriter();

		Dog dog = (Dog) getServletContext().getAttribute("dog");
		out.println("Dog's breed is: " + dog.getBreed());

		out.println("test context attributes<br>");
		// eg1
		HttpSession session = request.getSession();
		String sessionID = request.getParameter("jsessionid");

		out.println("SessionId: " + sessionID);// sessionID是cookie放进去的，那Cookie是怎么放进去的？

		if (session.isNew()) {
			out.println("This is a new session");
		} else {
			out.println("welcome back!");
		}
		session.setMaxInactiveInterval(20 * 60);// 秒 DD里面是分钟 eg:15

		// eg2
		HttpSession sessionAlready = request.getSession(false);// 传入false，意为拿到一个已经有的session会话；如果没有则返回null

		if (sessionAlready == null) {
			out.println("no session was avaliable");
			out.println("make one.....");
			sessionAlready = request.getSession();
		} else {
			out.println("there was a session");
		}

		synchronized (getServletContext()) {// 对上下文属性同步
			// synchronized (session) { //对会话同步
			//
			// }
			getServletContext().setAttribute("foo", "22");
			getServletContext().setAttribute("bar", "42");

			out.println(getServletContext().getAttribute("foo"));
			out.println(getServletContext().getAttribute("bar"));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=GBK");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		request.getServletContext().getInitParameter("");
		String action = request.getParameter("action");
		if (action.equals("login")) {
			String userName = request.getParameter("name");
			String userPass = request.getParameter("pass");
			List<String> userList = USERLIST;
			if (userName.equals("") && userPass.equals("")) {
				userName = "user name cannot be empty";
				out.print(false);
			} else {
				USERNAME = userName;
				if (userList == null) {
					userList = new ArrayList<String>();
				}
				userList.add(userName);
				USERLIST = userList;
				out.print(true);
			}
		} else if (action.equals("chatList")) {
			String strContent = "";
			List<String> contentList = MESSAGELIST;
			if (contentList == null) {
				strContent = "目前没有聊天记录";
			} else {
				for (String str : contentList) {
					strContent += str + "<br/>";
				}
			}
			strContent = strContent.replace("<:", "<img src='face/");
			strContent = strContent.replace(":>", ".gif'/>");
			out.print(strContent);

		} else if (action.equals("onlineList")) {
			String strUser = "";
			List<String> userList = USERLIST;
			if (userList == null) {
				userList = new ArrayList<String>();
			}
			for (String str : userList) {
				strUser += str + "<br/>";
			}
			out.print(strUser);
		} else if (action.equals("sendContent")) {
			String data = request.getParameter("date");
			String strContent = request.getParameter("content");
			String sendContent = USERNAME + " 于" + data.toString() + " 说：" + strContent;
			List<String> contentList = MESSAGELIST;
			if (contentList == null) {
				contentList = new ArrayList<String>();
			}
			contentList.add(sendContent);
			MESSAGELIST = contentList;
			out.print(true);
		} else {
			out.print(false);
		}

		out.flush();
		out.close();
	}
}
