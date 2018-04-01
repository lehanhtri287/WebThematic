<%@page import="model.User"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="DAO.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="col-sm-4 world"></div>
			<div class="col-sm-4 logo">
				<a href="index.jsp"><img src="images/logo.png" alt=""></a>
			</div>

			<div class="col-sm-4 header-left">
				<%
					User userLogged = (User) session.getAttribute("userLogged");
					if (userLogged == null) {
				%>
				<p class="log">
					<a href="account.jsp">Đăng nhập</a>or<a
						href="register.jsp">Đăng ký</a>
				</p>
				<%
					} else {
				%>
				<h4>
					Xin chào,
					<%=userLogged.getNameCustomer()%></h4>
				<div class="mepanel" style="width: 30%;">
					<div class="h_nav">
						<a href="LoggoutServlet">Đăng xuất</a>
					</div>
				</div>
				<%
					}
				%>
				<div class="cart box_1">
					<a href="checkout.html">
						<h3>
							<div class="total">
								<span class="simpleCart_total"></span>
							</div>
							<a href="ShoppingCart?action=viewCart"><img
								src="images/cart.png" alt="" /></a>
						</h3>
					</a>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="container menu">
		<div class="head-top">
			<div class="col-sm-2 number"></div>
			<div class="col-sm-7 h_menu4">
				<ul class="memenu skyblue">
					<li class=" grid"><a href="index.jsp">Home</a></li>
					<li><a href="#">Danh mục</a>
						<div class="mepanel" style="width: 30%; margin-left: 15%;">
							<div class="h_nav">
								<%
									List<Category> categories = CategoryDAO.getAllCategory();
									for (Category category : categories) {
								%>
									<a href="ViewProductByCate?action=viewProd&id=<%=category.getIdCategory()%>">
										<h4><%=category.getNameCategory()%></h4>
									</a>
								<%
									}
								%>
							</div>
						</div></li>

					<li><a href="typo.html">Tin Tức</a></li>
					<li><a class="color6" href="contact.jsp">Liên hệ</a></li>
				</ul>
			</div>
			<div class="col-sm-3 search">
				<!-- <a class="play-icon popup-with-zoom-anim" href="#small-dialog"><i
						class="glyphicon glyphicon-search"> </i> </a> -->
				<form action="SearchProduct" method="POST">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Tìm kiếm"
							name="search">
					</div>
				</form>
			</div>
			<div class="clearfix"></div>
			<!---pop-up-box---->
			<script type="text/javascript" src="js/modernizr.custom.min.js"></script>
			<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
				media="all" />
			<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
			<!---//pop-up-box---->
			<div id="small-dialog" class="mfp-hide">
				<div class="search-top">
					<div class="login">
						<input type="submit" value=""> <input type="text"
							value="Type something..." onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '';}">
					</div>
					<p>Shopping</p>
				</div>
			</div>
			<script>
				$(document).ready(function() {
					$('.popup-with-zoom-anim').magnificPopup({
						type : 'inline',
						fixedContentPos : false,
						fixedBgPos : true,
						overflowY : 'auto',
						closeBtnInside : true,
						preloader : false,
						midClick : true,
						removalDelay : 300,
						mainClass : 'my-mfp-zoom-in'
					});

				});
			</script>
			<!---->
		</div>
	</div>
</div>
<!--banner-->
