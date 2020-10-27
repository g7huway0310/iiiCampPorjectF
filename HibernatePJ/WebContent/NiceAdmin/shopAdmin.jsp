<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
<link rel="shortcut icon" href="img/favicon.png">

<title>Creative - Bootstrap Admin Template</title>
<!-- Bootstrap CSS -->
<link href="${path}/NiceAdmin/css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="${path}/NiceAdmin/css/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="${path}/NiceAdmin/css/elegant-icons-style.css"
	rel="stylesheet" />
<link href="${path}/NiceAdmin/css/font-awesome.min.css" rel="stylesheet" />
<!-- full calendar css-->
<link
	href="${path}/NiceAdmin/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css"
	rel="stylesheet" />
<link
	href="${path}/NiceAdmin/assets/fullcalendar/fullcalendar/fullcalendar.css"
	rel="stylesheet" />
<!-- easy pie chart-->
<link
	href="${path}/NiceAdmin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- owl carousel -->
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
<link href="${path}/NiceAdmin/css/jquery-jvectormap-1.2.2.css"
	rel="stylesheet">
<!-- Custom styles -->
<link rel="stylesheet" href="css/fullcalendar.css">
<link href="${path}/NiceAdmin/css/widgets.css" rel="stylesheet">
<link href="${path}/NiceAdmin/css/style.css" rel="stylesheet">
<link href="${path}/NiceAdmin/css/style-responsive.css" rel="stylesheet" />
<link href="${path}/NiceAdmin/css/xcharts.min.css" rel=" stylesheet">
<link href="${path}/NiceAdmin/css/jquery-ui-1.10.4.min.css"
	rel="stylesheet">
<!-- =======================================================
    Theme Name: NiceAdmin
    Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
  ======================================================= -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="sideBar.html" flush="true" />
<body>
	<!-- container section start -->
	<section id="container" class="">
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading">
								Advanced Table 
								<nav class="navbar navbar-light bg-light">
									<div>
										<form class="form-inline">
											<div class="form-group mb-2"></div>
											<div class="col-sm-3 my-1">
												<label class="sr-only" for="inlineFormInputName">search</label>
												<input type="text" class="form-control"
													id="inlineFormInputName" placeholder="keyword">
											</div>

											<button type="submit" class="btn btn-primary mb-2">
												search</button>
										</form>
									</div>
								</nav>
							</header>
							<table class="table table-striped table-advance table-hover">
								<tbody>
									<tr>
										<th><i class="icon_profile"></i> id</th>
										<th><i class="icon_calendar"></i> 商品名稱</th>
										<th><i class="icon_mail_alt"></i> 商品價格</th>
										<th><i class="icon_pin_alt"></i> 商品庫存</th>
										<th><i class="icon_mobile"></i> 瀏覽次數</th>
										<th><i class="icon_cogs"></i> 操作</th>
									</tr>
									<c:forEach items='${listAll}' var="p">
									<tr>
										<td>${p.productId}</td>
										<td>${p.productName}</td>
										<td>${p.productPrice}</td>
										<td>${p.productStock}</td>
										<td>${p.click}</td>
										<td>
											<div class="btn-group">
												<a class="btn btn-primary" href="../../HibernatePJ/AdminProductServlet?action=add&pageno=${i}&id=${p.productId}"><i
													class="icon_plus_alt2"></i></a> <a class="btn btn-success"
													href="#"><i class="icon_check_alt2"></i></a> <a
													class="btn btn-danger" href="#"><i
													class="icon_close_alt2"></i></a>
											</div>
										</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</section>
						
					</div>
				</div>
				<!-- page end-->
				<c:forEach var="i" begin="0" end="${totalPage}" varStatus="loop">
                <a href="../../HibernatePJ/AdminProductServlet?action=list&pageno=${i}">第${i+1}頁</a>
                </c:forEach>
				
			</section>
		</section>
		<!--main content end-->
		<div class="text-right">
			<div class="credits">
				<!--
            All the links in the footer should remain intact.
            You can delete the links only if you purchased the pro version.
            Licensing information: https://bootstrapmade.com/license/
            Purchase the pro version form: https://bootstrapmade.com/buy/?theme=NiceAdmin
          -->
				Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
			</div>
		</div>
	</section>
	<!-- container section end -->
	<!-- javascripts -->
	<script src="${path}/NiceAdmin/js/jquery.js"></script>
	<script src="${path}/NiceAdmin/js/bootstrap.min.js"></script>
	<!-- nicescroll -->
	<script src="${path}/NiceAdmin/js/jquery.scrollTo.min.js"></script>
	<script src="${path}/NiceAdmin/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<!--custome script for all page-->
	<script src="${path}/NiceAdmin/js/scripts.js"></script>

</body>
</html>