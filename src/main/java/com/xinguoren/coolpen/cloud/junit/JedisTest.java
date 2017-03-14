package com.xinguoren.coolpen.cloud.junit;

import com.xinguoren.coolpen.cloud.web.api.BlogService;
import com.xinguoren.coolpen.cloud.web.api.model.Blog;
import com.xinguoren.coolpen.cloud.web.model.product.ProductCategory;
import com.xinguoren.coolpen.cloud.web.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Created by Lenovo on 2017/3/4.
 */
public class JedisTest {


    /**
     * 测试Jedis
     */
    @Test
    public void jedisSingleTest(){
        ApplicationContext ctx = SpringContainer.getCtx();
        JedisPool pool = ctx.getBean(JedisPool.class);
        Jedis jedis = pool.getResource();
        String result = jedis.set("id","10086");
        System.out.println(result);
        jedis.close();
        pool.close();
    }
    @Test
    public void dubboServiceTest(){
        ApplicationContext ctx = SpringContainer.getCtx();
        BlogService blogService = ctx.getBean(BlogService.class);
        List<Blog> list = blogService.getAllBlogs();
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }

    @Test
    public void springServiceTest(){
        ApplicationContext ctx1 = SpringContainer.getCtx();
        ApplicationContext ctx2 = SpringContainer.getCtx();
        System.out.println(ctx1 == ctx2);
        ProductService productService = ctx1.getBean(ProductService.class);
        List<ProductCategory> list = productService.findAllCategory();
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
}
