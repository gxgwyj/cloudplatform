package com.xinguoren.coolpen.cloud.web.dao.product;


import com.xinguoren.coolpen.cloud.web.model.product.ProductMain;

import java.util.List;

public interface ProductMainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductMain record);

    int insertSelective(ProductMain record);

    ProductMain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductMain record);

    int updateByPrimaryKey(ProductMain record);

    List<ProductMain> selectAll();
}