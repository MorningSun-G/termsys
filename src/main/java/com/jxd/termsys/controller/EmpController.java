package com.jxd.termsys.controller;

import com.jxd.termsys.model.Dept;
import com.jxd.termsys.model.Emp;
import com.jxd.termsys.model.Transportation;
import com.jxd.termsys.service.IDeptService;
import com.jxd.termsys.service.IEmpService;
import com.jxd.termsys.service.ITransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/16
 * @Version 1.0
 */
//代表当前controller类中的请求方法都是直接向前台返回数据的,
// 每个请求方法不再需要单独添加@ResponseBody注解
@RestController
public class EmpController {

    @Autowired
    private IEmpService empService;
    @Autowired
    private IDeptService deptService;
    @Autowired
    private ITransportationService transportationService;


    //登录验证
    @RequestMapping("/login")
    public Emp login(@RequestBody Emp emp){
        Emp empL = empService.selectEnameAndEpwd(emp.getEname(),emp.getEpwd());
        return empL;
    }

    //新增员工
    @RequestMapping("/addEmp")
    public String addEmp(@RequestBody Emp emp){
        boolean flag = empService.addEmp(emp);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //新增交通工具
    @RequestMapping("/addTransportation")
    public String addTransportation(@RequestBody Transportation transportation){
        boolean flag = transportationService.addTransportation(transportation);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //新增职位
    @RequestMapping("/addDept")
    public String addDept(@RequestBody Dept dept){
        boolean flag = deptService.addDept(dept);
        if (flag){
            return "success";
        }else {
            return "error";
        }

    }


    //批量删除员工
    @RequestMapping("/delEmp")
    public String delEmp(@RequestBody List<Integer> empnos){
        boolean flag = empService.delEmp(empnos);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //批量删除交通工具
    @RequestMapping("/delTransportation")
    public String delTransportation(@RequestBody List<Integer> trnos){
        boolean flag = transportationService.delTransportation(trnos);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //批量删除职位
    @RequestMapping("/delDept")
    public String delDept(@RequestBody List<Integer> deptnos){
        boolean flag = deptService.delDept(deptnos);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //修改员工信息
    @RequestMapping("/editEmp")
    public String editEmp(@RequestBody Emp emp){
        boolean flag = empService.editEmp(emp);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //修改交通工具
    @RequestMapping("/editTransportation")
    public String editTransportation(@RequestBody Transportation transportation){
        boolean flag = transportationService.editTransportation(transportation);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //修改职位信息
    @RequestMapping("/editDept")
    public String editDept(@RequestBody Dept dept){
        boolean flag = deptService.editDept(dept);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }


    //分页获取员工列表
    @RequestMapping("/getEmpList")
    public Map<String,Object> getEmpList(@RequestBody Map<String,String> queryMap){
        Map<String,Object> map = new HashMap<>();
        String page = queryMap.get("page"); //第几页
        String limit = queryMap.get("limit"); //每页条数
        String ename = queryMap.get("ename").trim(); //员工姓名

        Integer deptno = null; //部门编号
        if ("".equals(queryMap.get("deptno")) || queryMap.get("deptno") == null){
            deptno = null;
        }else {
            deptno = Integer.parseInt(queryMap.get("deptno")); //部门编号
        }

        int pageSize = Integer.parseInt(limit); //每页条数
        int count = (Integer.parseInt(page) - 1) * pageSize; //跳过条数

        Integer total = empService.selectByEname(ename,deptno).size();//总数据量
        List<Emp> list = empService.selectByPage(count,pageSize,ename,deptno); //查询的员工集合
        map.put("total",total);
        map.put("data",list);
        return map;
    }

    //根据员工编号获取员工数据
    @RequestMapping("/getEmpByEmpno/{empno}")
    public Emp getEmpByEmpno(@PathVariable("empno") int empno){
        Emp emp = empService.selectEmpByEmpno(empno);
        return emp;
    }

    //通过 交通工具编号获取 交通工具
    @RequestMapping("/getTransportationByTrno/{trno}")
    public Transportation getTransportationByTrno(@PathVariable("trno") int trno){
        Transportation transportation = transportationService.selectByTrno(trno);
        return transportation;
    }

    //根据职位编号获取职位
    @RequestMapping("/getDeptByDeptno/{deptno}")
    public Dept getDeptByDeptno(@PathVariable("deptno") int deptno){
        Dept dept = deptService.selectDeptBydeptno(deptno);
        return dept;
    }

    //根据员工姓名 判断是否已经存在
    @RequestMapping("/empOnly/{ename}")
    public Emp empOnly(@PathVariable("ename") String ename){
        Emp emp = empService.selectEmpByEname(ename);
            return emp;
    }

    //根据部门编号 部门经理是否已经存在
    @RequestMapping("/eidOnly/{deptno}")
    public Emp eidOnly(@PathVariable("deptno") Integer deptno){
        Emp emp = empService.selectEidByDeptno(deptno);
        return emp;
    }


    //获取全部职位列表
    @RequestMapping("/getAllDept")
    public List<Dept> getAllDept(){
        return deptService.getAllDept();
    }


}
