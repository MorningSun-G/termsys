package com.jxd.termsys.service.impl;

import com.jxd.termsys.dao.IBusinessDao;
import com.jxd.termsys.model.Business;
import com.jxd.termsys.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BusinessServiceImpl
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/21
 * @Version 1.0
 */
@Service
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private IBusinessDao businessDao;


    @Override
    public boolean addBusiness(Business business) {
        return businessDao.addBusiness(business);
    }

    @Override
    public boolean delBusiness(List<Integer> bnos) {
        return businessDao.delBusiness(bnos);
    }

    @Override
    public boolean editBusiness(Business business) {
        return businessDao.editBusiness(business);
    }

    @Override
    public boolean editBstateByBnos(List<Integer> bnos, int bstate) {
        return businessDao.editBstateByBnos(bnos,bstate);
    }

    @Override
    public List<Business> selectByTime(int bno, String begintime, String endtime,int empno) {
        return businessDao.selectByTime(bno, begintime, endtime,empno);
    }

    @Override
    public List<Business> selectByPage(int count, int pageSize, int bno, String begintime, String endtime,int empno) {
        return businessDao.selectByPage(count, pageSize, bno, begintime, endtime,empno);
    }

    @Override
    public List<Business> selectBusinessLeader(String begintime, String endtime,Integer deptno) {
        return businessDao.selectBusinessLeader(begintime,endtime,deptno);
    }

    @Override
    public List<Business> selectBusinessFinance(String begintime, String endtime,Integer deptno) {
        return businessDao.selectBusinessFinance(begintime, endtime,deptno);
    }

    @Override
    public Business selectBusinessByBno(int bno) {
        return businessDao.selectBusinessByBno(bno);
    }

    @Override
    public Business selectPreviousBusiness() {
        return businessDao.selectPreviousBusiness();
    }
}
