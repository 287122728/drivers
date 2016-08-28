package com.drivers.manager.web.resource;

import com.drivers.entity.Driver;
import com.drivers.manager.service.DriverService;
import com.drivers.manager.web.interceptor.Validate;
import com.drivers.manager.web.request.DriverReq;
import com.drivers.manager.web.resource.base.BaseResource;
import com.drivers.manager.web.resource.base.Pager;
import com.drivers.manager.web.response.base.Response;
import com.drivers.manager.web.response.base.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xhuji on 2016/8/28.
 */
@RestController
@RequestMapping(value = "/drivers")
@Slf4j
public class DriverResource extends BaseResource{

    @Autowired
    private DriverService service;

    @Validate
    @RequestMapping(value = "_search/drivers", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Pager<Driver>> getByPage(DriverReq request, int limit, int offset, String sort, String order){
        Pageable pageable = this.toPageable(limit, offset, sort, order);
        Page<Driver> cadets = service.findAllBySearch(request,pageable);

        Pager<Driver> result = new Pager<>(cadets.getContent(),cadets.getTotalElements());
        return new Response<>(result, StatusCode.OK);
    }
}
