package com.jxd.termsys.controller;

import com.jxd.termsys.model.Business;
import com.jxd.termsys.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BusinessController
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/21
 * @Version 1.0
 */
//代表当前controller类中的请求方法都是直接向前台返回数据的,
// 每个请求方法不再需要单独添加@ResponseBody注解
@RestController
public class BusinessController {

    @Autowired
    private IBusinessService businessService;

    //新增 差旅信息
    @RequestMapping("/addBusiness")
    public String addBusiness(@RequestBody Business business){

        boolean flag = businessService.addBusiness(business);

        //获取刚刚插入的数据的bno
        Business business1 = businessService.selectPreviousBusiness();
        String bno = business1.getBno().toString();
        if (flag){
            return bno;
        }else {
            return "error";
        }
    }

    //批量删除差旅信息
    @RequestMapping("/delBusiness")
    public String delBusiness(@RequestBody List<Integer> bnos){

        boolean flag = businessService.delBusiness(bnos);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //修改 差旅信息
    @RequestMapping("/editBusiness")
    public String editBusiness(@RequestBody Business business){
        boolean flag = businessService.editBusiness(business);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //根据 bnos 批量修改 bstate
    @RequestMapping("/editBstateByBnos/{bnos}/{bstate}")
    public String editBstateByBnos(@PathVariable("bnos") List<Integer> bnos,@PathVariable("bstate") int bstate){
        boolean flag = businessService.editBstateByBnos(bnos, bstate);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //分页获取差旅信息
    @RequestMapping("/getBusinessList")
    public Map<String,Object> getBusinessList(@RequestBody Map<String,String> queryMap){
        Map<String,Object> map = new HashMap<>();
        String page = queryMap.get("page"); //第几页
        String limit = queryMap.get("limit"); //每页条数
        String begintime = queryMap.get("begintime"); //开始时间
        String endtime = queryMap.get("endtime"); //结束时间
        int bno ;  //差旅信息编号

        if (queryMap.get("bno") !=null && queryMap.get("bno") != ""){
            bno = Integer.parseInt(queryMap.get("bno"));
        }else {
            bno = 0;
        }

        int empno ; //员工编号
        if (queryMap.get("empno") != null && queryMap.get("empno") != ""){
            empno = Integer.parseInt(queryMap.get("empno")); //员工编号
        }else {
            empno = 0;
        }

        int pageSize = Integer.parseInt(limit); //每页条数
        int count = (Integer.parseInt(page) - 1) * pageSize; //跳过条数

        int total = businessService.selectByTime(bno,begintime,endtime,empno).size(); //总数据量
        List<Business> list = businessService.selectByPage(count,pageSize,bno,begintime,endtime,empno); //分页查询到的数据
        map.put("total",total);
        map.put("data",list);
        return map;
    }

    //领导获取本部门员工  bstate 为 2 和  4 的 business
    @RequestMapping("/leaderCheckBusiness")
    public List<Business> leaderCheckBusiness(@RequestBody Map<String,String> queryMap){
        String begintime = queryMap.get("begintime"); //开始时间
        String endtime = queryMap.get("endtime"); //结束时间
        Integer deptno = Integer.parseInt(queryMap.get("deptno")); //部门编号
        List<Business> list = businessService.selectBusinessLeader(begintime,endtime,deptno);
        return list;
    }

    //财务获取不同部门 bstate 为 3 的 business
    @RequestMapping("/financeCheckBusiness")
    public List<Business> financeCheckBusiness(@RequestBody Map<String,String> queryMap){
        String begintime = queryMap.get("begintime"); //开始时间
        String endtime = queryMap.get("endtime"); //结束时间
        Integer deptno = 1; //部门编号
        if ("".equals(queryMap.get("deptno")) || queryMap.get("deptno") == null){
            deptno = 2;
        }else {
            deptno = Integer.parseInt(queryMap.get("deptno")); //部门编号
        }
        List<Business> list = businessService.selectBusinessFinance(begintime,endtime,deptno);
        return list;
    }



    //根据编号 查询差旅信息
    @RequestMapping("/getBusinessByBno/{bno}")
    public Business getBusinessByBno(@PathVariable("bno") int bno){
        Business business = businessService.selectBusinessByBno(bno);
        return business;
    }


}
