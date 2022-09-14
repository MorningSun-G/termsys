package com.jxd.termsys.model;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/17
 * @Version 1.0
 */
public class Dept {
    private Integer deptno;
    private String dname;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Dept() {
    }

    public Dept(Integer deptno, String dname) {
        this.deptno = deptno;
        this.dname = dname;
    }
}
