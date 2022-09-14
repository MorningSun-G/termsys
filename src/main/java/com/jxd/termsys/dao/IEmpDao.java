package com.jxd.termsys.dao;

import com.jxd.termsys.model.Emp;

import java.util.List;

public interface IEmpDao {

    /**
     * 新增员工
     * @param emp 员工对象
     * @return 是否新增成功
     */
    boolean addEmp(Emp emp);

    /**
     * 批量删除员工
     * @param empnos 员工编号 list
     * @return 是否删除成功
     */
    boolean delEmp(List<Integer> empnos);

    /**
     * 修改员工信息
     * @param emp 员工对象
     * @return 是否修改成功
     */
    boolean editEmp(Emp emp);

    /**
     * 分页查找 按名字 部门
     * @param count 跳过的条数
     * @param pageSize 每页条数
     * @param ename 根据员工姓名查找
     * @param deptno 根据部门编号查找
     * @return 员工集合
     */
    List<Emp> selectByPage(int count,int pageSize,String ename,Integer deptno);

    /**
     * 根据名字，部门模糊查询  获得数据总条数
     * @param ename 员工姓名
     * @param deptno 根据部门编号查找
     * @return 数据总条数
     */
    List<Emp> selectByEname(String ename,Integer deptno);

    /**
     *  根据员工姓名和密码 查询员工是否存在
     * @param ename 员工姓名
     * @param epwd 密码
     * @return Emp 对象
     */
    Emp selectEnameAndEpwd(String ename,String epwd);

    /**
     * 根据 员工编号查找员工
     * @param empno 员工编号
     * @return 返回员工对象
     */
    Emp selectEmpByEmpno(int empno);

    /**
     * 根据员工姓名 精确查找员工是否存在
     * @param ename 员工姓名
     * @return 员工对象
     */
    Emp selectEmpByEname(String ename);

    /**
     * 根据 部门编号查询是否已经有部门经理
     * @param deptno 部门编号
     * @return 员工对象
     */
    Emp selectEidByDeptno(Integer deptno);
}
