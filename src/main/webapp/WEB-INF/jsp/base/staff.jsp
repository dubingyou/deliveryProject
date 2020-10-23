<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/10/18
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        function doAdd() {
            //增加...
            $('#addStaffWindow').window("open");
        }

        function doView() {
            //查看...
            $('#lookStaffWindow').window("open");
        }

        //批量删除取派员
        function doDelete() {
            //获得选中的行
            var rows = $("#grid").datagrid("getSelections");
            if (rows.length == 0) {
                //没有选中，提示
                $.messager.alert("提示信息", "请选择需要删除的记录！", "warning");
            } else {
                var array = new Array();
                //选中了记录,获取选中行的id
                for (var i = 0; i < rows.length; i++) {
                    var id = rows[i].id;
                    array.push(id);
                }
                var ids = array.join(",");
                //发送请求，传递ids参数
                window.location.href = 'staffDelete.do?ids=' + ids;
            }
        }

        function doRestore() {
            alert("将取派员还原...");
        }

        //工具栏
        var toolbar = [{
            id: 'button-view',
            text: '查询',
            iconCls: 'icon-search',
            handler: doView
        }, {
            id: 'button-add',
            text: '增加',
            iconCls: 'icon-add',
            handler: doAdd
        }, {
            id: 'button-delete',
            text: '作废',
            iconCls: 'icon-cancel',
            handler: doDelete
        }, {
            id: 'button-save',
            text: '还原',
            iconCls: 'icon-save',
            handler: doRestore
        }];
        // 定义列
        var columns = [[{
            field: 'id',
            checkbox: true,
        }, {
            field: 'name',
            title: '姓名',
            width: 120,
            align: 'center'
        }, {
            field: 'telephone',
            title: '手机号',
            width: 120,
            align: 'center'
        }, {
            field: 'haspda',
            title: '是否有PDA',
            width: 120,
            align: 'center',
            formatter: function (data, row, index) {
                if (data == "1") {
                    return "有";
                } else {
                    return "无";
                }
            }
        }, {
            field: 'deltag',
            title: '是否作废',
            width: 120,
            align: 'center',
            formatter: function (data, row, index) {
                if (data == "0") {
                    return "正常使用"
                } else {
                    return "已作废";
                }
            }
        }, {
            field: 'standard',
            title: '取派标准',
            width: 120,
            align: 'center'
        }, {
            field: 'station',
            title: '所属单位',
            width: 200,
            align: 'center'
        }]];

        $(function () {
            // 先将body隐藏，再显示，不会出现页面刷新效果
            $("body").css({visibility: "visible"});

            // 取派员信息表格
            $('#grid').datagrid({
                iconCls: 'icon-forward',
                fit: true,
                border: false,
                rownumbers: true,//显示行号
                striped: true,
                pageList: [3, 5, 10],
                pagination: true,
                toolbar: toolbar,//工具栏
                url: "staffShow.do",
                idField: 'id',
                columns: columns,
                onDblClickRow: doDblClickRow//指定数据表格的双击行事件
            });


            // 查询取派员窗口
            $('#lookStaffWindow').window({
                title: '查询取派员',
                width: 400,
                modal: true,//遮罩效果
                shadow: true,//阴影效果
                closed: true,//关闭状态
                height: 400,
                resizable: false//是否可以调整大小
            });

            // 添加取派员窗口
            $('#addStaffWindow').window({
                title: '添加取派员',
                width: 400,
                modal: true,//遮罩效果
                shadow: true,//阴影效果
                closed: true,//关闭状态
                height: 400,
                resizable: false//是否可以调整大小
            });

            // 修改取派员窗口
            $('#editStaffWindow').window({
                title: '修改取派员',
                width: 400,
                modal: true,//遮罩效果
                shadow: true,//阴影效果
                closed: true,//关闭状态
                height: 400,
                resizable: false//是否可以调整大小
            });

        });

        //双击修改事件处理函数
        function doDblClickRow(rowIndex, rowData) {//{id:xxx,name:xx,}
            $('#editStaffWindow').window("open");//打开修改窗口
            $("#editStaffForm").form("load", rowData);
        }

        //扩展校验规则
        $(function () {
            var reg = /^1[3|4|5|7|8|9][0-9]{9}$/;
            $.extend($.fn.validatebox.defaults.rules, {
                phonenumber: {
                    validator: function (value, param) {
                        return reg.test(value);
                    },
                    message: '手机号输入有误！'
                }
            });
        });
        //添加表单提交
        $(function () {
            $("#save").click(function () {
                //校验表单输入项
                var v = $("#addStaffForm").form("validate");
                if (v) {
                    //校验通过，提交表单
                    $("#addStaffForm").submit();
                }
            });
        });
        //查询表单提交
        $(function () {aaaaaaaa
            $("#save").click(function () {
                //校验表单输入项
                var v = $("#lookStaffForm").form("validate");
                if (v) {
                    //校验通过，提交表单
                    $("#lookStaffForm").submit();
                }
            });
        })
        //操作提示信息
        $(function () {
            var msg="${msg}";
            if (msg != "") {
                $.messager.alert("操作信息", msg,"info");
            }
        })
    </script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="center" border="false">
    <table id="grid"></table>
</div>
    <%-- 对收派员进行添加或者修改--%>
<div class="easyui-window" title="对收派员进行添加或者修改" id="addStaffWindow"
     collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
    <div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
        <div class="datagrid-toolbar">
            <a id="save" icon="icon-save" class="easyui-linkbutton" plain="true">保存</a>
        </div>
    </div>
    <div region="center" style="overflow:auto;padding:5px;" border="false">
        <form id="addStaffForm" action="staffAdd.do"
              method="post">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">收派员信息</td>
                </tr>
                <!-- 完善收派员添加 table -->

                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>手机</td>
                    <td><input type="text" name="telephone" class="easyui-validatebox" required="true"
                               data-options="validType:'phonenumber'"
                    /></td>
                </tr>
                <tr>
                    <td>单位</td>
                    <td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="haspda"  value="1"/>
                        是否有PDA
                    </td>
                </tr>
                <tr>
                    <td>取派标准</td>
                    <td>
                        <input type="text" name="standard" class="easyui-validatebox" required="true"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<%-- 对收派员进行查询--%>
<div class="easyui-window" title="对收派员进行查询" id="lookStaffWindow"
     collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
    <div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
        <div class="datagrid-toolbar">
            <a id="find" icon="icon-save" class="easyui-linkbutton" plain="true">查询</a>
        </div>
    </div>
    <div region="center" style="overflow:auto;padding:5px;" border="false">
        <form id="lookStaffForm" action="findStaffView.do"
              method="post">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">查询信息</td>
                </tr>
                <!-- 完善收派员查询 table -->

                <tr>
                    <td>工号</td>
                    <td><input type="text" name="munber" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>所属定期</td>
                    <td><input type="text" name="telephone" class="easyui-validatebox" required="true"
                               data-options="validType:'phonenumber'"
                    /></td>
                </tr>
                <tr>
                    <td>收派标准</td>
                    <td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>所属单位</td>
                    <td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<!-- 修改窗口 -->
<div class="easyui-window" title="对收派员进行添加或者修改" id="editStaffWindow" collapsible="false"
     minimizable="false" maximizable="false" style="top:20px;left:200px">
    <div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
        <div class="datagrid-toolbar">
            <a id="edit" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
            <script type="text/javascript">
                $(function () {
                    //绑定事件
                    $("#edit").click(function () {
                        //校验表单输入项
                        var v = $("#editStaffForm").form("validate");
                        if (v) {
                            //校验通过，提交表单
                            $("#editStaffForm").submit();
                        }
                    });
                });
            </script>
        </div>
    </div>
        //编辑表单
    <div region="center" style="overflow:auto;padding:5px;" border="false">
        <form id="editStaffForm" action="staffEdit.do"
              method="post">q
            <input type="hidden" name="id">
            <table class="table-edit" width="80%" align="center">
                <tr class="title">
                    <td colspan="2">收派员信息</td>
                </tr>
                <!-- TODO 这里完善收派员添加 table -->
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td>手机</td>
                    <td><input type="text" name="telephone" class="easyui-validatebox" required="true"
                               data-options="validType:'phonenumber'"
                    /></td>
                </tr>
                <tr>
                    <td>单位</td>
                    <td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="haspda" value="1"/>
                        是否有PDA
                    </td>
                </tr>
                <tr>
                    <td>取派标准</td>
                    <td>
                        <input type="text" name="standard" class="easyui-validatebox" required="true"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
