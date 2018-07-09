<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
<script type="text/javascript">

    function addTab(menuName,menuUrl){
        console.log(menuName);
        console.log(menuUrl);

        var exist=$("#tt").tabs("exists",menuName);
        console.log(exist);
        if(!exist){
            $("#tt").tabs("add",{
                title:menuName,
                closable:true,
                href:"${pageContext.request.contextPath}"+menuUrl,
            });

        }else{
            $("#tt").tabs("select",menuName);
        }
    }

	$(function(){
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/menu",
            success:function(message){
                //message:代表当前遍历的集合
                //index:当前遍历的下标
                //obj:遍历过程中的临时变量
                $.each(message,function(index,obj){

                    var content="";
                    $.each(obj.menus,function(index,obj1){
                        content+="<a class='easyui-linkbutton' style='width: 200px;text-align:center'  data-options=\"iconCls:'"+obj1.menuIcon+"',plain:true\" value="+obj1.menuId+"  onClick=\"addTab('"+obj1.menuName+"','"+obj1.menuUrl+"')\">"+obj1.menuName+"</a>"
                    });

                    $("#aa").accordion("add",{
                        title:obj.menuName,
                        content:content,
                        iconCls:obj.menuIcon,
                    });
                });
                console.log(message);
               /* for(key in message){
                    //$("#aa").append("<option value="+message[key].code+">"+message[key].name+"</option>");
                   /!* $("#aa").append("<div class='easyui-accordion' data-options='fit:true' value="+message[key].menuId+">"+message[key].menuName+"</div>");*!/
                    $('#aa').accordion('add', {
                        title: message[key].menuName,
                        iconCls: message[key].menuIcon,
                        content:function(){
                            var temp=message[key].menus.length;
                            for(i=0;i<temp;i++){
                                $(this).append("<a class='easyui-linkbutton' style='width: 200px;text-align:center'  data-options=\"iconCls:'"+message[key].menus[i].menuIcon+"',plain:true\"  onClick=\"addTab('"+message[key].menus[i].menuName+"','"+message[key].menus[i].menuUrl+"')\">"+message[key].menus[i].menuName+"</a>");
                            }
						} ,
                        selected: false,
                        animate:false,
                    });
                }*/
            }
        });
	});
</script>

</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.manager.mgrName} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/manager/exit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true"></div>
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>