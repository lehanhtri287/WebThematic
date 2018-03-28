<%@page import="DAO.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--content-->
<div class="content">
	<div class="container">
		<div class="content-top">
			<h1>Danh sách sản phẩm</h1>
			<div class="content-top1">
				<%
					List<Product> products = ProductDAO.getAllProduct();
					for (Product product : products) {
				%>

				<div class="col-md-3 col-md2">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html"> <img class="img-responsive"
							src="test/<%=product.getImage()%>" />
						</a>
						<h3>
							<a href="single.html"><%=product.getNameProduct()%></a>
						</h3>
						<div class="price">
							<h5 class="item_price"><%=String.format("%,d", product.getPrice())%>đ
							</h5>
							<a href="#" class="item_add">Add To Cart</a>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<%
					}
				%>

				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//content-->