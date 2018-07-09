<%--
  Created by IntelliJ IDEA.
  User: gege
  Date: 2018/7/5
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<script type="text/javascript">

    $(function(){
        $("#showAlllog").datagrid({
            width:1100,
            height:500,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:"${pageContext.request.contextPath}/log/showAllLog",
            columns:[[
                {field:"logId",title:"编号",width:20},
                {field:"user",title:"用户",width:20},
                {field:"logDate",title:"操作时间",width:20},
                {field:"resource",title:"操作类",width:20},
                {field:"action",title:"操作",width:20},
                {field:"message",title:"操作内容",width:150},
                {field:"result",title:"结果",width:20},
            ]],
            pagination:true,
            pageSize:4,
            pageList:[2,4,6],
        });

    });

</script>
<table id="showAlllog"></table>
