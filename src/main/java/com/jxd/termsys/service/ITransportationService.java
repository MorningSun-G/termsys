package com.jxd.termsys.service;

import com.jxd.termsys.model.Transportation;

import java.util.List;

public interface ITransportationService {
    /**
     * 获取全部的交通工具类型
     * @return 交通工具list
     */
    List<Transportation> getAllTransportation();

    /**
     * 增加交通工具
     * @param transportation 交通工具对象
     * @return 是否成功
     */
    boolean addTransportation(Transportation transportation);

    /**
     * 删除交通工具
     * @param trnos 交通工具编号 list
     * @return 是否成功
     */
    boolean delTransportation(List<Integer> trnos);

    /**
     * 修改交通工具
     * @param transportation 交通工具对象
     * @return 是否成功
     */
    boolean editTransportation(Transportation transportation);

    /**
     * 通过 trno 查询交通工具
     * @param trno 交通工具编号
     * @return 交通工具对象
     */
    Transportation selectByTrno(int trno);
}
