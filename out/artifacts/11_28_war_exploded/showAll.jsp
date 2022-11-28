<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2022/11/28
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            background-color: aqua;
        }
    </style>
    <script>
        function show() {
            var boo=window.confirm("确定删除吗");
            if(boo){/*点击确定返回true 点击取消返回false*/
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>
<div style="text-align: center">
    <table style="text-align: center">
        <h1 style="text-align: center">员工表单信息</h1>
        <tr>
            <td>员工编号</td>
            <td>员工姓名</td>
            <td>岗位名称</td>
            <td>经理编号</td>
            <td>入职时间</td>
            <td>工资</td>
            <td>奖金</td>
            <td>部门编号</td>
            <td>操</td>
            <td>作</td>
        </tr>
        <c:forEach items="${list}" var="a">
            <tr>
                <td>${a.empno}</td>
                <td>${a.ename}</td>
                <td>${a.job}</td>
                <td>${a.mgr}</td>
                <td>${a.hiredate}</td>
                <td>${a.sal}</td>
                <td>${a.comm}</td>
                <td>${a.deptno}</td>
                <td><a href="ss?i=1&empno=${a.empno}" onclick="return show()">删除</a></td>
                <td><a href="ss?i=2&empno=${a.empno}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
