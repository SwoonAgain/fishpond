<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Signin</title>
<link rel="stylesheet" href="/fishPond/resource/css/common.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container fh">
  <form class="form-signin" action="admin/view_all.do" method="get">
    <h1 class="form-signin-heading">智能鱼塘管理平台</h1>
    <label for="inputEmail" class="sr-only">账  号</label>
    <input type="text" id="inputEmail" class="form-control" placeholder="账  号" required autofocus>
    <label for="inputPassword" class="sr-only">密  码</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="密  码" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">登  录</button>
    <div id="form-bg"></div>
  </form>
</div>
<!-- /container -->

<div class="bg fh"> </div>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script> 
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>