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
        $('#mp').filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            buttonIcon:'icon-computer_go',
        });

    });
</script>
<form id="changeGuru" method="post" enctype="multipart/form-data">
    <table align="center">
        <input type="hidden" name="masterId" style="display: none"/>
        <<input type="hidden" name="masterPhoto" style="display: none">
        <tr>
            <td>上师法名:</td>
            <td><input class="easyui-textbox" name="masterName" /></td>
        </tr>
        <tr>
            <td>上师简介:</td>
            <td><input  class="easyui-textbox" name="masterSummary" /></td>
        </tr>
        <tr>
            <td>上师照片:</td>
            <td><input  id="mp"  name="myfile" /></td>
        </tr>

    </table>

</form>


