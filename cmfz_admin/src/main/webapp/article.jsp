<%--
  Created by IntelliJ IDEA.
  User: gege
  Date: 2018/7/9
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">

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
                {field:'operation',title:'操作',width:50,align:'left',formatter:formatter_status}

            ]],
            toolbar:"#oparticle",
            pagination:true,
            pageSize:4,
            pageList:[2,4,6],
        });


        $("#editArticle").linkbutton({
            onClick:function(){
                var select=$("#showAllGuru").datagrid("getSelected");

                $("#updateTable").dialog({
                    title: 'Update Guru',
                    width: 400,
                    height: 200,
                    title : "修改上师信息",
                    collapsible : true,
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    href: "${pageContext.request.contextPath}/updateGuru.jsp",
                    onLoad:function(){
                        $("#updateTable").form("load",select);
                    },
                    buttons:[{
                        text:'提交',
                        handler:function(){
                            $("#changeGuru").form("submit",{
                                url:"${pageContext.request.contextPath}/guru/change",
                                onSubmit:function(){
                                    return $("#changeGuru").form("validate");
                                },
                                success:function(data){
                                    console.log(data);
                                    var result=JSON.parse(data);

                                    if(result=="修改成功"){

                                        $("#updateTable").dialog("close");

                                        $("#showAllGuru").datagrid("reload",{
                                            href:"${pageContext.request.contextPath}/guru/showAllGuru"
                                        });
                                        $("#showAlllog").datagrid("reload",{
                                            href:"${pageContext.request.contextPath}/log/showAllLog"
                                        });
                                        $.messager.alert("信息","请刷新页面");
                                    }else{
                                        $("#updateTable").dialog("close");
                                        $.messager.alert("信息",result);
                                    }
                                }

                            });
                        }
                    }]


                });


            }
        });



    });
    function formatter_status(val,row,index){
        return '<a class="easyui-linkbutton" data-options=\"iconCls:"icon-edit"\" rel="external nofollow" onclick="modifyArticle('+index+')">修改内容</a>';
    }

    function modifyArticle(index){
        console.log(index);
    }


</script>
<table id="showAllArticle"></table>

<table id="addTable"></table>
<table id="updateTable"></table>

<div id="dgguru">
    <div id="oparticle" style="display:none">
        <%--<a id="editArticle" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改内容'"></a>--%>
    </div>

</div>

