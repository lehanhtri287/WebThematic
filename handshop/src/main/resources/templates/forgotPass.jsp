<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Quên mật khẩu</title>
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
	<%
		String email = (String) request.getAttribute("email");

		if (email == null) {
			email = "";
		}

		String errEmail = (String) request.getAttribute("errEmail");
		String errPass = (String) request.getAttribute("errPass");

		if (errEmail == null) {
			errEmail = "";
		}
		if (errPass == null) {
			errPass = "";
		}
	%>
	<div class="account">
		<div class="container">
			<h1>Quên mật khẩu</h1>
			<div class="account_grid">
				<div class="col-md-12 login-right">
					<form action="LoginServlet" method="POST">
						<table class="tLogin" align="center">
							<tr>
								<td colspan="2">
									<span class="myLabel">Email</span>
									<input type="text" name="email" value="<%=email%>">
								</td>
							</tr>
							<tr>
								<td><input type="submit" class="forgotPassSubmit" value="Tiếp tục"></td>
							</tr>
							<tr>
								<td><a class="accountLink" href="login.jsp">Đăng nhập</a></td>
								<td><a class="accountLink" href="signUp.jsp">Chưa có tài khoản?</a></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<!--//content-->
	<!--footer-->
	<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>