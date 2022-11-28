package user.biz.impl;

import user.biz.IUserBiz;
import user.entry.Emp;

import java.util.List;

public class UserBizImpl implements IUserBiz {
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
        return null;
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
        return null;
    }
}
