package com.ssm.web.controller;

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

    @ResponseBody
    @RequestMapping("/1")
    public String index(){
        return "index.html";
    }
}
