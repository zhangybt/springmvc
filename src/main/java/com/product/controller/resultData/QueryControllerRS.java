package com.product.controller.resultData;

/**
 * Created by zhangybt on 2017/5/23.
 */
public class QueryControllerRS extends BaseControllerRS {

    private int begin = 0;
    private int num = 0;
    private int totalnum = 0;

    public QueryControllerRS(boolean success, String message, Object data, int begin, int num, int totalnum) {
        super(success, message, data);
        this.setBegin(begin);
        this.setNum(num);
        this.setTotalnum(totalnum);
    }

    public QueryControllerRS(boolean success, int code, String message, Object data, int begin, int num, int totalnum) {
        super(success, code, message, data);
        this.setBegin(begin);
        this.setNum(num);
        this.setTotalnum(totalnum);
    }

    public int getBegin() {
        return this.begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTotalnum() {
        return this.totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }
}
