<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入jstl -->
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>eating列表</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<!-- 页面显示部分-->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>eating列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>吃饭花销</th>
                        <th>公司</th>
                        <th>人数</th>
                        <th>吃饭时间</th>
                        <th>创建时间</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="eat" items="${list}">
                        <tr>
                            <td>${eat.money}</td>
                            <td>${eat.company}</td>
                            <td>${eat.personNum}</td>
                            <td>
                                <fmt:formatDate value="${eat.eatingDate}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                            <td>
                                <fmt:formatDate value="${eat.ts}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                            <td>
                                <a class="btn btn-info" href="/seckill/${sk.seckillId}/detail" target="_blank">link</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</html>
