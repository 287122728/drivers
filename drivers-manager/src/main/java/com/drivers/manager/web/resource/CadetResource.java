package com.drivers.manager.web.resource;

import com.drivers.entity.Cadet;
import com.drivers.manager.service.CadetService;
import com.drivers.manager.web.interceptor.Validate;
import com.drivers.manager.web.request.CadetReq;
import com.drivers.manager.web.resource.base.BaseResource;
import com.drivers.manager.web.resource.base.Pager;
import com.drivers.manager.web.response.CadetResp;
import com.drivers.manager.web.response.base.Response;
import com.drivers.manager.web.response.base.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/11
 */
@RestController
@RequestMapping(value = "/cadets")
@Slf4j
public class CadetResource extends BaseResource{

    @Autowired
    private CadetService service;

    @Validate
    @RequestMapping(value = "_search/cadets", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Pager<CadetResp>> getByPage(CadetReq request, int limit, int offset, String sort, String order){
        Pageable pageable = this.toPageable(limit, offset, sort, order);
        Page<Cadet> cadets = service.findAllBySearch(request,pageable);
        List<CadetResp> cadetResps = new ArrayList<>();
        for(Cadet cadet : cadets.getContent()){
            CadetResp cadetResp = new CadetResp();
            BeanUtils.copyProperties(cadet,cadetResp); //TODO :如果是泛型有bug 待确认
            if (cadet.getCadetPay() != null){
                cadetResp.setCadetPayId(cadet.getCadetPay().getId());
                cadetResp.setPayStatus(cadet.getCadetPay().getPayStatus());
            }
            if (cadet.getCadetCourse() != null){
                cadetResp.setCadetCourseId(cadet.getCadetCourse().getId());
                cadetResp.setCourse(cadet.getCadetCourse().getCourse());
            }
            cadetResps.add(cadetResp);
        }

        Pager<CadetResp> result = new Pager<>(cadetResps,cadets.getTotalElements());

        return new Response<>(result, StatusCode.OK);
    }
}
