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
				<p class="log">
					<a href="account.html">Login</a> <span>or</span><a
						href="account.html">Signup</a>
				</p>
				<div class="cart box_1">
					<a href="checkout.html">
						<h3>
							<div class="total">
								<span class="simpleCart_total"></span>
							</div>
							<img src="images/cart.png" alt="" />
						</h3>
					</a>
					<p>
						<a href="javascript:;" class="simpleCart_empty">Empty Cart</a>
					</p>

				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="container">
		<div class="head-top">
			<div class="col-sm-2 number"></div>
			<div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
					<li class=" grid"><a href="index.jsp">Home</a></li>
					<li><a href="#">Danh mục</a>
						<div class="mepanel" style="width: 60%">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<h4>
											<a href="#">Popular Brands</a>
										</h4>
										<h4>
											<a href="#">Popular Brands</a>
										</h4>
										<h4>
											<a href="#">Popular Brands</a>
										</h4>
									</div>
								</div>
							</div>
						</div></li>

					<li><a href="typo.html">Tin Tức</a></li>
					<li><a class="color6" href="contact.html">Liên hệ</a></li>
				</ul>
			</div>
			<div class="col-sm-2 search">
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
<div class="banner">
	<div class="col-sm-3 banner-mat">
		<img class="img-responsive" src="images/ba1.jpg" alt="">
	</div>
	<div class="col-sm-6 matter-banner">
		<div class="slider">
			<div class="callbacks_container">
				<ul class="rslides" id="slider">
					<li><img src="images/1.jpg" alt=""></li>
					<li><img src="images/2.jpg" alt=""></li>
					<li><img src="images/1.jpg" alt=""></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-sm-3 banner-mat">
		<img class="img-responsive" src="images/ba.jpg" alt="">
	</div>
	<div class="clearfix"></div>
</div>