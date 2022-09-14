package com.jxd.termsys.controller;

import com.jxd.termsys.model.Business;
import com.jxd.termsys.model.Ticket;
import com.jxd.termsys.model.Transportation;
import com.jxd.termsys.service.ITicketService;
import com.jxd.termsys.service.ITransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @ClassName TicketController
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/17
 * @Version 1.0
 */
//代表当前controller类中的请求方法都是直接向前台返回数据的,
// 每个请求方法不再需要单独添加@ResponseBody注解
@RestController
public class TicketController {

    @Autowired
    private ITicketService ticketService;
    @Autowired
    private ITransportationService transportationService;

    //新增车票
    @RequestMapping("/addTicket")
    public String addTicket(@RequestBody Ticket ticket){
        boolean flag = ticketService.addTicket(ticket);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //批量删除车票
    @RequestMapping("/delTicket")
    public String delTicket(@RequestBody List<Integer> tnos){
        boolean flag = ticketService.delTicket(tnos);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //修改车票信息
    @RequestMapping("/editTicket")
    public String editTicket(@RequestBody Ticket ticket){
        boolean flag = ticketService.editTicket(ticket);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //根据车票编号批量设置关联差旅信息
    @RequestMapping("/editTicketBno/{tnos}/{bno}")
    public String editTicketBno(@PathVariable("tnos") List<Integer> tnos,@PathVariable("bno") Integer bno){
        boolean flag = ticketService.editTicketBno(tnos,bno);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //根据车票编号批量设置 出差事由
    @RequestMapping("/editTicketExplanation/{tnos}/{explanation}")
    public String editTicketExplanation(@PathVariable("tnos") List<Integer> tnos,@PathVariable("explanation") String explanation){
        boolean flag = ticketService.editTicketExplanation(tnos,explanation);
        if (flag){
            return "success";
        }else {
            return "error";
        }
    }

    //根据差旅信息编号设置 车票 的关联信息为null
    @RequestMapping("/editTicketBnoNull/{bnos}")
    public String editTicketBnoNull(@PathVariable("bnos") List<Integer> bnos){
        boolean flag = false;
        boolean flag1 = false;
        //批量设置 ticket 的 bno 为null
        for (Integer bno:bnos) {
            //根据bno 查出 tnos
            List<Integer> tnos = new ArrayList<>();
            List<Ticket> tickets = ticketService.selectTnoByBno(bno);
            for (Ticket ticket : tickets) {
                tnos.add(ticket.getTno());
            }
            //bno1 设置为null
            Integer bno1 = null;
            flag = ticketService.editTicketBno(tnos, bno1);
            //explanation 设置为空
            flag1 = ticketService.editTicketExplanation(tnos,null);
        }
        if (flag && flag1){
            return "success";
        }else {
            return "error";
        }
    }

    //分页获取车票列表
    @RequestMapping("/getTicketList")
    public Map<String,Object> getTicketList(@RequestBody Map<String,String> queryMap) {
        Map<String,Object> map = new HashMap<>();
        String page = queryMap.get("page"); //第几页
        String limit = queryMap.get("limit"); //每页条数
        String leavetime = queryMap.get("leavetime"); //出发时间
        String leaveplace = queryMap.get("leaveplace"); //出发地点
        String arriveplace = queryMap.get("arriveplace"); //到达地点
        int empno;
        if (queryMap.get("empno") != null && queryMap.get("empno") != ""){
            empno = Integer.parseInt(queryMap.get("empno")); //员工编号
        }else {
            empno = 0;
        }

        int pageSize = Integer.parseInt(limit); //每页条数
        int count = (Integer.parseInt(page) - 1) * pageSize; //跳过条数

        int total = ticketService.selectBytime(leavetime,leaveplace,arriveplace,empno).size(); //总数据量
        List<Ticket> list =ticketService.selectByPage(count,pageSize,leavetime,leaveplace,arriveplace,empno); //查询到的车票
        map.put("total",total);
        map.put("data",list);
        return map;
    }

    //根据车票编号查询车票信息
    @RequestMapping("/getTicketByTno/{tno}")
    public Ticket getTicketByTno(@PathVariable("tno") int tno){
        Ticket ticket = ticketService.selectTicketByTno(tno);
        return ticket;
    }

    //获取全部交通工具
    @RequestMapping("/getAllTransportation")
    public List<Transportation> getAllTransportation(){
        List<Transportation> list = transportationService.getAllTransportation();
        return list;
    }

    //查询上一条车票信息 根据员工编号
    @RequestMapping("/getPreviousTicket/{empno}")
    public Ticket getPreviousTicket(@PathVariable("empno")  int empno){
        Ticket ticket = ticketService.selectPreviousTicket(empno);
        if (ticket != null){
            return ticket;
        }else {
            return null;
        }
    }

    //根据员工编号 查询bno为null即没有关联信息的车票
    @RequestMapping("/getTicketByBno/{empno}")
    public List<Ticket> getTicketByBno(@PathVariable("empno")  int empno){
        List<Ticket> list = ticketService.selectTicketBybnoIsNull(empno);
        return list;
    }

    //根据bno 查询 ticket list
    @RequestMapping("/getTicketsByBno/{bno}")
    public List<Ticket> getTicketsByBno(@PathVariable("bno") int bno){
        List<Ticket> list = ticketService.selectTnoByBno(bno);
        return list;
    }


    //上传文件
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile,
                             HttpServletRequest request){
        //创建一个目录files，用于存放上传的文件
        String savePath = "E:\\workspace\\tphoto";

        //获取原文件名
        String oldName = multipartFile.getOriginalFilename();
        //对源文件名进行处理
        String newName = UUID.randomUUID() + "_" + oldName;

        //根据保存路径和新名字生成一个文件对象
        File saveFile = new File(savePath,newName);

        try {
            //将springmvc接收到的文件对象转化为普通的文件对象
            //转换的过程即保存的过程
            multipartFile.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回文件保存路径以及文件名，以便删除时使用
        return  newName;
    }


    //删除文件
    @RequestMapping("/delFile")
    @ResponseBody
    public String delFile(@RequestBody String fileName){
        //获取文件的完整路径
        String savePath = "E:\\workspace\\tphoto";

        //fileName有=
        fileName = fileName.substring(0,fileName.length()-1);

        //根据完整路径创建文件对象
        File file = new File(savePath,fileName);
        if (file.exists()){
            if (file.delete()){
                return "success";
            }else {
                return "error";
            }
        }else {
            return "删除失败";
        }
    }


    //批量删除文件
    @RequestMapping("/delFiles")
    @ResponseBody
    public String delFile(@RequestBody List<Integer> tnos){
        //获取文件的完整路径
        String savePath = "E:\\workspace\\tphoto";
        //根据tno 查找tphoto
        List<String> fileNamelist = ticketService.selectTphotoByTno(tnos);
        //遍历list 找出fileName不为空的删除
        for (String fileName: fileNamelist) {
            if (fileName != null && !fileName.equals("")){
                //根据完整路径创建文件对象
                File file = new File(savePath,fileName);
                if (file.exists()){
                    file.delete();
                }else {
                    return "error";
                }
            }
        }
        //fileName有=
        //fileName = fileName.substring(0,fileName.length()-1);
        return "success";
    }



}
