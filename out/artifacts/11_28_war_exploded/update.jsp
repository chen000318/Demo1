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
            background-color: aquamarine;
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <form method="get" action="ss" style="text-align: center">
        <h1 style="text-align: center">修改信息填写</h1>
            员工编号：<input type="text" name="empno" readonly value="${emp.empno}"><br/>
            员工姓名：<input type="text" name="ename" value="${emp.ename}"><br/>
            岗位名称：<input type="text" name="job" value="${emp.job}"><br/>
            经理编号：<input type="text" name="mgr" value="${emp.mgr}"><br/>
            入职时间：<input type="date" name="hiredate" value="${emp.hiredate}"><br/>
            工&nbsp;&nbsp;&nbsp;&nbsp;资：<input type="text" name="sal" value="${emp.sal}"><br/>
            奖&nbsp;&nbsp;&nbsp;&nbsp;金： <input type="text" name="comm" value="${emp.comm}"><br/>
            部门编号：<input type="text" name="deptno" value="${emp.deptno}"><br/>
                     <input type="hidden" name="i" value="2">
                     <input type="submit" value="修改提交">
    </form>
</div>
</body>
</html>
