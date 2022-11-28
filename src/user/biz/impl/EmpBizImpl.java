package user.biz.impl;

import user.biz.IUserBiz;
import user.dao.impl.UserDaoImpl;
import user.entry.Emp;

import java.util.List;

public class UserBizImpl implements IUserBiz {
    UserDaoImpl userDao=new UserDaoImpl();
    @Override
    public boolean rigister(Emp emp) {
        return false;
    }

    @Override
    public boolean login(Emp emp) {
        return false;
    }

    @Override
    public List<Emp> showAll() {
        return userDao.queryAll();
    }

    @Override
    public boolean delete(Emp emp) {
        return false;
    }

    @Override
    public boolean updateEmp(Emp emp) {
        return false;
    }

    @Override
    public Emp showEmp(Emp emp) {
        return userDao.queryByEmpno(emp);
    }
}
