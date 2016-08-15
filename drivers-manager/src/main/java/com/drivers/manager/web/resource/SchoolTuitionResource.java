package com.drivers.manager.web.resource;

import com.drivers.entity.SchoolTuition;
import com.drivers.manager.service.SchoolTuitionService;
import com.drivers.manager.web.resource.base.Pager;
import com.drivers.manager.web.response.base.Response;
import com.drivers.vo.SchoolTuitionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xhuji on 2016/8/13.
 */
@RestController
@RequestMapping( value = "schooltuitions")
public class SchoolTuitionResource {

    @Autowired
    private SchoolTuitionService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<SchoolTuition> updateSchoolTuition(@PathVariable Long id, SchoolTuition schoolTuition){
        //TODO 当前登录用户
        schoolTuition.setDataUpdater("admin");
        SchoolTuition i = service.update(schoolTuition);
        return new Response<>(i, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<SchoolTuitionVo>> getByPage(){
        List<SchoolTuitionVo> schoolTuitions = service.findAll();
        return new Response<>(schoolTuitions, HttpStatus.OK);
    }
}
