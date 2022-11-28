package user.biz.impl;

import user.biz.IEmpBiz;
import user.dao.impl.EmpDaoImpl;
import user.entry.Emp;

import java.util.List;

public class EmpBizImpl implements IEmpBiz {

    EmpDaoImpl userDao = new EmpDaoImpl();

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
        return userDao.queryAll();
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
        return userDao.queryByEmpno(emp);
    }
}