package com.xinguoren.coolpen.cloud.web.model.product;

public class ProductMain {
    private Long id;

    private String pName;

    private Double pPrice;

    private String pCode;

    private Long pBrand;

    private Long pCategory;

    private String pComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Double getpPrice() {
        return pPrice;
    }

    public void setpPrice(Double pPrice) {
        this.pPrice = pPrice;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode == null ? null : pCode.trim();
    }

    public Long getpBrand() {
        return pBrand;
    }

    public void setpBrand(Long pBrand) {
        this.pBrand = pBrand;
    }

    public Long getpCategory() {
        return pCategory;
    }

    public void setpCategory(Long pCategory) {
        this.pCategory = pCategory;
    }

    public String getpComment() {
        return pComment;
    }

    public void setpComment(String pComment) {
        this.pComment = pComment == null ? null : pComment.trim();
    }
}