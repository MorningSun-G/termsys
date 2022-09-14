package com.jxd.termsys.model;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/15
 * @Version 1.0
 */
public class Emp {
    private Integer empno;
    private String ename;
    private String epwd;
    private String esex;
    private String etel;
    private int deptno;
    private Integer eid;
    private String dname;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpwd() {
        return epwd;
    }

    public void setEpwd(String epwd) {
        this.epwd = epwd;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Emp() {
    }

    public Emp(Integer empno, String ename, String epwd, String esex, String etel, int deptno, Integer eid, String dname) {
        this.empno = empno;
        this.ename = ename;
        this.epwd = epwd;
        this.esex = esex;
        this.etel = etel;
        this.deptno = deptno;
        this.eid = eid;
        this.dname = dname;
    }
}
