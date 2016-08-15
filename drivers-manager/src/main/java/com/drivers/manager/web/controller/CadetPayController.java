package com.drivers.manager.web.controller;

import com.drivers.entity.Cadet;
import com.drivers.manager.service.CadetPayService;
import com.drivers.manager.web.request.CadetPayReq;
import com.drivers.manager.web.resource.base.Pager;
import com.drivers.manager.web.response.CadetPayResp;
import com.drivers.manager.web.response.base.Response;
import com.drivers.manager.web.response.base.StatusCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/8/14.
 */
@Controller
public class CadetPayController {

    @Autowired
    private CadetPayService service;

    @RequestMapping(value = "/cadetpay/{id}", method = RequestMethod.GET)
    public String getByPage(@PathVariable Long id, Map map){
        Cadet cadet = service.findOneById(id);
        map.put("cadet",cadet);
        return "cadet/pay";
    }
}
