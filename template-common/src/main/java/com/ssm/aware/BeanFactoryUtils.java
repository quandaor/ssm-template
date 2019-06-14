package com.ssm.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author quandaoran
 * @date 2019-06-14
 * @description aware 的相关钩子接口
 */
public class BeanFactoryUtils implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
