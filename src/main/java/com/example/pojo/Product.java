package com.example.pojo;

public class Product {
    private Integer pid;
    private String pname;
    private Float pprice;
    private Integer pnum;//对象类型默认初始化null,初始化0可能会是有实际意义的值

    public Product() {
    }

    public Product(Integer pid, String pname, Float pprice, Integer pnum) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.pnum = pnum;
    }

    /**
     * 获取
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取
     * @return pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * 设置
     * @param pname
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 获取
     * @return pprice
     */
    public Float getPprice() {
        return pprice;
    }

    /**
     * 设置
     * @param pprice
     */
    public void setPprice(Float pprice) {
        this.pprice = pprice;
    }

    /**
     * 获取
     * @return pnum
     */
    public Integer getPnum() {
        return pnum;
    }

    /**
     * 设置
     * @param pnum
     */
    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public String toString() {
        return "Product{pid = " + pid + ", pname = " + pname + ", pprice = " + pprice + ", pnum = " + pnum + "}";
    }
}
