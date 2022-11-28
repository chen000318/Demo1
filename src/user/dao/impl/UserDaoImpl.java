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
        return 0;
    }

    @Override
    public int delete(Emp emp) {
        return 0;
    }

    @Override
    public int update(Emp emp) {
        return 0;
    }

    @Override
    public int verifyingLogin(Emp emp) {
        return 0;
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
