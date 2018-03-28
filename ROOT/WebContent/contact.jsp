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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

</head>
<body>
	<!--header-->
	<%@include file="header.jsp"%>
	<!--content-->
	<!-- banner -->
	<%@include file="banner.jsp"%>
	<div class="contact">
		<div class="container">
			<h1>Liên hệ</h1>

			<div class="contact-grids">
				<div class="contact-form"></div>
				<div class="address">
					<div class=" address-more">
						<div class="col-md-4 address-grid">
							<a href="https://www.facebook.com/tranlevihandshop"><i style="font-size: 70px" class="fa">&#xf230;</i></a>
							<div class="address1">
								<p>Trần Lê Vi Handshop</p>
								<p>Mộ Đức, Quảng Ngãi</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-4 address-grid ">
							<i class="glyphicon glyphicon-phone"></i>
							<div class="address1">
								<p>+885699655</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-4 address-grid ">
							<i class="glyphicon glyphicon-envelope"></i>
							<div class="address1">
								<p>
									<a href="mailto:@example.com"> @example.com</a>
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
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
