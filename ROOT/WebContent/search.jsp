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

.img-responsive {
	height: 340px;
}
</style>
</head>
<body>
	<!--header-->
	<%@include file="header.jsp"%>
	<!-- banner -->
	<!-- banner <%@include file="banner.jsp"%>-->
	<!--content-->
	<div class="content">
		<div class="container">
			<div class="content-top">
				<div class="content-top1">

					<%
						List<Product> productSearch = (List<Product>) session.getAttribute("listProductSearched");
						if (productSearch.size() == 0 || productSearch == null) {
					%>
					<h2 style="color: red; margin-left: 35%">Không tìm thấy sản
						phẩm</h2>
					<%
						} else {
							for (Product product : productSearch) {
					%>
					<div class="col-md-3 col-md2">
						<div class="col-md1 simpleCart_shelfItem">
							<a href="single.jsp"> <img class="img-responsive"
								src="<%=product.getImage()%>" />
							</a>
							<h3>
								<a href="single.html"><%=product.getNameProduct()%></a>
							</h3>
							<div class="price">
								<h5 class="item_price"><%=String.format("%,d", product.getPrice())%>đ
								</h5>
								<a href="#" class="item_add">Thêm vào giỏ</a>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<%
						}
						}
					%>

					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--//content-->
	<!--footer-->
	<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>