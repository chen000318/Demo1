package user.server;

import user.biz.impl.EmpBizImpl;
import user.entry.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/ss")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf8");
        String i = request.getParameter("i");
        if(i==null){
            response.sendRedirect("index.jsp");
        }else {
            if("1".equals(i)){
                delete(request,response);
                showAll(request,response);
            }
            if("2".equals(i)){
                update(request,response);
            }
            if("3".equals(i)){
                showAll(request,response);
            }
        }

    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getParameter("ename")==null){
            Emp emp = new Emp();
            EmpBizImpl empBiz = new EmpBizImpl();
            int empno = Integer.parseInt(request.getParameter("empno"));
            emp.setEmpno(empno);
            request.setAttribute("emp",empBiz.showEmp(emp));
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }else {
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Emp emp = new Emp();
            EmpBizImpl empBiz = new EmpBizImpl();
            emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
            emp.setEname(request.getParameter("ename"));
            emp.setJob(request.getParameter("job"));
            emp.setMgr(Integer.parseInt(request.getParameter("mgr")));
            try {
                emp.setHiredate(s.parse(request.getParameter("hiredate")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            emp.setSal(Double.parseDouble(request.getParameter("sal")));
            emp.setComm(Double.parseDouble(request.getParameter("comm")));
            emp.setDeptno(Integer.parseInt(request.getParameter("deptno")));
            if(empBiz.updateEmp(emp)){
                response.getWriter().println("<script>alert('修改成功');location.href='ss?i=3'</script>");
            }else {
                response.getWriter().println("<script>alert('修改失败,请重新修改');location.href='update.jsp'</script>");
            }
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        EmpBizImpl empBiz = new EmpBizImpl();
        Emp emp = new Emp();
        emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
        if(empBiz.delete(emp)){
            showAll(request,response);
        }else {
            response.getWriter().println("<script>alert('删除失败');location.href='showAll.jsp'</script>");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf8");
        String i = request.getParameter("i");
        if(i==null){
            login(request,response);
        }else {
            if("1".equals(i)){
                rigister(request,response);
            }else {
                response.sendRedirect("index.jsp");
            }
        }
    }

    public void rigister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf8");
        EmpBizImpl empBiz = new EmpBizImpl();
        Emp emp = new Emp();
        emp.setEname(request.getParameter("ename"));
        emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
        if(empBiz.rigister(emp)){
            System.out.println(111);
            response.getWriter().println("<script>alert('注册成功');location.href='index.jsp'</script>");
        }else {
            response.getWriter().println("<script>alert('用户已存在,请重新注册');location.href='register.jsp'</script>");
        }
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        EmpBizImpl empBiz = new EmpBizImpl();
        List<Emp> list = empBiz.showAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("showAll.jsp").forward(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf8");
        EmpBizImpl empBiz = new EmpBizImpl();
        Emp emp = new Emp();
        emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
        emp.setEname(request.getParameter("ename"));
        if(empBiz.login(emp)){
            showAll(request,response);
        }else {
            response.getWriter().println("<script>alert('用户名或密码错误');location.href='index.jsp'</script>");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}

