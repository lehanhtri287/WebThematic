package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDAO;
import model.Product;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		HttpSession session = request.getSession();
		if (action.equalsIgnoreCase("addProdToCart")) {
			int idProd = Integer.parseInt(request.getParameter("id"));
			Product product = ProductDAO.getProduct(idProd);
			addProduct(session, product);
			response.sendRedirect("index.jsp");
		}
		if (action.equalsIgnoreCase("viewCart")) {
			if (session.getAttribute("listProd") == null) {
				ArrayList<Product> products = new ArrayList<>();
				session.setAttribute("listProd", products);
				request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
			}
		}
		if (action.equalsIgnoreCase("updateCart")) {
			int idProd = Integer.parseInt(request.getParameter("id"));

			List<Product> products = (List<Product>) session.getAttribute("listProd");
			updateProduct(session, request, idProd);
			request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		}
		if (action.equalsIgnoreCase("deleteCart")) {
			int idProd = Integer.parseInt(request.getParameter("id"));
			List<Product> products = (List<Product>) session.getAttribute("listProd");
			for (int i = products.size() - 1; i >= 0; i--) {
				if (products.get(i).getIdProduct() == idProd) {
					products.remove(products.get(i));
				}
			}
			session.setAttribute("listProd", products);
			request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		}

		// if (!Validate.checkEmail(email) ||
		// !Validate.checkPhoneNumber(phone) && (name == "" && address ==
		// "")) {
		// request.setAttribute("errEmail", "*");
		// request.setAttribute("email", email);
		//
		// request.setAttribute("errPhone", "*");
		// request.setAttribute("phone", phone);
		// request.setAttribute("errName", "*");
		// request.setAttribute("errAddress", "*");
		// request.getRequestDispatcher("ShoppingCart.jsp").forward(request,
		// response);
		// }

	}

	public void addProduct(HttpSession session, Product product) {
		if (session.getAttribute("listProd") == null) {
			List<Product> products = new ArrayList<>();
			products.add(product);
			session.setAttribute("listProd", products);
		} else {
			Boolean tmp = false;
			List<Product> products = (List<Product>) session.getAttribute("listProd");
			for (Product product2 : products) {
				if (product2.getIdProduct() == product.getIdProduct()) {
					product2.setQuantity(product2.getQuantity() + 1);
					tmp = true;
				}
			}
			if (tmp) {
			} else {
				products.add(product);
			}
			session.setAttribute("listProd", products);
		}
	}

	public void updateProduct(HttpSession session, HttpServletRequest request, int idProduct) {
		List<Product> products = (List<Product>) session.getAttribute("listProd");
		String behavior = request.getParameter("behav");
		if (behavior.equalsIgnoreCase("plus")) {
			for (Product product : products) {
				if (product.getIdProduct() == idProduct) {
					product.setQuantity(product.getQuantity() + 1);
				}
			}
		}
		if (behavior.equalsIgnoreCase("minus")) {
			for (Product product : products) {
				if (product.getIdProduct() == idProduct) {
					if (product.getQuantity() == 1) {
						product.setQuantity(1);
					} else {
						product.setQuantity(product.getQuantity() - 1);
					}
				}
			}
		}
		session.setAttribute("listProd", products);
	}
}
