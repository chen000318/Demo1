package user.dao.impl;

import user.dao.IEmpDao;
import user.entry.Emp;
import user.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements IEmpDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public Emp queryByEmpno(Emp emp) {
        Emp emp1=null;
        try {
            con=DBHelper.getCon();
            String sql="select * from emp where EMPNO=?";
            ps=con.prepareStatement(sql);
            ps.setObject(1,emp.getEmpno());
            rs=ps.executeQuery();
            if (rs.next()){
                emp1=new Emp();
                emp1.setEmpno(rs.getInt(1));
                emp1.setEname(rs.getString(2));
                emp1.setJob(rs.getString(3));
                emp1.setMgr(rs.getInt(4));
                emp1.setHiredate(rs.getDate(5));
                emp1.setSal(rs.getDouble(6));
                emp1.setComm(rs.getDouble(7));
                emp1.setDeptno(rs.getInt(8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps, rs);
        }
        return emp1;
    }

    @Override
    public List<Emp> queryAll() {
        List<Emp> list=new ArrayList<>();
        try {
            con=DBHelper.getCon();
            String sql="select * from emp";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Emp e=new Emp();
                e.setEmpno(rs.getInt(1));
                e.setEname(rs.getString(2));
                e.setJob(rs.getString(3));
                e.setMgr(rs.getInt(4));
                e.setHiredate(rs.getDate(5));
                e.setSal(rs.getDouble(6));
                e.setComm(rs.getDouble(7));
                e.setDeptno(rs.getInt(8));
                list.add(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBHelper.closeAll(con,ps, rs);
        }
        return list;
    }

    @Override
    public int insert(Emp emp) {
        String sql = "insert into emp(empno,ename) values(?,?)";
        int num = upd(sql,emp.getEmpno(),emp.getEname());
        return num;
    }

    @Override
    public int delete(Emp emp) {
        String sql = "delete from emp where empno=?";
        int num = upd(sql,emp.getEmpno());
        return 0;
    }

    @Override
    public int update(Emp emp) {
        String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        if(emp.getHiredate()==null)
            return upd(sql,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),
                    emp.getComm(),emp.getDeptno(),emp.getEmpno());
        else
        return upd(sql,emp.getEname(),emp.getJob(),emp.getMgr(),s.format(emp.getHiredate()),emp.getSal(),
                emp.getComm(),emp.getDeptno(),emp.getEmpno());
    }

    @Override
    public int verifyingLogin(Emp emp) {
        String sql = "select * from emp where empno=? and ename=?";
        int num = 0;
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,emp.getEmpno());
            ps.setString(2,emp.getEname());
            rs = ps.executeQuery();
            if(rs.next()){
                num = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps,rs);
        }
        return num;
    }

    /*
    * 公用 增删改
    * */
    public int upd(String sql,Object ...objects){
        int n = 0;
        try {
            con = DBHelper.getCon();
            ps = con.prepareStatement(sql);
            for (int i=0;i<objects.length;i++){
                ps.setObject(i+1,objects[i]);
            }
            n = ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(con,ps,rs);
        }
        return n;
    }
}
