<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2022/11/28
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录界面</title>
    <script type="text/javascript">
      function show() {
        var boo = window.confirm("确定");
        return boo;
      }
    </script>
  </head>
  <body>
  <div align="center">
    <form action="ss" method="post">
      员工编号: <input type="text" name="empno"><br/>
      员工姓名: <input type="text" name="ename"><br/>
               <input type="submit" value="登录" ><br/>
                <a href="register.jsp"><input type="submit" value="注册" onclick="return show()"></a>
    </form>
  </div>
  </body>
</html>
