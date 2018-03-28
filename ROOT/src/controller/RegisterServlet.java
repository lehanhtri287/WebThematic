package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String url = "";

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNum = request.getParameter("phoneNumbers");

		if (!Validate.checkEmail(email)) {
			request.setAttribute("errEmail", "*");
			sendBack(request, email, password, confirmPassword, name, address, phoneNum);
			url = "register.jsp";
		}
		if (UserDAO.getUser(email).getUserName() != null) {
			request.setAttribute("errEmail", "Đã tồn tại");
			sendBack(request, email, password, confirmPassword, name, address, phoneNum);
			url = "register.jsp";
		}
		if (password == "") {
			request.setAttribute("errPass", "*");
			sendBack(request, email, password, confirmPassword, name, address, phoneNum);
			url = "register.jsp";
		}
		if (confirmPassword == "") {
			request.setAttribute("errConfirm", "*");
			sendBack(request, email, password, confirmPassword, name, address, phoneNum);
			url = "register.jsp";
		}
		if (!Validate.checkName(name)) {
			request.setAttribute("errName", "*");
			sendBack(request, email, password, confirmPassword, name, address, phoneNum);
			url = "register.jsp";
		}
		if (address == "") {
			request.setAttribute("errAddress", "*");
			sendBack(request, email, password, confirmPassword, name, address, phoneNum);
			url = "register.jsp";
		}
		if (!Validate.checkPhoneNumber(phoneNum)) {
			request.setAttribute("errPhone", "*");
			sendBack(request, email, password, confirmPassword, name, address, phoneNum);
			url = "register.jsp";
		}
		if (!confirmPassword.equalsIgnoreCase(password)) {
			request.setAttribute("errConfirm", "*");
			sendBack(request, email, password, confirmPassword, name, address, phoneNum);
			url = "register.jsp";
		}
		if (url == "") {
			boolean tmp = false;
			User user = new User();
			user.setUserName(email);
			user.setNameCustomer(name);
			user.setPassword(password);
			user.setAddress(address);
			user.setPhoneNumbers(phoneNum);

			tmp = UserDAO.createUser(user);
			if (tmp) {
				url = "successRegister.jsp";
			} else {
				url = "register.jsp";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void sendBack(HttpServletRequest request, String email, String password, String confirm, String name,
			String address, String phone) {
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("confirmPassword", confirm);
		request.setAttribute("name", name);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
	}
}
