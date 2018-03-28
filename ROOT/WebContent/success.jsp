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
<script type="text/javascript">
	var time = 5;
	var page = "index.jsp";
	function countDown() {
		time--;
		gett("container").innerHTML = time;
		if (time == 0) {
			window.location = page;
		}
	}
	function gett(id) {
		if (document.getElementById) {
			return document.getElementById(id);
		}
		if (document.all) {
			return document.all.id;
		}
		if (window.opera) {
			return window.opera.id;
		}
	}
	function init() {
		if (gett('container')) {
			setInterval(countDown, 1000);
			gett("container").innerHTML = time;
		} else {
			setTimeout(init, 50);
		}
	}
	document.onload = init();
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
		int idOrder = (int) session.getAttribute("idOrder");
	%>
	<div>
		<h1>
			Đơn hàng của bạn đã đkí thành công với mã ĐH: #<%=idOrder%>, vui
			lòng chờ <span id="container"></span> giây! Hoặc ấn <a
				href="index.jsp">Vào đây</a> để về trang chủ!
		</h1>
	</div>
	<!--//content-->
	<!--footer-->
	<%@include file="footer.jsp"%>
	<!--//footer-->
</body>
</html>