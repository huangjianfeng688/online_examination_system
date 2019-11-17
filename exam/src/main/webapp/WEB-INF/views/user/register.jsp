<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2019/9/14
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>百度在线考试平台</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="panel panel-success">
        <div class="panel-heading panel-title text-center">
            <h2>欢迎注册</h2>
        </div>
        <div class="panel-body">
            <form action="/user/register.action" class="form-horizontal">
                <div class="form-group">
                    <label for="" class="col-md-3 text-right">用户名:</label>
                    <div class="col-md-6">
                        <input type="text" name="uname" class="form-control" placeholder="请输入用户名...">
                    </div>
                </div>
                <div class="form-group">
                    <label for="" class="col-md-3 text-right">密码:</label>
                    <div class="col-md-6">
                        <input type="text" name="upwd" class="form-control" placeholder="请输入密码...">
                    </div>
                </div>
                <div class="form-group ">
                    <button type="submit" class="btn btn-success col-lg-offset-3">注册</button>
                    <a href="/user/tologin.action" class="btn btn-info">已有账号</a>
                </div>
            </form>
        </div>
        <div class="panel-footer text-right">
            百度在线考试平台
        </div>
    </div>
</div>

</body>
</html>
