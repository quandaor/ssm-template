package com.ssm.web.controller;

import com.ssm.event.BasePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author quandaoran
 * @date 2019-06-09
 * @description
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private BasePublisher publisher;

    @ResponseBody
    @RequestMapping("/1")
    public String index(){
        return "index.html";
    }

    @ResponseBody
    @RequestMapping("/2")
    public String publish() {
        publisher.publish("1234");
        return "OK";
    }
}
