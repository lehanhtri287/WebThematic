package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userName = request.getParameter("email");
		String password = request.getParameter("password");
		if (userName == "" && password == "") {
			request.setAttribute("errEmail", "*");
			request.setAttribute("errPass", "*");
			request.getRequestDispatcher("account.jsp").forward(request, response);
		} else if (!UserDAO.checkUserLogin(userName, password)) {
			request.setAttribute("email", userName);
			request.setAttribute("errPass", "Mật khẩu hoặc email không đúng");
			request.getRequestDispatcher("account.jsp").forward(request, response);
		} else {
			User userLogged = UserDAO.getUser(userName);
			if (userLogged.getRole().equalsIgnoreCase("ADM")) {
				session.setAttribute("userAdmin", userLogged);
				request.getRequestDispatcher("/admin/indexAdmin.jsp").forward(request, response);
			} else {
				session.setAttribute("userLogged", userLogged);
				response.sendRedirect("index.jsp");
			}
		}
	}

}
