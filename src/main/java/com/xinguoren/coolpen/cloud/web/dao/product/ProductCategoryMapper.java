package com.xinguoren.coolpen.cloud.web.dao.product;


import com.xinguoren.coolpen.cloud.web.model.product.ProductCategory;

import java.util.List;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);

    List<ProductCategory> selectAll();
}