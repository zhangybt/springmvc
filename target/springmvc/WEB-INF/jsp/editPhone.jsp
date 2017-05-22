<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>手机修改页面</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form">
        <fieldset>
            <legend>手机基本信息</legend>
            <div class="form-group">
                <label for="select" class="col-sm-2 control-label">手机品牌</label>
                <div class="col-sm-4">
                    <select id="select" class="form-control">
                        <option>苹果</option>
                        <option>华为</option>
                        <option>小米</option>
                        <option>锤子</option>
                        <option>三星</option>
                        <option>oppo</option>
                    </select>
                </div>
                <%--<label class="col-sm-2 control-label" for="ph_brand">手机品牌</label>--%>
                <%--<div class="col-sm-4">--%>
                    <%--<input class="form-control" id="ph_brand" type="text" placeholder="请输入手机品牌"/>--%>
                <%--</div>--%>
                <label class="col-sm-2 control-label" for="ph_name">手机名称</label>
                <div class="col-sm-4">
                    <input class="form-control" id="ph_name" type="text" placeholder="请输入手机名称"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="ph_price">手机价格</label>
                <div class="col-sm-4">
                    <input class="form-control" id="ph_price" type="text" placeholder="请输入手机价格"/>
                </div>
                <label class="col-sm-2 control-label" for="ph_type">手机型号</label>
                <div class="col-sm-4">
                    <input class="form-control" id="ph_type" type="text" placeholder="请输入手机型号"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="ph_time">上市时间</label>
                <div class="col-sm-4">
                    <input class="form-control" id="ph_time" type="text" placeholder="上市时间"/>
                </div>
                <label class="col-sm-2 control-label" for="ph_color">手机颜色</label>
                <div class="col-sm-4">
                    <input class="form-control" id="ph_color" type="text" placeholder="请输入手机颜色"/>
                </div>
            </div>
        </fieldset>
        <fieldset>
            <legend>选择相关表</legend>
            <div class="form-group">
                <label for="disabledSelect" class="col-sm-2 control-label">表名</label>
                <div class="col-sm-10">
                    <select id="disabledSelect" class="form-control">
                        <option>禁止选择</option>
                        <option>不选择</option>
                    </select>
                </div>
            </div>
        </fieldset>
    </form>
</div>

</body>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
    <%--$(function () {--%>
    <%--//使用EL表达式传入参数--%>
    <%--seckill.detail.init({--%>
    <%--seckillId:${seckill.seckillId},--%>
    <%--startTime:${seckill.startTime.time},//毫秒时间--%>
    <%--endTime:${seckill.endTime.time},--%>
    <%--});--%>
    <%--});--%>
</script>
</html>
