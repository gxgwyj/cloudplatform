package com.xinguoren.coolpen.cloud.web.service;

import com.xinguoren.coolpen.cloud.web.dao.product.ProductBrandMapper;
import com.xinguoren.coolpen.cloud.web.dao.product.ProductCategoryMapper;
import com.xinguoren.coolpen.cloud.web.dao.product.ProductMainMapper;
import com.xinguoren.coolpen.cloud.web.dao.product.UserMapper;
import com.xinguoren.coolpen.cloud.web.model.product.ProductBrand;
import com.xinguoren.coolpen.cloud.web.model.product.ProductCategory;
import com.xinguoren.coolpen.cloud.web.model.product.ProductMain;
import com.xinguoren.coolpen.cloud.web.model.product.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */
@Service
public class ProductService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;
    @Autowired
    ProductBrandMapper productBrandMapper;
    @Autowired
    ProductMainMapper productMainMapper;
    @Autowired
    UserMapper userMapper;


    /**
     * 类别保存
     *
     * @param productCategory
     */
    public void saveCategory(ProductCategory productCategory) {
        productCategoryMapper.insert(productCategory);
        User user = new User();
        user.setName("张强");
        user.setCode("001");
        user.setTel("15135158097");
        userMapper.insert(user);
    }


    /**
     * 类别列表
     *
     * @return
     */
    public List<ProductCategory> findAllCategory() {
        return productCategoryMapper.selectAll();
    }

    /**
     * 品牌保存
     *
     * @param productBrand
     */
    @Transactional
    public void saveBrand(ProductBrand productBrand) {
//        saveUser();
        User user = new User();
        user.setName("张丽");
        user.setCode("002");
        user.setTel("15135158098");
        userMapper.insert(user);
        Date date = new Date();
        productBrand.setCreateDate(date);
        productBrand.setUpdateDate(date);
        productBrandMapper.insert(productBrand);

    }


    /**
     * 品牌列表
     *
     * @return
     */
    public List<ProductBrand> findAllBrand() {
        return productBrandMapper.selectAll();
    }

    /**
     * 商品保存
     *
     * @param productMain
     */
    public void saveProduct(ProductMain productMain) {
        productMainMapper.insert(productMain);
    }


    /**
     * 商品列表
     *
     * @return
     */
    public List<ProductMain> findAllProduct() {
        return productMainMapper.selectAll();
    }

    /**
     * 事务测试
     *
     * @return
     */
    @Transactional
    public void txAdd(ProductCategory productCategory,ProductBrand productBrand) {
        this.saveCategory(productCategory);
        this.saveBrand(productBrand);
    }

}
