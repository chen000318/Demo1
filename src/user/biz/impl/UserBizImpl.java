package user.biz.impl;

import user.biz.IUserBiz;
import user.dao.impl.UserDaoImpl;
import user.entry.Emp;

import java.util.List;

public class UserBizImpl implements IUserBiz {

    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public boolean rigister(Emp emp) {

        return userDao.insert(emp)==1?true:false;
    }

    @Override
    public boolean login(Emp emp) {

        return userDao.verifyingLogin(emp)==1?true:false;
    }

    @Override
    public List<Emp> showAll() {
        return null;
    }

    @Override
    public boolean delete(Emp emp) {

        return userDao.delete(emp)==1?true:false;
    }

    @Override
    public boolean updateEmp(Emp emp) {

        return userDao.update(emp)==1?true:false;
    }

    @Override
    public Emp showEmp(Emp emp) {
        return null;
    }
}
