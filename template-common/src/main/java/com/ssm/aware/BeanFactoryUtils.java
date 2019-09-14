package com.ssm.aware;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author quandaoran
 * @date 2019-06-14
 * @description aware 的相关钩子接口
 */
@Component
public class BeanFactoryUtils implements BeanFactoryAware, BeanNameAware, ApplicationContextAware, EnvironmentAware {

    private BeanFactory beanFactory;

    private String beanName;

    private ApplicationContext applicationContext;

    private Environment environment;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public Object getBeanByName(@NotNull String beanName) {
        return beanFactory.getBean(beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getEnvironment(String propertyName) {
        String property = this.environment.getProperty(propertyName);
        return property;
    }
}
