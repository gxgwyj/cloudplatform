package com.xinguoren.coolpen.cloud.web.spring.utils;

import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.IdGenerator;
import org.springframework.util.JdkIdGenerator;
import org.springframework.util.SimpleIdGenerator;

/**
 * Created by Lenovo on 2017/2/20.
 */
public class IdGeneratorTest {
    public static void main(String[] args) {
//        IdGenerator idGenerator = new SimpleIdGenerator();
        IdGenerator idGenerator;
        idGenerator = new JdkIdGenerator();
        System.out.println(idGenerator.generateId());
        idGenerator = new AlternativeJdkIdGenerator();
        System.out.println(idGenerator.generateId());
    }
}
