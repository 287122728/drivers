package com.drivers.manager.web.resource;

import com.drivers.entity.SysManager;
import com.drivers.manager.service.SysManagerService;
import com.drivers.manager.web.interceptor.Validate;
import com.drivers.manager.web.request.SysManagerReq;
import com.drivers.manager.web.request.base.Request;
import com.drivers.manager.web.resource.base.BaseResource;
import com.drivers.manager.web.resource.base.Pager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
 * @version 1.0 2016/8/9
 */
@RestController
@RequestMapping(value = "/sysmanager")
@Slf4j
public class SysManagerResource extends BaseResource{

    @Autowired
    private SysManagerService sysManagerService;

    public ResponseEntity<SysManager> createSysManager(SysManager sysManager){
        if (sysManager.getId() != null){
            return ResponseEntity.badRequest().body(null);
        }
        return null;
//        sysManagerService.save
    }
    @Validate
    @RequestMapping(value = "_search/sysmanagers", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pager<SysManager>> getByPage(SysManagerReq request, int limit, int offset, String sort, String order){
        Pageable pageable = this.toPageable(limit, offset, sort, order);
        Page<SysManager> page = sysManagerService.findByPageSearch(request,pageable);

        Pager<SysManager> content;
        if (page != null){
            content = new Pager<>(page.getContent(),page.getTotalElements());
        }else{
            content = new Pager<>();
        }

        return new ResponseEntity<>(content, HttpStatus.OK);
    }
}
