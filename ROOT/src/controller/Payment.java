package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderDAO;
import mailEngine.EmailPrototype;
import mailEngine.MailSenda;
import model.Order;
import model.OrderDetail;
import model.Product;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		int total = (int) session.getAttribute("sum");

		String listProduct = "";
		String context = "";

		List<Product> products = (List<Product>) session.getAttribute("listProd");

		if (products.size() == 0 || products == null) {
			request.setAttribute("errCart", "Không có hàng trong giỏ");

			request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		} else if (!Validate.checkName(name)) {
			request.setAttribute("errName", "*");
			request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		} else if (address == "") {
			request.setAttribute("errAddress", "*");
			request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		} else if (!Validate.checkEmail(email)) {
			request.setAttribute("errEmail", "*");
			request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		} else if (!Validate.checkPhoneNumber(phone)) {
			request.setAttribute("errPhone", "*");
			request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
		} else {
			Order order = new Order();
			order.setCustomerName(name);
			order.setAddress(address);
			order.setEmail(email);
			order.setPhoneNumber(phone);
			order.setTotalPrice(total);

			OrderDAO.createOrder(order);
			order.setIdOrder(OrderDAO.getIdOrder());
			for (Product product : products) {
				OrderDAO.createOrderDetail(
						new OrderDetail(order.getIdOrder(), product.getIdProduct(), product.getQuantity()));
				listProduct += product.getNameProduct() + "(" + product.getQuantity() + " cái), ";
			}
			session.setAttribute("listProd", null);
			session.setAttribute("idOrder", order.getIdOrder());

			context = EmailPrototype.HEADER_OF_LETTER + listProduct + EmailPrototype.FOOTER_OF_LETTER;

			MailSenda.sendEmail(email, EmailPrototype.SUBJECT, context);

			response.sendRedirect("success.jsp");
		}
	}

}
