package com.jxd.termsys.model;

/**
 * @ClassName Transportation
 * @Description TODO
 * @Author gechenyang
 * @Date 2022/8/17
 * @Version 1.0
 */
public class Transportation {
    private Integer trno;
    private String trname;

    public Integer getTrno() {
        return trno;
    }

    public void setTrno(Integer trno) {
        this.trno = trno;
    }

    public String getTrname() {
        return trname;
    }

    public void setTrname(String trname) {
        this.trname = trname;
    }

    public Transportation() {
    }

    public Transportation(Integer trno, String trname) {
        this.trno = trno;
        this.trname = trname;
    }
}
