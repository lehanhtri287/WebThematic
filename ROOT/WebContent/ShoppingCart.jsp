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

</style>
</head>
<body>
	<!--header-->
	<%@include file="header.jsp"%>
	<!--content-->
	<div class="row fh5co-post-entry">
		<table class="table table-bordered" border="1" align="center">
			<tr>
				<th>Mã SP</th>
				<th>Tên sản phẩm</th>
				<th>Hình ảnh</th>
				<th>Giá(VNĐ)</th>
				<th>Số lượng</th>

				<th>Thành tiền(VNĐ)</th>
				<th>Thao tác</th>
			</tr>
			<%
				int sum = 0;
				List<Product> productsList = (List<Product>) session.getAttribute("listProd");
				if (productsList.size() == 0 || productsList == null) {
			%>
			<div></div>
			<%
				} else {
					for (Product product : productsList) {
			%>
			<tr>
				<td><%=product.getIdProduct()%></td>
				<td><%=product.getNameProduct()%></td>
				<td><img src="<%=product.getImage()%>" width="80" height="40"></td>
				<td><%=product.getPrice()%></td>

				<td style="width: 80px"><div class="input-group input-group-lg"
						style="width: 80px;">
						<span class="input-group-addon" id="sizing-addon1"><a
							href="ShoppingCart?action=updateCart&behav=plus&id=<%=product.getIdProduct()%>">+</a></span>
						<input type="text" class="form-control"
							aria-describedby="sizing-addon1"
							value="<%=product.getQuantity()%>" name="quantity"
							style="width: 60px; height: 45px;"><span
							class="input-group-addon" id="sizing-addon1"><a
							href="ShoppingCart?action=updateCart&behav=minus&id=<%=product.getIdProduct()%>">-</a></span></span>
					</div></td>
				</div>
				</td>
				<td><%=product.getPrice() * product.getQuantity()%> VNĐ</td>
				<td><a
					href="ShoppingCart?action=deleteCart&id=<%=product.getIdProduct()%>"
					class="btn btn-danger" role="button">Xóa</a></td>

			</tr>
			<%
				sum += product.getPrice() * product.getQuantity();
					}
				}
				session.setAttribute("sum", sum);
			%>

		</table>
		<div class="navbar-right">
			<h3>
				Tổng tiền: <%=sum%>đ
			</h3>
		</div>
		<%
			String email = "", phone = "", name = "", address = "";
			if (userLogged != null) {
				email = userLogged.getUserName();
				phone = userLogged.getPhoneNumbers();
				name = userLogged.getNameCustomer();
				address = userLogged.getAddress();
			}
			if (userLogged == null) {
				email = "";
				phone = "";
				name = "";
				address = "";
			}

			String errName = (String) request.getAttribute("errName");
			String errAddress = (String) request.getAttribute("errAddress");
			String errEmail = (String) request.getAttribute("errEmail");
			String errPhone = (String) request.getAttribute("errPhone");
			String errCart = (String) request.getAttribute("errCart");

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
			if (errCart == null) {
				errCart = "";
			}
		%>
		<div class="navbar-left">
			<h3>Thông tin khách hàng</h3>
			<form action="Payment" method="POST">
				<table class="customerInfo">
					<tr>
						<td><span class="myLabel" style="font-size: 18px;">Tên:</span></td>
						<td class="input"><input type="text" name="name" class="form-control customer-payment" value="<%=name%>"></td>
						<td><label style="color: red;"><%=errName%></label></td>
					</tr>
					<tr>
						<td><span  style="font-size: 18px;">Số điện thoại:</span></td>
						<td class="input"><input type="text" name="phone" class="form-control" value="<%=phone%>"></td>
						<td><label style="color: red;"><%=errPhone%></label></td>
					</tr>
					<tr>
						<td><span class="myLabel" style="font-size: 18px;">Email:</span></td>
						<td class="input"><input type="text" name="email" class="form-control" value="<%=email%>"></td>
						<td><label style="color: red;"><%=errEmail%></label></td>
					</tr>
					<tr>
						<td><span class="myLabel" style="font-size: 18px;">Địa chỉ:</span></td>
						<td class="input"><textarea rows="4" cols="30" name="address"
								class="form-control" value=""><%=address%></textarea></td>
						<td><label style="color: red;"><%=errAddress%></label></td>
					</tr>
				</table>
				<button type="submit" class="btn btn-success btn-submit" id="payment">Thanh toán</button>
				<label style="color: red;"><%=errCart%></label>
			</form>
		</div>
	</div>

	<!--//content-->
	<!--footer-->
	<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>