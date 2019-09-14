package com.ssm.aware;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author quandaoran
 * @date 2019-06-14
 * @description
 */
@ToString
public class TargetBean implements InitializingBean, DisposableBean {

    private String name;

    private String code;

    public TargetBean(String name, String code) {
        this.name = name;
        this.code = code;
        System.out.println("构造方法执行了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean执行了");
    }

    public void init() {
        System.out.println("init");
    }

    public void destroy() {
        System.out.println("destroy====");
    }
}

