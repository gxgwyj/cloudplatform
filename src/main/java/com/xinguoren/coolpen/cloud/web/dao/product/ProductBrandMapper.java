package com.xinguoren.coolpen.cloud.web.dao.product;


import com.xinguoren.coolpen.cloud.web.model.product.ProductBrand;

import java.util.List;

public interface ProductBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductBrand record);

    int insertSelective(ProductBrand record);

    ProductBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductBrand record);

    int updateByPrimaryKey(ProductBrand record);

    List<ProductBrand> selectAll();
}