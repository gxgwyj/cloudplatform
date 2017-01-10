package com.xinguoren.coolpen.cloud.web.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */
public class Page<T> implements Serializable {
    protected static final long serialVersionUID = 7015022131994654262L;
    protected int pageSize = 10;    //每页数量
    protected int recordTotal; //查询总数
    protected int start;       //本页开始条码
    protected int end;         //本页结束条码
    protected int pageTotal;   //总页数
    protected int pageNo;      //当前页
    protected List<T> records;
    protected String turnPageUrl;
    protected boolean turnPageFlag;

    public Page() {
        this.pageNo = 1;
    }

    public List<T> getRecords() {
        return records;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getRecordTotal() {
        return recordTotal;
    }

    public void setRecordTotal(int recordTotal) {
        this.recordTotal = recordTotal;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public String getTurnPageUrl() {
        return turnPageUrl;
    }

    public void setTurnPageUrl(String turnPageUrl) {
//            this.turnPageUrl = turnPageUrl+"?"+Constants.TURN_PAGE;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public boolean isTurnPageFlag() {
        return turnPageFlag;
    }

    public void setTurnPageFlag(boolean turnPageFlag) {
        this.turnPageFlag = turnPageFlag;
    }

    public void initTurnPageUrl(String url) {
//            if(url!=null){
//                if(url.contains("?")){
//                    this.turnPageUrl = url+"&"+Constants.TURN_PAGE+"="+Constants.TURN_PAGE;
//                }else{
//                    this.turnPageUrl = url+"?"+Constants.TURN_PAGE+"="+Constants.TURN_PAGE;
//                }
//            }
    }


}
