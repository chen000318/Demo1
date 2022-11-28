package user.biz;

import user.entry.Emp;

import java.util.List;

public interface IUserBiz {
    /*
    * 注册功能
    * */
    public boolean rigister(Emp emp);
    /*
    * 登录功能
    * */
    public boolean login(Emp emp);
    /*
    * 展示全部
    * */
    public List<Emp> showAll();
    /*
    * 删除
    * */
    public boolean delete(Emp emp);
    /*
    * 更改
    * */
    public boolean updateEmp(Emp emp);
    /*
    * 展示某个员工信息
    * */
    public Emp showEmp(Emp emp);
}
