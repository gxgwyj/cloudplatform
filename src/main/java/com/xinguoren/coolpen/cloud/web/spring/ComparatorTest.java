package com.xinguoren.coolpen.cloud.web.spring;

import org.springframework.util.comparator.BooleanComparator;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ComparatorTest {
    public static void main(String[] args) {
        BooleanComparator booleanComparator = new BooleanComparator(true);
        boolean result = booleanComparator.equals(true);
        System.out.println(result);
    }
}
