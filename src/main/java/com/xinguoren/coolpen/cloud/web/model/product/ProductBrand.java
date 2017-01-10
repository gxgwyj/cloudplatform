package com.xinguoren.coolpen.cloud.web.model.product;

import java.util.Date;

public class ProductBrand {
    private Long id;

    private String bName;

    private String bPlace;

    private String bCode;

    private Date createDate;

    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public String getbPlace() {
        return bPlace;
    }

    public void setbPlace(String bPlace) {
        this.bPlace = bPlace == null ? null : bPlace.trim();
    }

    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode == null ? null : bCode.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}