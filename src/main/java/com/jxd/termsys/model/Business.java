package com.jxd.termsys.model;

/**
 * @ClassName Business
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/21
 * @Version 1.0
 */
public class Business {
    private Integer bno;
    private Integer empno;
    private String leavetime;
    private String arrivetime;
    private Double bdate;
    private String explanation;
    private String btime; //创建时间
    private Double allowance; //补助金额
    private Double rmbtotal; //报销总金额
    private Integer bstate; //提交到了哪里
    private String ename; //员工姓名

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
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

    public Double getBdate() {
        return bdate;
    }

    public void setBdate(Double bdate) {
        this.bdate = bdate;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    public Double getRmbtotal() {
        return rmbtotal;
    }

    public void setRmbtotal(Double rmbtotal) {
        this.rmbtotal = rmbtotal;
    }

    public Integer getBstate() {
        return bstate;
    }

    public void setBstate(Integer bstate) {
        this.bstate = bstate;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Business() {
    }

    public Business(Integer bno, Integer empno, String leavetime, String arrivetime, Double bdate, String explanation, String btime, Double allowance, Double rmbtotal, Integer bstate, String ename) {
        this.bno = bno;
        this.empno = empno;
        this.leavetime = leavetime;
        this.arrivetime = arrivetime;
        this.bdate = bdate;
        this.explanation = explanation;
        this.btime = btime;
        this.allowance = allowance;
        this.rmbtotal = rmbtotal;
        this.bstate = bstate;
        this.ename = ename;
    }
}
