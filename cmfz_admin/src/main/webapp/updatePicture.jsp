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
        $('#mf').filebox({
            buttonText: '选择文件',
            buttonAlign: 'right',
            buttonIcon:'icon-computer_go',
        });

    });
</script>
<form id="updatePicture" method="post" enctype="multipart/form-data">
    <table align="center">

        <input type="hidden" name="pictureId" style="display: none"/>
        <input type="hidden" name="picturePath" style="display: none"/>

        <tr>
            <td>轮播图描述:</td>
            <td><input class="easyui-textbox" name="pictureDescription"/></td>
        </tr>
        <tr>
            <td>轮播图状态:</td>
            <td>
                <select  class="easyui-combobox" name="pictureStatus" >
                    <option>展示中</option>
                    <option>未展示</option>
                </select>

            </td>
        </tr>
        <tr>
            <td>上传轮播图:</td>
            <td><input  id="mf"  name="myfile" /></td>
        </tr>

    </table>

</form>


