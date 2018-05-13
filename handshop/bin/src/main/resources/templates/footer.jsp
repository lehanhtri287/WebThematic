<%@page import="DAO.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="model.Category"%>
<%@page import="DAO.CategoryDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="footer">
	<div class="footer-bottom">
		<div class="container">
			<div class="col-sm-4 footer-bottom-cate">
				<h6>Danh mục sản phẩm</h6>
				<ul>
					<%
						List<Category> categories11 = CategoryDAO.getAllCategory();
						for (Category category : categories11) {
					%>
					<li><a
						href="ViewProductByCate?action=viewProd&id=<%=category.getIdCategory()%>"><%=category.getNameCategory()%></a></li>
					<%
						}
					%>
				</ul>
			</div>
			<div class="col-sm-4 footer-bottom-cate">
				<h6>Sản phẩm bán chạy</h6>
				<ul>
					<%
						List<Product> products11 = ProductDAO.getProductLikeMost();
						if (products11 == null) {
					%>
					<div></div>
					<%
						} else {
							for (Product product1 : products11) {
					%>
					<li><a href="#"><%=product1.getNameProduct()%></a></li>
					<%
						}
						}
					%>
				</ul>
			</div>
			<div class="col-sm-4 footer-bottom-cate cate-bottom">
				<h6>Địa chỉ</h6>
				<ul>
					<li>Mộ Đức, Quảng Ngãi</li>
					<li class="phone">LH : 6985792466</li>
				</ul>
			</div>
			<div class="clearfix"></div>
			<p class="footer-class">
				© 2017 Trần Lê Vi Handshop. All Rights Reserved | Design by <a
					href="http://w3layouts.com/" target="_blank">W3layouts</a>
				| Developed by <a href="http://facebook.com/trile28" target="_blank">Trí
					Lê</a>
			</p>
		</div>
	</div>
</div>