package com.ssm.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author quandaoran
 * @date 2019-06-12
 * @description 监听器
 */
@Component
public class BaseListener {

    public volatile AtomicInteger index = new AtomicInteger(0);

    @EventListener
    public void onApplicationEvent(BaseEvent baseEvent) {

        System.out.println(baseEvent.getSource() + ":" + index.getAndIncrement());

    }
}
