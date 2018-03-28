<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="brand clearfix">
	<a href="/admin/indexAdnmin.jsp" class="logo"><img src="/images/logo.png"
		class="img-responsive" alt=""></a> <span class="menu-btn"><i
		class="fa fa-bars"></i></span>
	<ul class="ts-profile-nav">
		<%
			User userAdmin = (User) session.getAttribute("userAdmin");
		%>

		<li class="ts-account"><a href="#"><img
				src="admin/img/ts-avatar.jpg" class="ts-avatar hidden-side" alt="">
				<%=userAdmin.getNameCustomer()%> <i
				class="fa fa-angle-down hidden-side"></i></a>
			<ul>
				<li><a href="LoggoutServlet">Đăng xuất</a></li>
			</ul></li>
	</ul>
</div>
<div class="ts-main-content">
	<nav class="ts-sidebar">
		<ul class="ts-sidebar-menu">
			<li class="ts-label">Tìm kiếm</li>
			<li><input type="text" class="ts-sidebar-search"
				placeholder="Nhập từ khóa..."></li>
			<li class="ts-label">Danh Mục</li>
			<li class="open"><a href="index.html"><i
					class="fa fa-dashboard"></i>Thống Kê</a></li>
			<li><a href="product.html"><i class="fa fa-database"></i>Sản
					Phẩm</a></li>
			<li><a href="order.html"><i class="fa fa-pencil-square-o"></i>Đơn
					Hàng</a></li>
			<li><a href="customer.html"><i class="fa fa-users"></i>Khách
					Hàng</a></li>


		</ul>
	</nav>