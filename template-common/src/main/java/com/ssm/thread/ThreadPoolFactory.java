package com.ssm.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author quandaoran
 * @date 2019-09-02
 * @description
 */
@Component
public class ThreadPoolFactory {


    private ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Core-Thread-Manager-%d").setDaemon(true).build();


}
