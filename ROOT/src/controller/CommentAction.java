package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CommentDAO;
import model.Comment;
import model.Product;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/CommentAction")
public class CommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Product product = (Product) session.getAttribute("single");
		String nameCustomer = request.getParameter("name");
		String email = request.getParameter("email");
		String context = request.getParameter("context");
		if (nameCustomer == "" && email == "") {
			request.setAttribute("errCmt", "Bạn phải đăng nhập trước khi comment!");
			request.getRequestDispatcher("single.jsp").forward(request, response);
		} else {
			Comment comment = new Comment(product.getIdProduct(), nameCustomer, context, email);
			CommentDAO.createComment(comment);
			request.getRequestDispatcher("single.jsp").forward(request, response);
		}

	}

}
