package com.ssm.event;

import lombok.Getter;
import lombok.Setter;

/**
 * @author quandaoran
 * @date 2019-06-12
 * @description 事件实体
 */
public class BaseEvent {
    @Setter
    @Getter
    private Object source;

    public BaseEvent(Object source) {
        this.source = source;
    }
}
