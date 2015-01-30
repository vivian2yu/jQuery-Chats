package Main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userName = request.getParameter("name");
		String userPass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		if (userName.equals("") && userPass.equals("")) {
			userName = "user name cannot be empty";
			out.print(false);
		} else {
			userName = "hahah";
			out.print(true);
		}
		out.flush();
		out.close();
	}
}
