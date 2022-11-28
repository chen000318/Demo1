package user.dao;

import user.entry.Emp;

import java.util.List;

public interface IUserDao {
    /*
    * 根据员工编号查询员工信息
    * */
    public Emp queryByEmpno(Emp emp);

    /*
    * 查询全部员工信息
    * */
    public List<Emp> queryAll();

    /*
    * 插入功能
    * */
    public int insert(Emp emp);

    /*
    * 删除功能
    * */
    public int delete(Emp emp);

    /*
    * 更改功能
    * */
    public int update(Emp emp);
}
