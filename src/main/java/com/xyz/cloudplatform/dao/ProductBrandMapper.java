package com.xyz.cloudplatform.dao;


import com.xyz.cloudplatform.model.ProductBrand;

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