package com.drivers.manager.web.controller;

import com.drivers.entity.School;
import com.drivers.entity.SysManager;
import com.drivers.manager.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/8
 */
@Controller
public class RouteController {

    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(SysManager sysManager,HttpServletRequest request){
        if (true){
            request.getSession().setAttribute("username",sysManager.getUsername());
        }
        return "redirect:/index";
    }

    @RequestMapping(value = {"/index","/dashboard"}, method = RequestMethod.GET)
    public String index(){
        return "dashboard";
    }

    /******************************************************************************************************
     * 系统管理员
     *
     *************************************************************************************************/
    @RequestMapping(value = "/sysmanager", method = RequestMethod.GET)
    public String sysmanager(){
        return "sysmanager/sysmanager";
    }

    /******************************************************************************************************
     * 驾校管理
     *
     *************************************************************************************************/
//    @Autowired private SchoolService service;
//    @RequestMapping(value = "/school", method = RequestMethod.GET)
//    public String school(Map<String, Object> model){
//        School school = service.findAll();
//        model.put("school", school);
//        return "school/school";
//    }

    @RequestMapping(value = "/school", method = RequestMethod.GET)
    public String school(){
        return "school/school";
    }
    @RequestMapping(value = "/schooltuition", method = RequestMethod.GET)
    public String schoolTuition(){
        return "school/tuition";
    }
    /******************************************************************************************************
     * 学员管理
     *
     *************************************************************************************************/
    @RequestMapping(value = "/cadet", method = RequestMethod.GET)
    public String cadet(){
        return "cadet/cadet";
    }

    @RequestMapping(value = "/cadetpay", method = RequestMethod.GET)
    public String cadetpay(){
        return "cadet/pay";
    }

    @RequestMapping(value = "/cadetcourse", method = RequestMethod.GET)
    public String cadetcourse(){
        return "cadet/course";
    }
    /******************************************************************************************************
     * 投诉建议
     *
     *************************************************************************************************/
    @RequestMapping(value = "/suggestion", method = RequestMethod.GET)
    public String suggestion(){
        return "suggestion/suggestion";
    }
}
