package com.ssm.processor.component;

import com.ssm.processor.Rule;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Map;

/**
 * @author quandaoran
 * @date 2019-10-07
 * @description
 */
public abstract class BaseObject<Param, Result> {

    /**
     * 基础参数  根据此参数收集 具体对象
     */
    private String MqContent;

    /**
     * 最终的要处理的结果
     */
    private Object object;

    /**
     * 该对象需要执行的规则
     */
    @Setter
    private LinkedList<Rule> rules;

    /**
     * 最后执行的结果集
     */
    @Setter
    private Map<Rule, Result> ruleResultMap;


    /**
     * 获得结果
     *
     * @param MqContent
     */
    public abstract Object getResult(String MqContent);

    /**
     * 获得配置规则
     */
    public void getRules() {
        throw new RuntimeException("没有覆盖获得规则方法");
    }


    public Map<Rule, Result> getRuleResultMap() {
        return this.ruleResultMap;
    }


}
