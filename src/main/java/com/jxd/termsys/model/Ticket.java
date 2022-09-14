package com.jxd.termsys.model;

/**
 * @ClassName Ticket
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/17
 * @Version 1.0
 */
public class Ticket {
    private Integer tno;
    private Integer empno;
    private String ttype;
    private String leaveplace;
    private String arriveplace;
    private String leavetime;
    private String arrivetime;
    private Integer trno;
    private Double tprice;
    private String tphoto;
    private String explanation;
    private Integer bno;
    private String trname;

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public String getLeaveplace() {
        return leaveplace;
    }

    public void setLeaveplace(String leaveplace) {
        this.leaveplace = leaveplace;
    }

    public String getArriveplace() {
        return arriveplace;
    }

    public void setArriveplace(String arriveplace) {
        this.arriveplace = arriveplace;
    }

    public String getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }

    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }

    public Integer getTrno() {
        return trno;
    }

    public void setTrno(Integer trno) {
        this.trno = trno;
    }

    public Double getTprice() {
        return tprice;
    }

    public void setTprice(Double tprice) {
        this.tprice = tprice;
    }

    public String getTphoto() {
        return tphoto;
    }

    public void setTphoto(String tphoto) {
        this.tphoto = tphoto;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getTrname() {
        return trname;
    }

    public void setTrname(String trname) {
        this.trname = trname;
    }

    public Ticket() {
    }

    public Ticket(Integer tno, Integer empno, String ttype, String leaveplace, String arriveplace, String leavetime, String arrivetime, Integer trno, Double tprice, String tphoto, String explanation, Integer bno) {
        this.tno = tno;
        this.empno = empno;
        this.ttype = ttype;
        this.leaveplace = leaveplace;
        this.arriveplace = arriveplace;
        this.leavetime = leavetime;
        this.arrivetime = arrivetime;
        this.trno = trno;
        this.tprice = tprice;
        this.tphoto = tphoto;
        this.explanation = explanation;
        this.bno = bno;
    }

    public Ticket(Integer tno, Integer empno, String ttype, String leaveplace, String arriveplace, String leavetime, String arrivetime, Integer trno, Double tprice, String tphoto, String explanation, Integer bno, String trname) {
        this.tno = tno;
        this.empno = empno;
        this.ttype = ttype;
        this.leaveplace = leaveplace;
        this.arriveplace = arriveplace;
        this.leavetime = leavetime;
        this.arrivetime = arrivetime;
        this.trno = trno;
        this.tprice = tprice;
        this.tphoto = tphoto;
        this.explanation = explanation;
        this.bno = bno;
        this.trname = trname;
    }
}
