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
        $("#showAll").datagrid({
            width:1100,
            height:500,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            url:"${pageContext.request.contextPath}/picture/showAllPicture",
            columns:[[
                {field:"pictureId",title:"ID",width:100},
                {field:"picturePath",title:"文件名",width:150},
                {field:"pictureDescription",title:"描述信息",width:100},
                {field:"pictureStatus",title:"轮播图状态",width:100},
                {field:"pictureDate",title:"轮播图创建时间",width:100},
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    //'<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/'+rowData.picturePath+'" style="height:50px;"></td>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/'+rowData.picturePath +'" style="height:150px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.pictureDescription+ '</p>' +
                    '<p>Status: ' + rowData.pictureStatus + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar:"#oppicture",
            pagination:true,
            pageSize:4,
            pageList:[2,4,6],
        });



        $("#add").linkbutton({
            onClick:function(){
                $("#addTable").dialog({
                    title: 'Add Picture',
                    width: 400,
                    height: 200,
                    title : "新增轮播图",
                    collapsible : true,
                    minimizable : true,
                    maximizable : true,
                    resizable : true,
                    href: "${pageContext.request.contextPath}/addPicture.jsp",

                });
            }
        });

        $("#edit").linkbutton({
            onClick:function(){
                var select=$("#showAll").datagrid("getSelected");
                if(select){
                    $("#updateTable").dialog({
                        title: 'Update Picture',
                        width: 400,
                        height: 200,
                        title : "修改轮播图",
                        collapsible : true,
                        minimizable : true,
                        maximizable : true,
                        resizable : true,
                        href: "${pageContext.request.contextPath}/updatePicture.jsp",
                        onLoad:function(){
                            $("#updateTable").form("load",select);
                        },
                        buttons:[{
                            text:'提交',
                            handler:function(){
                                $("#updatePicture").form("submit",{
                                    url:"${pageContext.request.contextPath}/picture/update",
                                    onSubmit:function(){
                                        return $("#updatePicture").form("validate");
                                    },
                                    success:function(data){
                                        console.log(data);
                                        var result=JSON.parse(data);

                                        $("#updateTable").dialog("close");

                                        $("#showAll").datagrid("reload",{
                                            href:"${pageContext.request.contextPath}/picture/showAllPicture"
                                        });
                                        /* $.messager.alert("信息","请刷新页面");*/
                                        $.messager.alert("信息",result);

                                    }

                                });
                            }
                        }]
                    });
                }else{
                    $.messager.alert("信息","请选择修改对象");
                }
            }
        });
    });

</script>
<table id="showAll"></table>

<table id="addTable"></table>
<table id="updateTable"></table>

<div id="dgp">
    <div id="oppicture" style="display:none">
        <a id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'"></a>
        <a id="help" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
        <a id="edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>

    </div>

</div>
