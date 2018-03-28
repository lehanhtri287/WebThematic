package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoggoutServlet
 */
@WebServlet("/LoggoutServlet")
public class LoggoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoggoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("userLogged", null);
		session.setAttribute("userAdmin", null);
		response.sendRedirect("index.jsp");
	}

}
