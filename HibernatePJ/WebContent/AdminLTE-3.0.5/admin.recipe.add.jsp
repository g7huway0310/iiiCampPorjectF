<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>分享食譜</title>
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
            <h1>食譜分享</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">食譜分享</li>
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
              <h3 class="card-title">食譜內容</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fas fa-minus"></i></button>
              </div>
            <form action="<c:url value="/RecipeServletForUser.do"/>" method="post">
            </div>
            <div class="card-body">
              <div class="form-group">
                <label for="inputName">食譜名稱</label>
                <input type="text" name="rename" class="form-control">
              </div>
              <div class="form-group">
                <label for="image">圖片上傳</label>
                <input type="text" name="img" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputDescription">食譜簡介</label>
                <textarea name="brief" class="form-control" rows="4"></textarea>
              </div>
              <div class="form-group">
                <label for="ingredients">食材</label>
                <textarea name="ingredients" class="form-control" rows="5"></textarea>
              </div>
              <div class="form-group">
                <label for="inputAmount">份量(幾人份)</label>
                <select class="form-control custom-select" name="people">
                  <option selected disabled>幾人份</option>
                  <option>1</option>
                  <option>2</option>
                  <option>3</option>
                  <option>4</option>
                  <option>5</option>
                  <option>6</option>
                  <option>7</option>
                  <option>8</option>
                  <option>9</option>
                  <option>10</option>
                </select>
              </div>
              <div class="form-group">
                <label for="inpuTime">預估製作時間</label>
                <input type="text" name="time" class="form-control" size="5">/分鐘
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <div class="col-md-6">
          <div class="card card-secondary">
            <div class="card-header">
              <h3 class="card-title">製作步驟</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                  <i class="fas fa-minus"></i></button>
              </div>
            </div>
            <div class="card-body">
              <div class="form-group">
                <label for="tip">步驟一</label>
                <textarea name="tip1" class="form-control" rows="3" placeholder="請輸入步驟"></textarea>
              </div>
              <div class="form-group">
                <label for="tip">步驟二</label>
                <textarea name="tip2" class="form-control" rows="3" placeholder="請輸入步驟"></textarea>
              </div>
              <div class="form-group">
                <label for="tip">步驟三</label>
                <textarea name="tip3" class="form-control" rows="3" placeholder="請輸入步驟"></textarea>
              </div>
              <div class="form-group">
                <label for="tip">步驟四</label>
                <textarea name="tip4" class="form-control" rows="3" placeholder="請輸入步驟"></textarea>
              </div>
              <div class="form-group">
                <label for="tip">步驟五</label>
                <textarea name="tip5" class="form-control" rows="3" placeholder="請輸入步驟"></textarea>
              </div>
              <div class="form-group">
                <label for="tip">步驟六</label>
                <textarea name="tip6" class="form-control" rows="3" placeholder="請輸入步驟"></textarea>
              </div>
              <div class="form-group">
                <label for="tip">備註</label>
                <textarea name="note" class="form-control" rows="3" placeholder="請輸入備註"></textarea>
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
      </div>
      <div class="row">
        <div class="col-12">
          <a href="<c:url value="/RecipeServletForUser.do"/>" class="btn btn-secondary">取消</a>
          <input type="submit" value="分享食譜" name="createRecipe" class="btn btn-success float-right">
          </form>
        </div>
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