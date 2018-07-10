<%--
  Created by IntelliJ IDEA.
  User: gege
  Date: 2018/7/9
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    var info;
    $(function(){
        $("#showAllArticle").datagrid({
            width:1100,
            height:500,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            rownumbers:true,
            url:"${pageContext.request.contextPath}/article/showAllArticle",
            columns:[[
                {field:"articleId",title:"编号",width:30},
                {field:"articleTitle",title:"标题",width:30},
                {field:"articleStatus",title:"状态",width:30},
                {field:"date",title:"创建时间",width:30},
                {field:"guruName",title:"所属上师",width:30},
                {field:'opt',title:'操作',width:50,align:'center',
                    formatter:function(value,rec,index){
                        var btn = '<a class="detial" onclick="detialRow('+index+')">文章详情</a>' +
                            '<a class="editcls" onclick="editRow('+index+')">修改内容</a>';
                        return btn;
                    }
                }

            ]],
            toolbar:"#oparticle",
            pagination:true,
            pageSize:4,
            pageList:[2,4,6],
            onLoadSuccess:function(data){
                $('.detial').linkbutton({text:'文章详情',iconCls:'icon-table_save'});
                $('.editcls').linkbutton({text:'修改内容',iconCls:'icon-edit'});
            }
        });

    });
    function detialRow(index){
        $("#showAllArticle").datagrid('selectRow',index);// 关键在这里
        var row = $('#showAllArticle').datagrid('getSelected');
        console.log(row.introduction);
        info = row.introduction;
        $("#articleTable").dialog({
            title : "文章详情",
            width: 600,
            height: 400,
            collapsible : true,
            minimizable : true,
            maximizable : true,
            resizable : true,
            href: "${pageContext.request.contextPath}/articleDetail.jsp",
        });


    }
    function editRow(index){
        $("#showAllArticle").datagrid('selectRow',index);// 关键在这里
        var row = $('#showAllArticle').datagrid('getSelected');
        console.log(row);
        $("#updateTable").dialog({
            title : "文章详情",
            width: 600,
            height: 400,
            collapsible : true,
            minimizable : true,
            maximizable : true,
            resizable : true,
            href: "${pageContext.request.contextPath}/updateArticle.jsp",
            onLoad:function(){
                $("#upArticle").form("load",row);
            },
        });

    }
    function getInfo() {
        console.log(info);
        return info;
    }


</script>
<table id="showAllArticle"></table>

<table id="articleTable"></table>
<table id="updateTable"></table>

<div id="dgguru">
    <div id="oparticle" style="display:none">
        <%--<a id="editArticle" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改内容'"></a>--%>
    </div>

</div>

