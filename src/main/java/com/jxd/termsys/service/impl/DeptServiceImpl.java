package com.jxd.termsys.service.impl;

import com.jxd.termsys.dao.IDeptDao;
import com.jxd.termsys.model.Dept;
import com.jxd.termsys.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DeptServiceImpl
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/17
 * @Version 1.0
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;

    @Override
    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public boolean delDept(List<Integer> deptnos) {
        return deptDao.delDept(deptnos);
    }

    @Override
    public boolean editDept(Dept dept) {
        return deptDao.editDept(dept);
    }

    @Override
    public Dept selectDeptBydeptno(int deptno) {
        return deptDao.selectDeptBydeptno(deptno);
    }
}
