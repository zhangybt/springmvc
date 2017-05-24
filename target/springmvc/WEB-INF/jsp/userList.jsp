<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入jstl -->
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>用户界面</title>
    <%@include file="common/head.jsp"%>
</head>
<body>
<!-- 页面显示部分-->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>用户列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>用户名称</th>
                        <th>用户密码</th>
                        <th>用户备注</th>
                        <th>用户生日</th>
                        <th>注册日期</th>
                        <%--<th>用户地址</th>
                        <th>用户公司</th>
                        <th>用户邮件</th>
                        <th>用户手机号</th>
                        <th>用户座机</th>--%>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${list}">
                        <tr>
                            <td>${user.userName}</td>
                            <td>${user.password}</td>
                            <td>${user.description}</td>
                            <td>
                                <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                            <td>
                                <fmt:formatDate value="${user.registerdate}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                            <%--<td>${user.location}</td>
                            <td>${user.company}</td>
                            <td>${user.email}</td>
                            <td>${user.phone}</td>
                            <td>${user.telnum}</td>--%>
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
