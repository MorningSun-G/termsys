package com.jxd.termsys.dao;

import com.jxd.termsys.model.Dept;

import java.util.List;

public interface IDeptDao {
    /**
     * 获取全部职位
     * @return 职位集合
     */
    List<Dept> getAllDept();

    /**
     * 增加职位
     * @param dept 职位对象
     * @return 是否增加成功
     */
    boolean addDept(Dept dept);

    /**
     * 批量删除职位
     * @param deptnos 编号 lsit
     * @return 是否删除成功
     */
    boolean delDept(List<Integer> deptnos);

    /**
     * 修改职位
     * @param dept 职位对象
     * @return 是否修改成功
     */
    boolean editDept(Dept dept);

    /**
     * 通过 编号 查找职位
     * @param deptno 编号
     * @return dept
     */
    Dept selectDeptBydeptno(int deptno);
}
