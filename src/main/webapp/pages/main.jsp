<%--
  Created by IntelliJ IDEA.
  User: yangsong
  Date: 2019/10/14
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="referrer" content="never">
    <!-- 移动端页面不缩放 -->
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

    <title>main</title>


    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/icon.css">
    <script type="text/javascript" src="../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery.easyui.min.js"></script>
    <%--easyui中文插件--%>
    <script type="text/javascript" src="../resources/js/easyui-lang-zh_CN.js"></script>
    <style>
        #log_info{
            background-color: #f4a460;
            height:20px;
            weight:100%;
            text-align: right;
        }
    </style>

</head>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:' ',split:true" style="height:120px;">
        <div id="log_info">用户：${admin.username}&nbsp;&nbsp;&nbsp;&nbsp;<a href="../pages/login.jsp">重新登录</a></div>
        <img src="../resources/images/title.png" style="height: 65px;width:100%">
    </div>
    <input hidden id="admin_username_el" value=${admin.username}>
    <div data-options="region:'west',title:' ',split:true" style="width:300px;">
        <div class="easyui-accordion" data-options="fit:true,border:0">
            <c:forEach items="${menus}" var="firstmenus">
                <c:if test="${firstmenus.level.equals('1')}">
                    <div title="${firstmenus.name}">
                        <ul class="easyui-tree">
                            <c:forEach items="${menus}" var="secondmenus">
                                <c:if test="${secondmenus.parentId==firstmenus.id}">
                                    <li>
                                        <span><a href="#" onclick=addTabs(this)>${secondmenus.name}</a></span>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>
            </c:forEach>

        </div>
    </div>
    <div data-options="region:'center'">
        <!--        选项卡-->
        <div id="tabss" class="easyui-tabs" data-options="fit:true,border:0">
            <div title="欢迎光临">欢迎光临</div>
        </div>
    </div>
</div>

<script>
    var admin_username=$("#admin_username_el").val();


    function addTabs(obj) {
        var url="";
        switch (obj.text) {
            case("车辆信息"):
                url="../pages/listcar.html";
                break;
            case("车主信息"):
                url="../pages/listuser.html";
                break;
            case("电池信息"):
                url="../pages/listbattery.html";
                break;
            case("更换记录"):
                url="../pages/listrecord.html";
                break;
            case("个人信息"):
                url="../pages/selfinfo.html";
                break;
            case("用户角色设置"):
                url="../pages/listadmin.html";
                break;
            case("角色权限设置"):
                url="../pages/listrole.html";
                break;
            case("菜单设置"):
                url="../pages/listmenu.html";
                break;

        }
        var flg = $("#tabss").tabs("exists",obj.text);
        if(flg){
            $("#tabss").tabs("select",obj.text);
        }else{
            $("#tabss").tabs("add",
                {
                    title:obj.text,
                    closable:true,
                    href:url

                });
        }
    }




</script>
</body>
</html>