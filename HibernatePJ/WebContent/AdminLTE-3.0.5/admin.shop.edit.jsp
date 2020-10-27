<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
request.setAttribute("basepath",request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+"/");
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
request.setAttribute("path", basePath);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | Project Add</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="${path}AdminLTE-3.0.5/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="${path}AdminLTE-3.0.5/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<style>
#output {
	width: 300px;
}
</style>
</head>
<body>
	<jsp:include page="BasicLeftTop.html" />
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>添加商品</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Project Add</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-md-10">
					<div class="card card-primary">
						<div class="card-header">
							<h3 class="card-title">General</h3>

							<div class="card-tools">
								<button type="button" class="btn btn-tool"
									data-card-widget="collapse" data-toggle="tooltip"
									title="Collapse">
									<i class="fas fa-minus"></i>
								</button>
							</div>
						</div>
						<div class="card-body">
							<form action="${path}AdminProductServlet?action=saveupload"
								method="POST" enctype="multipart/form-data">

								<input type="hidden" name="id" value="${product.productId}"></input>


								<div class="form-group">
									<label for="inputName">商品名稱</label> <input type="text"
										id="inputName" class="form-control" name="name"
										value='${product.productName}'></input>
								</div>
								<div class="form-group">
									<label for="inputDescription">商品品牌</label> <input type="text"
										id="inputName" class="form-control" name="brand"
										value='${product.productBrand}'></input>
								</div>
								<div class="form-group">
									<label for="inputDescription">商品價格</label> <input type="text"
										id="inputName" class="form-control" name="price"
										value='${product.productPrice}'></input>
								</div>

								<div class="form-group">
									<label for="inputProjectLeader">商品庫存</label> <input type="text"
										id="inputName" class="form-control" name="productStock"
										value='${product.productStock}'></input>

								</div>

								<div class="form-group">
									<label for="exampleFormControlSelect1">Example select</label> <select
										class="form-control" id="catoSelect" name=cato>
										<option value="1"
											${product.categortId == '1' ? 'selected' : ''}>露營帳篷</option>
										<option value="2"
											${product.categortId == '2' ? 'selected' : ''}>天幕客廳帳</option>
										<option value="3"
											${product.categortId == '3' ? 'selected' : ''}>戶外寢具</option>
										<option value="4"
											${product.categortId == '4' ? 'selected' : ''}>地布</option>
										<option value="5"
											${product.categortId == '5' ? 'selected' : ''}>露營傢具</option>
										<option value="6"
											${product.categortId == '6' ? 'selected' : ''}>燈具</option>
										<option value="7"
											${product.categortId == '7' ? 'selected' : ''}>炊具</option>
										<option value="8"
											${product.categortId == '8' ? 'selected' : ''}>餐具</option>
										<option value="9"
											${product.categortId == '9' ? 'selected' : ''}>飲水/保冷</option>
										<option value="10"
											${product.categortId == '10' ? 'selected' : ''}>工具</option>
									</select>
								</div>


								<div class="form-group">
									<label for="productSpec">商品規格</label>
									<textarea class="form-control" id="productSpec" rows="4"
										value='${product.productSpec}' name="productSpec"></textarea>
								</div>
								<div class="form-group">
									<label for="productfeature">商品特色</label>
									<textarea class="form-control" id="productfeature" rows="4"
										value='${product.productfeature}' name="productfeature"></textarea>
								</div>
								<div class="form-group">
									<label for="productWarring">商品警告</label>
									<textarea class="form-control" id="productWarring" rows="6"
										value='${product.productWarring}' name="productWarring"></textarea>
								</div>



								<div class="form-group">


									<label for="inputProjectLeader">商品圖片</label>
									<div id="imagePreview">
										<img id="output" alt="沒有圖片" src="/Images/${product.picpath}"></img>

									</div>
									<input type="file" accept="image/*" onchange="loadFile(event)"
										name="photo"></input>




								</div>
								<div class="col-12">
									<a href="#" class="btn btn-secondary">Cancel</a>
									${product.productId} <input type="submit"
										value="Create new Porject" class="btn btn-success float-right"></input>
								</div>



							</form>

						</div>
						<!-- /.card-body -->
					</div>
					<!-- /.card -->
				</div>
			</div>
			<div class="row"></div>
		</section>
		<!-- /.content -->
	</div>
	<script>
	
	$("#productSpec").val('${product.productSpec}');
	$("#productfeature").val('${product.productfeature}');
	$("#productWarring").val('${product.productWarring}');
	
	var loadFile = function(event) {
		    var output = document.getElementById('output');
		    output.src = URL.createObjectURL(event.target.files[0]);
		    output.onload = function() {
		      URL.revokeObjectURL(output.src) // free memory
		    }
	}
	
	
	
	
	</script>

</body>
</html>