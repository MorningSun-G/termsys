package com.jxd.termsys.service.impl;

import com.jxd.termsys.dao.ITransportationDao;
import com.jxd.termsys.model.Transportation;
import com.jxd.termsys.service.ITransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TransportationServiceImpl
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/19
 * @Version 1.0
 */

@Service
public class TransportationServiceImpl implements ITransportationService {

    @Autowired
    private ITransportationDao transportationDao;

    @Override
    public List<Transportation> getAllTransportation() {
        return transportationDao.getAllTransportation();
    }

    @Override
    public boolean addTransportation(Transportation transportation) {
        return transportationDao.addTransportation(transportation);
    }

    @Override
    public boolean delTransportation(List<Integer> trnos) {
        return transportationDao.delTransportation(trnos);
    }

    @Override
    public boolean editTransportation(Transportation transportation) {
        return transportationDao.editTransportation(transportation);
    }

    @Override
    public Transportation selectByTrno(int trno) {
        return transportationDao.selectByTrno(trno);
    }
}
