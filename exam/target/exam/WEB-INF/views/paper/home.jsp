<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: samsung
  Date: 2019/9/14
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>百度在线考试平台</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="/bootstrap/js/jquery.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-success">
        <div class="panel-heading panel-title text-center">
            <h1>百度在线考试平台--所有试卷</h1>
        </div>
        <div class="panel-body">

            <form action="/home/search.action" class="form-horizontal form-inline">
                <input type="text" class="form-control" name="keyword" value="${keyword}" placeholder="请输入关键字...">
                <button type="submit" class="btn btn-primary glyphicon glyphicon-search" >搜索试卷</button>
            </form>

            <table class="table table-hover table-bordered table-striped table-condensed">
                <thead>
                    <tr>
                        <td>编号</td>
                        <td>试卷编号</td>
                        <td>试卷名称</td>
                        <td>试卷分数</td>
                        <td>创建时间</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${page.row}" var="item" varStatus="v">
                        <tr>
                        <td>${v.index+1}</td>
                        <td>${item.paperid}</td>
                        <td>${item.papername}</td>
                        <td>${item.remarks}</td>
                        <td>${item.createTime}</td>

                        <td class="col-md-3">
                            <a href="/exam/paper/${item.paperid}.action" class="btn btn-success">我要参加考试</a>
                            <a href="/home/mypaper.action" class="btn btn-info">我的所有试卷</a>
                        </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="6" class="text-center">
                            <ul class="pagination ">
                                <c:forEach begin="1" step="1" end="${page.pageSize}" var="p">
                                    <li><a href="javascript:gotoPage(${p})">${p}</a></li>
                                </c:forEach>
                            </ul>
                        </td>
                    </tr>
                </tbody>

            </table>

        </div>
        <div class="panel-footer text-right">
            百度在线考试平台
        </div>
    </div>
</div>
</body>
<script>

    //实现根据点击相的页码,找到相应的数据信息.
    function gotoPage(page) {
        var keyword = $("[name='keyword']");
        window.location.href="/home/search/"+page+".action?keyword="+keyword
    }


</script>
</html>
