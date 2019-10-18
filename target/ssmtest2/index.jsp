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
    <div data-options="region:'north',title:'North Title',split:true" style="height:200px;">
        <div id="log_info">用户：</div>
        <img src="../resources/images/title.png" style="height: 160px;width:100%">
    </div>
    <div data-options="region:'west',title:'West',split:true" style="width:300px;">
        <div class="easyui-accordion" data-options="fit:true,border:0">
            <div title="电池管理">
                <ul class="easyui-tree">
                    <li>
                        <span>车辆和车主</span>
                        <ul>
                            <li>
                                <span><a href="#" onclick=addTabs(this)>车辆信息</a></span>
                            </li>
                            <li>
                                <span><a href="#" onclick=addTabs(this)>车主信息</a></span>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span><a href="#" onclick=addTabs(this)>电池信息</a></span>
                    </li>
                    <li>
                        <span><a href="#" onclick=addTabs(this)>更换记录</a></span>
                    </li>
                </ul>
            </div>
            <div title="个人设置">
                <ul class="easyui-tree">
                    <li>
                        <span><a href="#">个人信息</a></span>
                    </li>
                </ul>
            </div>
            <div title="权限管理"></div>
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
    function addTabs(obj) {
        var url="";
        switch (obj.text) {
            case("车辆信息"):
                url="listcar.html";
                break;
            case("车主信息"):
                url="listuser.html";
                break;
            case("电池信息"):
                url="listbattery.html";
                break;
            case("更换记录"):
                url="listrecord.html";
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