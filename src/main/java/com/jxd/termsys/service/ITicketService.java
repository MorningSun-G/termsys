package com.jxd.termsys.service;

import com.jxd.termsys.model.Ticket;

import java.util.List;

public interface ITicketService {
    /**
     * 新增车票信息
     * @param ticket 车票对象
     * @return 是否新增成功
     */
    boolean addTicket(Ticket ticket);

    /**
     * 批量删除车票
     * @param tnos 车票信息编号集合
     * @return 是否删除成功
     */
    boolean delTicket(List<Integer> tnos);

    /**
     * 修改车票信息
     * @param ticket 车票对象
     * @return 是否修改成功
     */
    boolean editTicket(Ticket ticket);

    /**
     * 根据tno 批量修改 bno  根据车票编号批量设置关联差旅信息
     * @param tnos 车票编号list
     * @param bno 差旅信息编号
     * @return 是否修改成功
     */
    boolean editTicketBno(List<Integer> tnos,Integer bno);

    /**
     * 根据tno 批量修改explanation 车票列表显示的出差说明是取自差旅信息表的出差说明
     * @param tnos 车票编号list
     * @param explanation 出差事由
     * @return 是否修改成功
     */
    boolean editTicketExplanation(List<Integer> tnos,String explanation);

    /**
     *  根据开始时间 出发地点和到达地点查询车票 获得查询到的总数据
     * @param leavetime 出发时间
     * @param leaveplace 出发地点
     * @param arriveplace 到达地点
     * @param empno 员工编号
     * @return 车票list
     */
    List<Ticket> selectBytime(String leavetime,String leaveplace,String arriveplace,int empno);

    /**
     * 分页查询 车票信息
     * @param count 跳过的条数
     * @param pageSize 每页条数
     * @param leavetime 出发时间
     * @param leaveplace 出发地点
     * @param arriveplace 到达地点
     * @param empno 员工编号
     * @return 车票 list
     */
    List<Ticket> selectByPage(int count,int pageSize,String leavetime,String leaveplace,String arriveplace,int empno);

    /**
     * 根据车票编号查询 该车票的全部信息
     * @param tno 车票编号
     * @return 车票对象
     */
    Ticket selectTicketByTno(int tno);

    /**
     *  根据员工编号查询上一条插入的车票信息
     * @param empno 员工编号
     * @return 车票对象
     */
    Ticket selectPreviousTicket(int empno);

    /**
     * 查询车票 根据 员工编号 且bno为null
     * @param empno 员工编号
     * @return 车票list
     */
    List<Ticket> selectTicketBybnoIsNull(int empno);

    /**
     * 通过差旅信息编号  找到这条差旅信息关联的车票编号
     * @param bno 车票编号
     * @return ticket list
     */
    List<Ticket> selectTnoByBno(int bno);

    /**
     * 根据tno 找到车票的照片
     * @param tnos 车票编号list
     * @return 车票照片名list
     */
    List<String> selectTphotoByTno(List<Integer> tnos);


}
