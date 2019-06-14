package com.ssm.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author quandaoran
 * @date 2019-06-12
 * @description
 */
@Component
public class BasePublisher {

    @Autowired
    private ApplicationEventPublisher publisher;


    public void publish(Object o) {
        publisher.publishEvent(new BaseEvent(o));
    }

}
