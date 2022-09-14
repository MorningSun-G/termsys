package com.jxd.termsys.service.impl;

import com.jxd.termsys.dao.ITicketDao;
import com.jxd.termsys.model.Ticket;
import com.jxd.termsys.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TicketServiceImpl
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/17
 * @Version 1.0
 */
@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private ITicketDao ticketDao;

    @Override
    public boolean addTicket(Ticket ticket) {
        return ticketDao.addTicket(ticket);
    }

    @Override
    public boolean delTicket(List<Integer> tnos) {
        return ticketDao.delTicket(tnos);
    }

    @Override
    public boolean editTicket(Ticket ticket) {
        return ticketDao.editTicket(ticket);
    }

    @Override
    public boolean editTicketBno(List<Integer> tnos, Integer bno) {
        return ticketDao.editTicketBno(tnos,bno);
    }

    @Override
    public boolean editTicketExplanation(List<Integer> tnos, String explanation) {
        return ticketDao.editTicketExplanation(tnos,explanation);
    }

    @Override
    public List<Ticket> selectBytime(String leavetime, String leaveplace, String arriveplace,int empno) {
        return ticketDao.selectBytime(leavetime,leaveplace,arriveplace,empno);
    }

    @Override
    public List<Ticket> selectByPage(int count, int pageSize, String leavetime, String leaveplace, String arriveplace,int empno) {
        return ticketDao.selectByPage(count,pageSize,leavetime,leaveplace,arriveplace,empno);
    }

    @Override
    public Ticket selectTicketByTno(int tno) {
        return ticketDao.selectTicketByTno(tno);
    }

    @Override
    public Ticket selectPreviousTicket(int empno) {
        return ticketDao.selectPreviousTicket(empno);
    }

    @Override
    public List<Ticket> selectTicketBybnoIsNull(int empno) {
        return ticketDao.selectTicketBybnoIsNull(empno);
    }

    @Override
    public List<Ticket> selectTnoByBno(int bno) {
        return ticketDao.selectTnoByBno(bno);
    }

    @Override
    public List<String> selectTphotoByTno(List<Integer> tnos) {
        return ticketDao.selectTphotoByTno(tnos);
    }


}
