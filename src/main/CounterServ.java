package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServ
 */
public class CounterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CounterServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		ArrayList<String> names = new ArrayList<String>();
		names.add("tt");
		names.add("dd");
		names.add("hh");
		request.setAttribute("names", names);
		String[] movie1 = { "Matrix Revolutions", "Kill Bill", "Boondock Saints" };
		String[] movie2 = { "Amelie", "Return of the King", "Mean Girls" };
		List<String[]> movieList = new ArrayList<String[]>();
		movieList.add(movie1);
		movieList.add(movie2);
		request.setAttribute("movies", movieList);
		RequestDispatcher view = request.getRequestDispatcher("CountTest.jsp");
		view.forward(request, response);
	}
}
