package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import model.Product;

@WebServlet({ "/ViewProductByCate" })
public class ViewProductByCate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewProductByCate() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action.equalsIgnoreCase("viewProd")) {
			int idCate = Integer.parseInt(request.getParameter("id"));
			session.setAttribute("idCate", Integer.valueOf(idCate));
			// request.getRequestDispatcher("product.jsp").forward(request,
			// response);
			response.sendRedirect("product.jsp");
		}
		if (action.equalsIgnoreCase("getAProduct")) {
			int idProduct = Integer.parseInt(request.getParameter("id"));
			Product product = ProductDAO.getProduct(idProduct);

			session.setAttribute("single", product);
			response.sendRedirect("single.jsp");
		}
	}
}