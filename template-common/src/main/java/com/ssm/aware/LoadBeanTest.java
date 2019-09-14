package com.ssm.aware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author quandaoran
 * @date 2019-06-30
 * @description
 */
public class LoadBeanTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("common-context.xml");
        Object bean = context.getBean("targetBean");
        System.out.println(bean.toString());
    }
}
