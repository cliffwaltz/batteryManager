<%--
  Created by IntelliJ IDEA.
  User: yangsong
  Date: 2019/10/15
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="referrer" content="never">
    <!-- 移动端页面不缩放 -->
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

    <title>login</title>

    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/icon.css">
    <script type="text/javascript" src="../resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../resources/js/jquery.easyui.min.js"></script>
    <%--easyui中文插件--%>
    <script type="text/javascript" src="../resources/js/easyui-lang-zh_CN.js"></script>
    <style>
        #login_contain{
            height: 800px;
            width: 100%;
            display:flex;
            background-image: url("../resources/images/blue_background.jpg");
        }
        #login_title{
            border-radius:10px 10px 10px 10px;
            height: 247px;
            width: 400px;
            background-image: url("../resources/images/login_text.png");
            margin-top: 250px;
            margin-left: 490px;
        }
        #login_body{
            border-radius:0px 0px 10px 10px;
            height: 180px;
            width: 400px;
            background-color: white;
            margin-top: 67px;
        }


    </style>


</head>
<body>
<div id="login_contain">
    <div id="login_title">
        <div id="login_body">
            <form id="loginform" action="../admin/login" method="post" style="padding: 10px">

                <div style="margin-bottom:20px;margin-left:20px;margin-top:20px">

                    &nbsp;&nbsp;&nbsp;<input id="username" class="easyui-textbox" name="username" style="width:250px"
                                             data-options="label:'用户名:',required:true">
                </div>
                <div style="margin-left:20px;margin-top:20px">
                    &nbsp;&nbsp;&nbsp;<input id="password" class="easyui-passwordbox" name="password" style="width:250px"
                                             data-options="label:'密码:',required:true">
                </div>

            </form>
            <div style="text-align:center;padding:5px 0">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">登录</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a>
            </div>
        </div>
    </div>
</div>


<script>
    function submitForm(){
        $('#loginform').form('submit',{
            onSubmit:function(){
                $(".easyui-linkbutton").linkbutton('disable');
            },
            ajax:false,
            success:function(data){
                if($.trim(data)=="true"){
                    $.messager.show({
                        title:'登录信息',
                        msg:'登录成功！',
                        showType:'fade',
                        timeout:3000
                    });
                    $(".easyui-linkbutton").linkbutton('enable');
                }else{
                    $.messager.show({
                        title:'登录信息',
                        msg:'登录失败！',
                        showType:'fade',
                        timeout:3000
                    });
                    $(".easyui-linkbutton").linkbutton('enable');
                }
            }
        });
    }
    function clearForm(){
        $('#loginform').form('clear');
    }
</script>
</body>

</html>