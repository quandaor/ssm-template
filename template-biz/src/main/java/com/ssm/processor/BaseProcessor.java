package com.ssm.processor;

import com.ssm.processor.component.BaseObject;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * @author quandaoran
 * @date 2019-10-07
 * @description 基础处理器
 */
@Component
public class BaseProcessor {
    /**
     * 基础对象集合
     * 根据不同对象收集不同基础参数
     */
    @Setter
    private LinkedList<BaseObject> objects;

    private void aVoid() {
        Object result = objects.get(0).getResult("123");

    }


    /**
     * 基础
     */
    @Setter
    private LinkedList<BaseComponent> components;


    // TODO: 2019-10-07 对象分流器

    // TODO: 2019-10-07  执行任务

    // TODO: 2019-10-07 前置处理器

    // TODO: 2019-10-07 后置处理器
}
