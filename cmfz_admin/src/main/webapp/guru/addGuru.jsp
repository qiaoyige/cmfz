<%--
  Created by IntelliJ IDEA.
  User: gege
  Date: 2018/7/5
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<style type="text/css">
    form{
        padding-bottom:0px;
        margin: 10px;
    }
</style>
<script type="text/javascript">
    $(function(){
        $('#fb').filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            buttonIcon:'icon-computer_go',
        });

       $("#save").linkbutton({
            iconCls:"icon-table_save",
            onClick:function(){
               $('#addGuru').form("submit",{
                    url:"${pageContext.request.contextPath}/guru/add",
                    onSubmit:function(){
                        return $("#addGuru").form("validate");
                    },
                    success:function(data){
                        $("#addTable").dialog("close");
                        var temp=JSON.parse(data);

                       if(temp=="添加成功"){
                           $.messager.show({
                               title:'提示消息',
                               msg:temp+'消息将在5秒后关闭。',
                               timeout:5000,
                               showType:'slide'
                           });
                       }else{
                           $.messager.alert("信息",temp);
                       }

                        $("#showAllGuru").datagrid("reload",{
                            href:"${pageContext.request.contextPath}/guru/showAllGuru"
                        });
                    },
                });

            },
        });

        $("#cancle").linkbutton({
            iconCls:"icon-bullet_cross",
            onClick:function(){
                $('#addGuru').form("reset");
            }
        });



    });
</script>
<form id="addGuru" method="post" enctype="multipart/form-data">
    <table align="center">
        <tr>
            <td>上师法名:</td>
            <td><input class="easyui-textbox" name="masterName"/></td>
        </tr>
        <tr>
            <td>上师简介:</td>
            <td><input  class="easyui-textbox" name="masterSummary" /></td>
        </tr>
        <tr>
            <td>上师照片:</td>
            <td><input  id="fb"  name="myfile" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <a id="save">保存</a>
                <a id="cancle">取消</a>
            </td>
        </tr>

    </table>

</form>


