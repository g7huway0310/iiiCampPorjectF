<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>修改食譜</title>
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
            <h1>修改食譜</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">修改食譜</li>
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
            </div>
            <form action="./RecipeServletForUser.do" method="post">
            <c:forEach var="recipe" items="${recipe}"> 
            <div class="card-body">
            <div class="form-group">
                <input type="hidden" id="reid" name="reid" value="${recipe.reid}" blocked class="form-control">
              </div>
              <div class="form-group">
                <label for="inputName">食譜名稱</label>
                <input type="text" id="rename" name="rename" value="${recipe.rename}" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputName">圖片</label>
                <input type="text" id="image" name="image" value="${recipe.image}" class="form-control">
              </div>
              <div class="form-group">
                <label for="inputDescription">食譜簡介</label>
                <textarea id="brief" class="form-control" name="brief" rows="4">${recipe.brief}</textarea>
              </div>
              <div class="form-group">
                <label for="ingredients">食材</label>
                <textarea id="ingredients" class="form-control" name="ingredient" rows="4">${recipe.ingredient}</textarea>
              </div>
              <div class="form-group">
                <label for="inputAmount">份數</label>
                <select class="form-control custom-select" name="people">
                  <option value="1"
                  ${recipe.people == '1'? 'Selected':'' }>1</option>
                  <option value="2"
                  ${recipe.people == '2'? 'Selected':'' }>2</option>
                  <option value="3"
                  ${recipe.people == '3'? 'Selected':'' }>3</option>
                  <option value="4"
                  ${recipe.people == '4'? 'Selected':'' }>4</option>
                  <option value="5"
                  ${recipe.people == '5'? 'Selected':'' }>5</option>
                  <option value="6"
                  ${recipe.people == '6'? 'Selected':'' }>6</option>
                  <option value="7"
                  ${recipe.people == '7'? 'Selected':'' }>7</option>
                  <option value="8"
                  ${recipe.people == '8'? 'Selected':'' }>8</option>
                  <option value="9"
                  ${recipe.people == '9'? 'Selected':'' }>9</option>
                  <option value="10"
                  ${recipe.people == '10'? 'Selected':'' }>10</option>
                </select>
              </div>
              <div class="form-group">
                <label for="inputClientCompany">預估製作時間</label>
                <input type="text" id="time" name="time" value="${recipe.time}" class="form-control">
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
                <label for="inputEstimatedBudget">步驟一</label>
                <textarea id="inputDescription" class="form-control" name="tip1" rows="3">${recipe.tip1}</textarea>
              </div>
              <div class="form-group">
                <label for="inputEstimatedBudget">步驟二</label>
                <textarea id="inputDescription" class="form-control" name="tip2" rows="3">${recipe.tip2}</textarea>
              </div>
              <div class="form-group">
                <label for="inputEstimatedBudget">步驟三</label>
                <textarea id="inputDescription" class="form-control" name="tip3" rows="3">${recipe.tip3}</textarea>
              </div>
              <div class="form-group">
                <label for="inputEstimatedBudget">步驟四</label>
                <textarea id="inputDescription" class="form-control" name="tip4" rows="3">${recipe.tip4}</textarea>
              </div>
              <div class="form-group">
                <label for="inputEstimatedBudget">步驟五</label>
                <textarea id="inputDescription" class="form-control" name="tip5" rows="3">${recipe.tip5}</textarea>
              </div>
              <div class="form-group">
                <label for="inputEstimatedBudget">步驟六</label>
                <textarea id="inputDescription" class="form-control" name="tip6" rows="3">${recipe.tip6}</textarea>
              </div>
              <div class="form-group">
                <label for="inputEstimatedBudget">備註</label>
                <textarea id="inputDescription" class="form-control" name="note" rows="3">${recipe.note}</textarea>
              </div>
              </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
      </div></c:forEach>
      <div class="row">
        <div class="col-12">
          <a href="<c:url value="/RecipeServletForUser.do"/>" class="btn btn-secondary">取消</a>
          <input type="submit" name="confirmModify" value="確認修改" class="btn btn-success float-right">
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