<%@page import="DAO.CommentDAO"%>
<%@page import="model.Comment"%>
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
	<!-- banner -->
	<!-- banner <%@include file="banner.jsp"%>-->
	<div class="single">

		<%
			Product product = (Product) session.getAttribute("single");
		%>
		<div class="container">
			<div class="col-md-9">
				<div class="col-md-5 grid">
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb="<%=product.getImage()%>">
								<div class="thumb-image">
									<img src="<%=product.getImage()%>" data-imagezoom="true"
										class="img-responsive" style="height: 400px">
								</div>
							</li>
						</ul>
					</div>
				</div>

				<div class="col-md-7 single-top-in">
					<div class="single-para simpleCart_shelfItem">
						<h1><%=product.getNameProduct()%></h1>
						<p><%=product.getDescription()%>
						</p>
						<div class="star-on">
							<div class="review">
								<a> <%=CommentDAO.countCmt(product.getIdProduct())%> nhận
									xét
								</a>
							</div>
							<div class="clearfix"></div>
						</div>

						<label class="add-to item_price"><%=String.format("%,d", product.getPrice())%>đ</label>
						<a href="ShoppingCart?action=addProdToCart&id=<%=product.getIdProduct()%>" class="cart item_add">Thêm vào giỏ</a>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="content-top1">
					<div>
						<ul class="nav nav-tabs" style="width: 80%">
							<li role="presentation" class="active"><a href="">Comment
							</a></li>
							</li>
						</ul>
					</div>
					<%
						List<Comment> comments = CommentDAO.getComment(product.getIdProduct());
						String email = "", name = "";
						if (userLogged != null) {
							email = userLogged.getUserName();
							name = userLogged.getNameCustomer();
						}
						if (userLogged == null) {
							email = "";
							name = "";
						}
						String errCmt = (String) request.getAttribute("errCmt");
						if (errCmt == null) {
							errCmt = "";
						}
					%>
					<div class="bootstrap-tab-text-grid-right">
						<%
							for (Comment comment : comments) {
						%>
						<div class="alert alert-info" role="alert">
							<b><%=comment.getNameCustomer()%> (<%=comment.getTimeCmt()%>):
							</b>
							<%=comment.getContext()%>
						</div>
						<%
							}
						%>

					</div>
					<div class="formaction">
						<form action="CommentAction" method="POST">
							<input type="text" class="form-control" placeholder="Tên họ"
								style="width: 60%" name="name" value="<%=name%>"
								readonly="readonly"><label style="color: red;"><%=errCmt%></label>
							<input type="email" value="<%=email%>" class="form-control"
								style="width: 60%" placeholder="Email" name="email"
								readonly="readonly"><label style="color: red;"></label>
							<textarea type="text" class="form-control" placeholder="Nội dung"
								style="width: 60%" name="context"></textarea>
							<input type="submit" value="Gửi" class="btn btn-success"
								role="button">
						</form>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!----->
			<div class="col-md-3 product-bottom">
				<!--categories-->
				<div class=" rsidebar span_1_of_left">
					<h3 class="cate">Danh mục</h3>
					<ul class="menu-drop">
						<%
							List<Category> categories2 = CategoryDAO.getAllCategory();
							for (Category category : categories2) {
						%>
						<li class="item1"><a
							href="ViewProductByCate?action=viewProd&id=<%=category.getIdCategory()%>"><%=category.getNameCategory()%>
						</a></li>
						<%
							}
						%>
					</ul>
				</div>
				<!--initiate accordion-->
				<script type="text/javascript">
					$(function() {
						var menu_ul = $('.menu-drop > li > ul'), menu_a = $('.menu-drop > li > a');
						menu_ul.hide();
						menu_a.click(function(e) {
							e.preventDefault();
							if (!$(this).hasClass('active')) {
								menu_a.removeClass('active');
								menu_ul.filter(':visible').slideUp('normal');
								$(this).addClass('active').next().stop(true,
										true).slideDown('normal');
							} else {
								$(this).removeClass('active');
								$(this).next().stop(true, true).slideUp(
										'normal');
							}
						});

					});
				</script>
				<!--//menu-->
				<!--seller-->
				<div class="product-bottom">
					<h3 class="cate">Sản phẩm bán chạy</h3>
					<%
						List<Product> listProducts = ProductDAO.getProductLikeMost();
						for (Product product2 : listProducts) {
					%>
					<div class="product-go">
						<div class=" fashion-grid">
							<a
								href="ViewProductByCate?action=getAProduct&id=<%=product2.getIdProduct()%>"><img
								class="img-responsive " src="<%=product2.getImage()%>" alt=""></a>
						</div>
						<div class=" fashion-grid1">
							<h6 class="best2">
								<a href="ViewProductByCate?action=getAProduct&id=<%=product.getIdProduct()%>"><%=product2.getNameProduct()%> </a>
							</h6>
							<span class=" price-in1"><%=String.format("%,d", product.getPrice())%>đ</span>
						</div>
						<div class="clearfix"></div>
					</div>
					<%
						}
					%>
				</div>

				<!--//seller-->
				<!--tag-->
				<div class="tag">
					<h3 class="cate">Tags</h3>
					<div class="tags">
						<ul>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">dress</a></li>
							<li><a href="#">design</a></li>
							<li><a href="#">fashion</a></li>
							<li><a href="#">lorem</a></li>
							<li><a href="#">dress</a></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<!--//content-->
	<!--footer-->
	<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>