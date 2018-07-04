<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
  
  	<script type="text/javascript">
  		
  		
  		function addshow(result){
  			console.log(result.text);
  			var exist=$("#tt").tabs("exists",result.text);
  			console.log(exist);
  			if(!exist){
  				$("#tt").tabs("add",{
  					title:result.text,
  					closable:true,
  					href:"${pageContext.request.contextPath}/tabs.jsp",
  				});
  				
  			}else{
  				$("#tt").tabs("select",result.text);
  			}
  			
  		}
  			
  	</script>
  </head>
  <body class="easyui-layout">   
    <div data-options="region:'north',split:true,collapsible:false" style="height:100px;">
    	<div style="height:66px">
    		<span style="font-size:30px;align:center;height:66px;line-height:66px">XX公司员工管理系统</span>
    	</div>
    	<div style="float:right;height:20px">
    		<span style="font-size:16px">欢迎您,${sessionScope.mgr.username }</span><a href="<c:url value='/exit' />.do" class="easyui-linkbutton" data-options="plain:true">[登出]</a>
    	</div>
    
    </div>   
    <div id="south" data-options="region:'south',split:true,collapsible:false" style="height:100px;">
    	<center>&copy 北京XXX有限公司</center>
    </div>   
    
    <div id="west" data-options="region:'west',title:'员工管理',split:true" style="width:250px;">
    	<div class="easyui-accordion" data-options="fit:true">
    		<div title="人事管理" class="easyui-accordion" style="overflow:auto;padding:10px;" data-options="height:60">
    			<a class="easyui-linkbutton" data-options="plain:true" style="width: 200px;text-align:left" onclick="addTab(this)">部门管理</a><br>
				<a class="easyui-linkbutton" data-options="plain:true" style="width: 200px;text-align:left" onclick="addshow(this)">员工管理</a>
    		</div>
    		<div title="日程管理" class="easyui-accordion" style="overflow:auto;padding:10px;">
    			<a class="easyui-linkbutton" data-options="plain:true" style="width: 200px;text-align:left" onclick="addTab(this)">日程</a><br>
    		</div>
    		<div title="地址管理" class="easyui-accordion" style="overflow:auto;padding:10px;">
    			<a class="easyui-linkbutton" data-options="plain:true" style="width: 200px;text-align:left" onclick="addTab(this)">地址</a><br>
    		</div>
    	</div>
    </div>   
    <div data-options="region:'center'," style="padding:5px;background:#eee;">
    	<div id="tt" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">
			<div id="main" title="主页" style="padding:20px;display:none;">
			</div>
		</div>
    </div>   
  </body>
</html>
