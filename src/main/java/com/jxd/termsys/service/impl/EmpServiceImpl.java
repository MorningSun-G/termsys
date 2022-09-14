package com.jxd.termsys.service.impl;

import com.jxd.termsys.dao.IEmpDao;
import com.jxd.termsys.model.Emp;
import com.jxd.termsys.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/16
 * @Version 1.0
 */

@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private IEmpDao empDao;

    @Override
    public boolean addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }

    @Override
    public boolean delEmp(List<Integer> empnos) {
        return empDao.delEmp(empnos);
    }

    @Override
    public boolean editEmp(Emp emp) {
        return empDao.editEmp(emp);
    }

    @Override
    public List<Emp> selectByPage(int count, int pageSize, String ename,Integer deptno) {
        return empDao.selectByPage(count,pageSize,ename,deptno);
    }

    @Override
    public List<Emp> selectByEname(String ename,Integer deptno) {
        return empDao.selectByEname(ename,deptno);
    }

    @Override
    public Emp selectEnameAndEpwd(String ename, String epwd) {
        return empDao.selectEnameAndEpwd(ename,epwd);
    }

    @Override
    public Emp selectEmpByEmpno(int empno) {
        return empDao.selectEmpByEmpno(empno);
    }

    @Override
    public Emp selectEmpByEname(String ename) {
        return empDao.selectEmpByEname(ename);
    }

    @Override
    public Emp selectEidByDeptno(Integer deptno) {
        return empDao.selectEidByDeptno(deptno);
    }


}
