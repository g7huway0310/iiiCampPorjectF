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
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 3 | DataTables</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="${path}/AdminLTE-3.0.5/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${path}/AdminLTE-3.0.5/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="${path}/AdminLTE-3.0.5/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${path}/AdminLTE-3.0.5/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <style>
  #button{
  position: fixed;
  left:1615px;
  top:132px;
  background-color: #e7e7e7; color: black;
  width: 170px;
  margin-right:10px;
  }
  </style>
</head>

<jsp:include page="TopwithLeftNav.jsp" />

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
      </div><!-- /.container-fluid -->
    </section>
    
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">DataTable with default features</h3>
                <button class="btn" id="button">搜尋</button>
              </div>
              <!-- /.card-header -->
               
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>id</th>
                    <th>食譜名稱</th>
                    <th>食譜簡述</th>
                    <th>份量/預估製作時間</th>
                    <th>商品價格</th>
                    <th>庫存</th>
                    <th>相片</th>
                    <th>操作</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach var='recipe' items='${recipe}'>
                  <tr>
                    <td><a href="<c:url value='/RecipeContentServlet?reid=${recipe.reid}'/>">${recipe.reid}</a></td>
                    <td>${recipe.rename}</td>
                    <td>${recipe.brief}</td>
                    <td>${recipe.people}人份/<br/>${recipe.time}分鐘</td>
                    <td>${recipe.price}元</td>
                    <td>${recipe.stock}</td>
                    <td><img src="${recipe.image}" width="100" Height="100" /></td>
                    <td style="justify-content:space-between" align="center">
                    <a href="<c:url value='/RecipeServletForUser.do?cmd=modify&reid=${recipe.reid}'/>" class="btn btn-info"><i class="fas fa-edit"></i></a>
                    <a onclick="confirmDelete(${recipe.reid})" class="btn btn-danger"><i class="fas fa-trash"></i></a>                   
                    </td>
                  </tr>
                  </c:forEach>                
                  </tbody>
                  <tfoot>
                  <tr>
                    <th>Rendering engine</th>
                    <th>Browser</th>
                    <th>Platform(s)</th>
                    <th>Engine version</th>
                    <th>CSS grade</th>
                    <th></th>
                    <th></th>
                    <th></th>
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div>s
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->


  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->

<!-- ./wrapper -->

<!-- jQuery -->
<script src="${path}/AdminLTE-3.0.5/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${path}/AdminLTE-3.0.5/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="${path}/AdminLTE-3.0.5/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${path}/AdminLTE-3.0.5/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="${path}/AdminLTE-3.0.5/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="${path}/AdminLTE-3.0.5/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<!-- AdminLTE for demo purposes -->
<script src="${path}/AdminLTE-3.0.5/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true,
      "autoWidth": false,
    });
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });

  function confirmDelete(n) {
		if (confirm("確定刪除此項食譜 ? ") ) {
			document.forms[0].action="<c:url value='/RecipeServletForUser.do?cmd=DEL&reid=" + n +"' />" ;
			document.forms[0].method="POST";
			document.forms[0].submit();
		} else {
			return;
		}
	}

	
</script>
</body>
</html>
