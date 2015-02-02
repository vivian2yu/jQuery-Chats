package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static List<String> MESSAGELIST;
	private static List<String> USERLIST;
	private static String USERNAME = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

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
			String sendContent = USERNAME + "于" + data.toString() + "说：" + strContent;
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
