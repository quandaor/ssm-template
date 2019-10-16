package com.ssm.processor;

import org.springframework.stereotype.Component;

/**
 * @param <Request>  请求参数泛型
 * @param <Response> 返回参数泛型
 * @author quandaoran
 * @date 2019-10-07
 * @description 基础组件
 */
@Component
public abstract class BaseComponent<Request, Response> {

    /**
     * 参数检查
     *
     * @param req
     */
    public abstract void checkParam(Request req);


    /**
     * 执行组件业务
     *
     * @param res
     * @return
     */
    public abstract Response doBusiness(Request res);

}
