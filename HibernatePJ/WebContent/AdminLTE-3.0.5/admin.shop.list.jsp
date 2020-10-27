<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
request.setAttribute("path", basePath);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | DataTables</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="${path}AdminLTE-3.0.5/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${path}AdminLTE-3.0.5/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${path}AdminLTE-3.0.5/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${path}AdminLTE-3.0.5/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<style>

</style>
</head>

<jsp:include page="BasicLeftTop.html" />

<body class="hold-transition sidebar-mini">
	<!-- Main content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>DataTables</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">DataTables</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">DataTable with default features</h3>
							
							</div>
							<!-- /.card-header -->

							<div class="card-body">
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>id</th>
											<th>品牌</th>
											<th>價格</th>
											<th>庫存</th>
											<th>熱門程度</th>
											<th>操作</th>
										</tr>
									</thead>
									
									<tbody id="listdata">

										<c:forEach items='${listAll}' var="p">
											<tr>
												<td><a> <c:out value="${p.productId}"></c:out>
												</a></td>
												<td><c:out value="${p.productName}"></c:out></td>
												<td><c:out value="${p.productPrice}"></c:out></td>
												<td><c:out value="${p.productStock}"></c:out></td>
												<td><c:out value="${p.click}"></c:out></td>
												<td style="justify-content: space-between" align="center"><a
													href="${path}AdminProductServlet?action=edit&id=${p.productId}" class="btn btn-info"><i class="fas fa-edit"></i></a>
													<a href="${path}AdminProductServlet?action=del&id=${p.productId}" class="btn btn-danger"><i
														class="fas fa-trash"></i></a></td>
											</tr>
										</c:forEach>
									</tbody>
									
								</table>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			s
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	
	
	
	
	<table id="example2" class="display"></table>


	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->

	<!-- ./wrapper -->

	<!-- jQuery -->
	<script src="${path}AdminLTE-3.0.5/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="${path}AdminLTE-3.0.5/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- DataTables -->
	<script
		src="${path}AdminLTE-3.0.5/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${path}AdminLTE-3.0.5/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="${path}AdminLTE-3.0.5/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="${path}AdminLTE-3.0.5/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<!-- AdminLTE App -->
	<!-- AdminLTE for demo purposes -->
	<script src="${path}AdminLTE-3.0.5/dist/js/demo.js"></script>
	<!-- page script -->
	<script>
	 var contextPath = "${pageContext.request.contextPath}";
	 $(document).ready(function() {
		    $('#example1').DataTable();
		} );
</script>
</body>
</html>
