package com.ssm.web.controller;

import com.ssm.aware.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author quandaoran
 * @date 2019-06-14
 * @description
 */
@Controller
public class TestController {

    @Autowired
    private BeanFactoryUtils beanFactoryUtils;

    @ResponseBody
    @RequestMapping("test")
    public String testAware1() {
        Object targetBean = beanFactoryUtils.getBeanByName("targetBean");
        return targetBean.toString();
    }

    @ResponseBody
    @RequestMapping("test1")
    public String testAware2() {
        return beanFactoryUtils.getEnvironment("jdbc.minIdle");
    }
}
