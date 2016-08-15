package com.drivers.manager.web.resource;

import com.drivers.entity.School;
import com.drivers.manager.service.SchoolService;
import com.drivers.manager.web.interceptor.Validate;
import com.drivers.manager.web.request.SchoolReq;
import com.drivers.manager.web.resource.base.BaseResource;
import com.drivers.manager.web.response.base.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springside.modules.mapper.JsonMapper;

import java.io.PrintWriter;
import java.time.ZonedDateTime;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/12
 */
@RestController
@RequestMapping( value = "/schools")
public class SchoolResource extends BaseResource{

    @Autowired
    JsonMapper jsonMapper;
    @Autowired
    private SchoolService service;

    @RequestMapping( method = RequestMethod.GET)
    public Response<School> getSchool(){
        School school = service.findAll();
        return new Response<>(school, HttpStatus.OK);
    }

//    @Validate
    @RequestMapping( value = "/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<School> updateSchool(@PathVariable Long id, SchoolReq request){
        School school = new School();
        BeanUtils.copyProperties(request,school);
        //TODO :放到BaseController 公用
        school.setDataCreator("admin");
        school.setDataUpdater("admin");
        school.setDataUpdateDatetime(ZonedDateTime.now());
        school.setDataStatus(1);


        school = service.saveOrUpdateSchool(school);
        return new Response<>(school,HttpStatus.OK);
    }
}
