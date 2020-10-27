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
  
 <script type="text/javascript">
function setFocus()
{
     document.getElementById("id").focus();
     document.getElementById("city").focus();
}


function confirmDelete(n) {
	if (confirm("確定刪除此項露營地資料? ") ) {
		document.forms[0].action="DemoCampgroundServlet?cmd=DEL&id="+n;
		document.forms[0].method="POST";
		document.forms[0].submit();
	} 
}
function confirmupdate(a) {
    document.forms[0].action="DemoCampgroundServlet?cmd=Update&id1="+a;
	document.forms[0].method="POST";
	document.forms[0].submit();
}

function confirmselect(c) {
    document.forms[0].action="DemoCampgroundServlet?cmd=Select&city="+c;
	document.forms[0].method="POST";
	document.forms[0].submit();
}
</script>
</head>

<jsp:include page="TopwithLeftNav.jsp" />
<body class="hold-transition sidebar-mini" onload="setFocus()">
    <form action=".\DemoCampgroundServlet" method="post">
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
              <li class="breadcrumb-item"><a href="<c:url value='/DemoCampgroundServlet'/>">Home</a></li>
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
                <h3 class="card-title">查詢營區資料</h3>
                <select Name="city" id="cityselect">
                <option selected disabled>Select one</option>
                <option NAME="city" value="台中市">台中市</option>
                <option NAME="city" value="台北市">台北市</option>
                <option NAME="city" value="台南市">台南市</option>
                <option NAME="city" value="宜蘭縣">宜蘭縣</option>
                <option NAME="city" value="南投縣">南投縣</option>
                <option NAME="city" value="屏東縣">屏東縣</option>
                <option NAME="city" value="苗栗市">苗栗市</option>
                <option NAME="city" value="苗栗縣">苗栗縣</option>
                <option NAME="city" value="桃園市">桃園市</option>
                <option NAME="city" value="高雄市">高雄市</option>
                <option NAME="city" value="雲林縣">雲林縣</option>
                <option NAME="city" value="新北市">新北市</option>
                <option NAME="city" value="新竹縣">新竹縣</option>
                <option NAME="city" value="嘉義縣">嘉義縣</option>
                <input type="submit" name="submitshow" value="送出" onclick="confirmselect(${':selected'}.value)">         
                </select>
              </div>
              <!-- /.card-header -->
               
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>編號</th>
                    <th>露營地</th>
                    <th>城市</th>
                    <th>地址</th>
                    <th>電話</th>
                    <th>平日價格</th>
                     <th>假日價格</th>
                    <th>帳篷數量</th>
                    <th>海拔</th>
                    <th>營區特色</th>
                    <th>附屬設施</th>
                    <th>攜帶寵物</th>
                     <th>附屬服務</th>
                    <th>停車方式</th>
                  </tr>
                  </thead>
                  <c:forEach var="acamp" items="${bean}" varStatus="stat">
                  <tbody>
                  <tr>
						<td>${acamp.id}</td>
						<td>${acamp.name}</td>
						<td>${acamp.city}</td>
						<td>${acamp.adress}</td>
						<td>${acamp.tel}</td>
						<td>${acamp.oprice}</td>
						<td>${acamp.wprice}</td>
						<td>${acamp.tentnum}</td>
						<td>${acamp.elevation}</td>
						<td>${acamp.feature}</td>
						<td>${acamp.facility}</td>
						<td>${acamp.pet}</td>
						<td>${acamp.service}</td>
						<td>${acamp.parking}</td>  
                    <td style="justify-content:space-between" align="center">
                    <a href="#" class="btn btn-info" onclick="confirmupdate('${acamp.id}')"><i class="fas fa-edit"></i></a>
                        <a href="#" class="btn btn-danger" onclick="confirmDelete('${acamp.id}')"><i class="fas fa-trash"></i></a>                   
                    </td>
                  </tr>
                  </tbody>
                   </c:forEach>

                  <tfoot>
                  <tr>
                    <th>Rendering engine</th>
                    <th>Browser</th>
                    <th>Platform(s)</th>
                    <th>Engine version</th>
                    <th>CSS grade</th>
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
</script>
</form>
</body>
</html>
