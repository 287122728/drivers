package com.drivers.manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xhuji on 2016/8/10.
 */
@Controller
public class TestController {
    @RequestMapping(value = "page-activity", method = RequestMethod.GET)
    public String pageActivity(){
        return "test/page-activity";
    }

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public String menu(){
        return "common/menu";
    }

    @RequestMapping(value = "menu2", method = RequestMethod.GET)
    public String menu2(){
        return "common/menu2";
    }
}
