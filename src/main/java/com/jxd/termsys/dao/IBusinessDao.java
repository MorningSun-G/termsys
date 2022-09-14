package com.jxd.termsys.dao;

import com.jxd.termsys.model.Business;

import java.util.List;

public interface IBusinessDao {

    /**
     * 新增差旅信息
     * @param business 差旅信息对象
     * @return 是否新增成功
     */
    boolean addBusiness(Business business);

    /**
     * 批量删除差旅信息
     * @param bnos 差旅信息编号 数组
     * @return 是否删除成功
     */
    boolean delBusiness(List<Integer> bnos);

    /**
     * 修改差旅信息
     * @param business 差旅信息对象
     * @return 是否修改成功
     */
    boolean editBusiness(Business business);

    /**
     * 根据 bnos 批量修改bstate
     * @param bnos 差旅编号 list
     * @param bstate 状态（谁在处理信息）
     * @return 是否修改成功
     */
    boolean editBstateByBnos(List<Integer> bnos,int bstate);

    /**
     * 根据 员工编号查询在此时间区间内的 差旅信息  总数据
     * @param bno 差旅信息编号
     * @param begintime 开始时间
     * @param endtime 结束时间
     * @param empno 员工编号
     * @return 差旅信息list
     */
    List<Business> selectByTime(int bno, String begintime, String endtime,int empno);

    /**
     * 分页查询 差旅信息
     * @param count 跳过的条数
     * @param pageSize 每页条数
     * @param bno 差旅信息编号
     * @param begintime 开始时间
     * @param endtime 结束时间
     * @param empno 员工编号
     * @return  差旅信息list
     */
    List<Business> selectByPage(int count, int pageSize, int bno, String begintime, String endtime,int empno);


    /**
     * 领导审批 business 可通过时间区间查询
     * @param begintime 开始时间
     * @param endtime 结束时间
     * @param deptno 部门编号
     * @return list
     */
    List<Business> selectBusinessLeader(String begintime,String endtime,Integer deptno);

    /**
     * 财务审批 business 可通过时间区间查询
     * @param begintime 开始时间
     * @param endtime 结束时间
     * @param deptno 部门编号
     * @return list
     */
    List<Business> selectBusinessFinance(String begintime,String endtime,Integer deptno);

    /**
     *  根据差旅信息编号 查询该差旅信息
     * @param bno 差旅信息编号
     * @return 差旅信息对象
     */
    Business selectBusinessByBno(int bno);

    /**
     * 查询 最新插入的数据
     * @return 差旅信息对象
     */
    Business selectPreviousBusiness();
}
