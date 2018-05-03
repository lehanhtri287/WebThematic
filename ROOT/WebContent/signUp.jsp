<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Trần Lê Vi Handshop</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);
        function hideURLbar() {
            window.scrollTo(0, 1);
        }






</script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="js/simpleCart.min.js">
	
</script>
<!-- slide -->
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<style type="text/css">
.col-md-3.col-md2 {
	padding-bottom: 3%;
}
</style>
</head>
<body>
	<!--header-->
	<%@include file="header.jsp"%>
	<!--content-->
	<div class="account">
		<div class="container register">
			<h1>Đăng ký</h1>
			<%
				String errName = (String) request.getAttribute("errName");
				String errAddress = (String) request.getAttribute("errAddress");
				String errEmail = (String) request.getAttribute("errEmail");
				String errPhone = (String) request.getAttribute("errPhone");
				String errPass = (String) request.getAttribute("errPass");
				String errConfirm = (String) request.getAttribute("errComfirm");

				if (errName == null) {
					errName = "";
				}
				if (errAddress == null) {
					errAddress = "";
				}
				if (errEmail == null) {
					errEmail = "";
				}
				if (errPhone == null) {
					errPhone = "";
				}
				if (errPass == null) {
					errPass = "";
				}
				if (errConfirm == null) {
					errConfirm = "";
				}

				String email = (String) request.getAttribute("email");
				String phone = (String) request.getAttribute("phone");
				String name = (String) request.getAttribute("name");
				String address = (String) request.getAttribute("address");
				String password = (String) request.getAttribute("password");
				String confirmPassword = (String) request.getAttribute("confirmPassword");

				if (name == null) {
					name = "";
				}
				if (address == null) {
					address = "";
				}
				if (email == null) {
					email = "";
				}
				if (phone == null) {
					phone = "";
				}
				if (password == null) {
					password = "";
				}
				if (confirmPassword == null) {
					confirmPassword = "";
				}
			%>
			<form action="RegisterServlet" method="POST">
				<div class="col-md-6 register-top-grid">
					<table class="tRegister">
						<tr class="tRegisterTitle"><td>Thông tin tài khoản</td></tr>
						<tr>
							<td>
								<span class="myLabel">Email</span>
								<input type="text" name="email" value="<%=email%>">
							</td>
							<td><label style="color: red;"><%=errEmail%></label></td>
						</tr>
						<tr>
							<td>
								<span class="myLabel">Mật khẩu</span>
								<input type="password"
								name="password" value="<%=password%>"></td>
							<td><label style="color: red;"><%=errPass%></label></td>
						</tr>
						<tr>
							<td>
								<span class="myLabel">Xác nhận mật khẩu</span>
								<input type="password" name="confirmPassword" value="<%=confirmPassword%>">
							</td>
							<td><label style="color: red;"><%=errConfirm%></label></td>
						</tr>
					</table>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-6 register-bottom-grid">
					<table class="tRegister">
						<tr class="tRegisterTitle"><td>Thông tin cá nhân</td></tr>
						<tr>
							<td>
								<span class="myLabel">Họ tên</span>
								<input type="text" name="name" value="<%=name%>">
							</td>
							<td><label style="color: red;"><%=errName%></label></td>
						</tr>
						<tr>
							<td>
								<span class="myLabel">Địa chỉ giao hàng</span>
								<input type="text" name="address" value="<%=address%>">
							</td>
							<td><label style="color: red;"><%=errAddress%></label></td>
						</tr>
						<tr>
							<td>
								<span class="myLabel">Địa chỉ giao hàng</span>
								<input type="text" name="phoneNumbers" value="<%=phone%>">
							</td>
							<td><label style="color: red;"><%=errPhone%></label></td>
						</tr>
					</table>
				</div>
				<div>
					<input type="submit" class="registerSubmit" value="Đăng ký">
					<a class="accountLink loginFromRegister" href="login.jsp">Đăng nhập</a>
				</div>
				<div class="clearfix"></div>
			</form>
		</div>
	</div>

	<!--//content-->
	<!--footer-->
	<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>