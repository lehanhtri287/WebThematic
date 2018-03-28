<%@page import="model.Order"%>
<%@page import="DAO.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="DAO.OrderDAO"%>
<%@page import="DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="theme-color" content="#3e454c">
<title>Quản lý bán hàng</title>

<!-- Font awesome -->
<link rel="stylesheet" href="admin/css/font-awesome.min.css">
<!-- Sandstone Bootstrap CSS -->
<link rel="stylesheet" href="admin/css/bootstrap.min.css">
<!-- Bootstrap Datatables -->
<link rel="stylesheet" href="admin/css/dataTables.bootstrap.min.css">
<!-- Bootstrap social button library -->
<link rel="stylesheet" href="admin/css/bootstrap-social.css">
<!-- Bootstrap select -->
<link rel="stylesheet" href="admin/css/bootstrap-select.css">
<!-- Bootstrap file input -->
<link rel="stylesheet" href="admin/css/fileinput.min.css">
<!-- Awesome Bootstrap checkbox -->
<link rel="stylesheet" href="admin/css/awesome-bootstrap-checkbox.css">
<!-- Admin Stye -->
<link rel="stylesheet" href="admin/css/style.css">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- Loading Scripts -->
<script src="admin/js/jquery.min.js"></script>
<script src="admin/js/bootstrap-select.min.js"></script>
<script src="admin/js/bootstrap.min.js"></script>
<script src="admin/js/jquery.dataTables.min.js"></script>
<script src="admin/js/dataTables.bootstrap.min.js"></script>
<script src="admin/js/Chart.min.js"></script>
<script src="admin/js/fileinput.js"></script>
<script src="admin/js/chartData.js"></script>
<script src="admin/js/main.js"></script>
<script src="admin/js/label.js"></script>

</head>
<body>
	<%@include file="template.jsp"%>

	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<h2 class="page-title">Thống kê</h2>
					<div class="row">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-3">
									<div class="panel panel-default">
										<div class="panel-body bk-primary text-light">
											<div class="stat-panel text-center">
												<div class="stat-panel-number h1 "><%=UserDAO.size()%></div>
												<div class="stat-panel-title text-uppercase">Khách
													hàng</div>
											</div>
										</div>
										<a href="customer.html"
											class="block-anchor panel-footer text-center">Xem chi
											tiết <i class="fa fa-arrow-right"></i>
										</a>
									</div>
								</div>

								<div class="col-md-3">
									<div class="panel panel-default">
										<div class="panel-body bk-info text-light">
											<div class="stat-panel text-center">
												<div class="stat-panel-number h1 "><%=OrderDAO.size()%></div>
												<div class="stat-panel-title text-uppercase">Đơn hàng</div>
											</div>
										</div>
										<a href="order.html"
											class="block-anchor panel-footer text-center">Xem tất cả
											&nbsp; <i class="fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
								<div class="col-md-3">
									<div class="panel panel-default">
										<div class="panel-body bk-warning text-light">
											<div class="stat-panel text-center">
												<div class="stat-panel-number h1 ">18</div>
												<div class="stat-panel-title text-uppercase">Nhận xét</div>
											</div>
										</div>
										<a href="#" class="block-anchor panel-footer text-center">Xem
											tất cả &nbsp; <i class="fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">Sản phẩm mới</div>
							<div class="panel-body">
								<table class="table table-hover">

									<thead>
										<tr>
											<th>STT</th>
											<th>Mã sản phẩm</th>
											<th>Tên sản phẩm</th>
										</tr>
									</thead>

									<tbody>
										<%
											List<Product> productsNew = ProductDAO.getProductPerPages(1);
											for (int i = 0; i < productsNew.size(); i++) {
										%>
										<tr>
											<th scope="row"><%=i + 1%></th>
											<td><%=productsNew.get(i).getIdProduct()%></td>
											<td><%=productsNew.get(i).getNameProduct()%></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-heading">Đơn hàng gần đây</div>
							<div class="panel-body">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>STT</th>
											<th>Họ Tên</th>
											<th>Email</th>
											<th>Đơn Hàng</th>
										</tr>
									</thead>
									<%
										List<Order> orders;
									%>
									<tbody>
										<tr>
											<th scope="row">1</th>
											<td>Mark</td>
											<td>otto@mail.com</td>
											<td>OID.123</td>
										</tr>
										<tr>
											<th scope="row">2</th>
											<td>Jacob</td>
											<td>thornton@abc.com</td>
											<td>OID.111</td>
										</tr>
										<tr>
											<th scope="row">3</th>
											<td>Larry</td>
											<td>bird@gmail.com</td>
											<td>OID.103</td>
										</tr>
										<tr>
											<th scope="row">4</th>
											<td>An</td>
											<td>an@abc.com</td>
											<td>OID.99</td>
										</tr>
										<tr>
											<th scope="row">5</th>
											<td>Bình</td>
											<td>binh@gmail.com</td>
											<td>OID.90</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>