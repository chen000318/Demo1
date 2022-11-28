package user.dao.impl;

import user.dao.IUserDao;
import user.entry.Emp;
import user.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public Emp queryByEmpno(Emp emp) {
        return null;
    }

    @Override
    public List<Emp> queryAll() {
        return null;
    }

    @Override
    public int insert(Emp emp) {
        String sql = "insert into emp values(?,?)";
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
        int num = upd(sql,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),
                emp.getComm(),emp.getDeptno(),emp.getEmpno());
        return num;
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
