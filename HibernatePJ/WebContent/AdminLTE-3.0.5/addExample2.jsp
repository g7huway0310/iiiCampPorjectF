<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 3 | Project Add</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body>
<jsp:include page="BasicLeftTop.html" />
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
<!--             <h1>Project Add</h1> -->
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Project Add</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-6">
          <div class="card card-primary">
            <div class="card-header">
              <h3 class="card-title">修改會員</h3>

           <!--     <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fas fa-minus"></i></button>
              </div>-->
            </div>
              <form method="post" action="<c:url value='/ActionUpdate.do' />">
             <c:forEach var="searchMB" varStatus="status" items="${list}">
      	
            <div class="card-body">
            <div class="form-group">
                
                <input type="hidden" value='${searchMB.id}'  name="id2" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputName">帳號</label>
                <input type="text" value='${searchMB.account}'  name="account" class="form-control" readonly>
              </div>
              <div class="form-group">
                <label for="inputName">密碼:</label>
                <input type="password" value='${searchMB.password}'  name="password" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputName">姓名:</label>
                <input type="text" value='${searchMB.name}' name="name" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputName">性別:</label>
                <input type="text" value='${searchMB.gender}' name="gender" class="form-control" readonly>
              </div>
              <div class="form-group">
                <label for="inputName">生日:</label>
                <input type="text" value='${searchMB.birthday}'   name="birthday" class="form-control" readonly>
              </div>
              <div class="form-group">
                <label for="inputName">手機 :</label>
                <input type="text" value='${searchMB.mobile}'name="mobile" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputName">地址:</label>
                <input type="text" value='${searchMB.address}' name="address" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputName">email:</label>
                <input type="text" value='${searchMB.email}'  name="email" class="form-control" >
              </div>
              <div class="form-group">
                <label for="inputName">會員別</label>
                <input type="text" value='${searchMB.membertype}' name="membertype" class="form-control" readonly>
              </div>
              
              <div class="col-12">
         
         
          </c:forEach>
          <input type="submit" value="確認" name="confirm" class="btn btn-success float-right">
          </form>

        </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
       
      <div class="row">
<!--         <div class="col-12"> -->
<!--           <a href="#" class="btn btn-secondary">Cancel</a> -->
<!--           <input type="submit" value="Create new Porject" class="btn btn-success float-right"> -->
<!--         </div> -->
      </div>
    </section>
    <!-- /.content -->
  </div>
  
  <script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>

</body>
</html>