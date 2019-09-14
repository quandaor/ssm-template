package com.ssm.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author quandaoran
 * @date 2019-09-02
 * @description
 */
@Component
public class ThreadManager {


    private ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Core-Thread-Manager-%d").setDaemon(true).build();

    private ExecutorService executorService = new ThreadPoolExecutor(4, 8, 2, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(1000), threadFactory);


}
