package com.drivers.manager.web.resource;

import com.drivers.entity.Cadet;
import com.drivers.entity.CadetPay;
import com.drivers.manager.service.CadetPayService;
import com.drivers.manager.web.interceptor.Validate;
import com.drivers.manager.web.request.CadetPayReq;
import com.drivers.manager.web.request.CadetReq;
import com.drivers.manager.web.resource.base.BaseResource;
import com.drivers.manager.web.resource.base.Pager;
import com.drivers.manager.web.response.CadetPayResp;
import com.drivers.manager.web.response.CadetResp;
import com.drivers.manager.web.response.base.Response;
import com.drivers.manager.web.response.base.StatusCode;
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
 * Created by xhuji on 2016/8/13.
 */
@RestController
@RequestMapping("/cadetpays")
public class CadetPayResource extends BaseResource {
    @Autowired
    private CadetPayService cadetPayService;
    @Validate
    @RequestMapping(value = "_search/cadetpays", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Pager<CadetPayResp>> getByPage(CadetPayReq request, int limit, int offset, String sort, String order){
        Pageable pageable = this.toPageable(limit, offset, sort, order);
        Page<Cadet> cadets = cadetPayService.findAllBySearch(request,pageable);
        List<CadetPayResp> cadetResps = new ArrayList<>();
        for(Cadet cadet : cadets.getContent()){
            CadetPayResp cadetPayResp = new CadetPayResp();
            BeanUtils.copyProperties(cadet,cadetPayResp);
            if (cadet.getCadetPay() != null){
                cadetPayResp.setCadetPayId(cadet.getCadetPay().getId());
                cadetPayResp.setPayStatus(cadet.getCadetPay().getPayStatus());
            }
            cadetResps.add(cadetPayResp);
        }

        Pager<CadetPayResp> result = new Pager<>(cadetResps,cadets.getTotalElements());

        return new Response<>(result, StatusCode.OK);
    }
}
