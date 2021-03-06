<%--
  Created by IntelliJ IDEA.
  User: gege
  Date: 2018/7/5
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script type="text/javascript">

    $(function(){
        $("#showAllGuru").datagrid({
            width:1100,
            height:500,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:"${pageContext.request.contextPath}/guru/showAllGuru",
            columns:[[
                {field:"masterId",title:"上师编号",width:100},
                {field:"masterName",title:"上师法名",width:100},
                {field:"masterSummary",title:"上师简介",width:100},
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    //'<td rowspan=2 style="border:0"><img src="/upload/guru/'+rowData.masterPhoto +'" style="height:150px;"></td>' +
                    '<td rowspan=2 style="border:0"><img src="http://192.168.214.131/'+rowData.masterPhoto +'" style="height:150px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.masterName+ '</p>' +
                    '<p>Status: ' + rowData.masterSummary + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar:"#opguru",
            pagination:true,
            pageSize:4,
            pageList:[2,4,6],
        });

        $("#add").linkbutton({
            onClick:function(){
                $("#addTable").dialog({
                    title: 'Add Guru',
                    width: 400,
                    height: 200,
                    title : "新增上师",
                    collapsible : true,
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    href: "${pageContext.request.contextPath}/guru/addGuru.jsp",

                });
            }
        });

        $("#editGuru").linkbutton({
            onClick:function(){
                var select=$("#showAllGuru").datagrid("getSelected");
                if(select){
                    $("#updateTable").dialog({
                        title: 'Update Guru',
                        width: 400,
                        height: 200,
                        title : "修改上师信息",
                        collapsible : true,
                        minimizable : true,
                        maximizable : true,
                        resizable : true,
                        href: "${pageContext.request.contextPath}/guru/updateGuru.jsp",
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

                                        $("#updateTable").dialog("close");

                                        $("#showAllGuru").datagrid("reload",{
                                            href:"${pageContext.request.contextPath}/guru/showAllGuru"
                                        });
                                        /*$.messager.alert("信息","请刷新页面");*/
                                        $.messager.alert("信息",result);
                                    }

                                });
                            }
                        }]


                    });
                }else{
                    $.messager.alert("信息","请选择上师");
                }



            }
        });

        $("#addMany").linkbutton({
            onClick:function(){
                $("#addTable").dialog({
                    title: 'Add Gurus',
                    width: 400,
                    height: 200,
                    title : "新增上师",
                    collapsible : true,
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    href: "${pageContext.request.contextPath}/guru/addManyGurus.jsp",

                });
            }
        });
        $("#expor").linkbutton({
            iconCls:"icon-bullet_cross",
            onClick:function(){
               window.location.href="${pageContext.request.contextPath}/guru/exportExcel";
            }
        });
    });
    function qq(value, n) {
        alert(value + ":" + n)

        $("#showAllGuru").datagrid("load",{
            value: value,
            n: n,
        });
    }

</script>
<table id="showAllGuru"></table>

<table id="addTable"></table>
<table id="updateTable"></table>

<div id="dgguru">
    <div id="opguru" style="display:none">
        <shiro:hasAnyRoles name="admin,root">
            <a id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增上师'"></a>
            <a id="editGuru" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改上师信息'"></a>
        </shiro:hasAnyRoles>
        <input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:qq,prompt:'请您输入需要模糊查询的内容',menu:'#mm'"></input>
        <shiro:hasRole name="root">
            <a id="addMany" class="easyui-linkbutton" data-options="iconCls:'icon-folder_up',plain:true,text:'批量插入'"></a>
            <a id="expor" class="easyui-linkbutton" data-options="iconCls:'icon-note_go',plain:true,text:'导出表格'"></a>
        </shiro:hasRole>


        <div id="mm" style="width:120px">
            <div data-options="name:'name',iconCls:'icon-ok'">法名</div>
            <div data-options="name:'des',iconCls:'icon-ok'">简介</div>
        </div>

    </div>

</div>
