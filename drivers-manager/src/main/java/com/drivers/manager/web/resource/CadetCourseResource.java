package com.drivers.manager.web.resource;

import com.drivers.entity.Cadet;
import com.drivers.manager.service.CadetCourseService;
import com.drivers.manager.service.CadetPayService;
import com.drivers.manager.web.interceptor.Validate;
import com.drivers.manager.web.request.CadetCourseReq;
import com.drivers.manager.web.request.CadetPayReq;
import com.drivers.manager.web.resource.base.BaseResource;
import com.drivers.manager.web.resource.base.Pager;
import com.drivers.manager.web.response.CadetCourseResp;
import com.drivers.manager.web.response.CadetPayResp;
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
@RequestMapping("/cadetcourses")
public class CadetCourseResource extends BaseResource {
    @Autowired
    private CadetCourseService cadetCourseService;
    @Validate
    @RequestMapping(value = "_search/cadetcourses", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Pager<CadetCourseResp>> getByPage(CadetCourseReq request, int limit, int offset, String sort, String order){
        Pageable pageable = this.toPageable(limit, offset, sort, order);
        Page<Cadet> cadets = cadetCourseService.findAllBySearch(request,pageable);
        List<CadetCourseResp> cadetPayResps = new ArrayList<>();
        for(Cadet cadet : cadets.getContent()){
            CadetCourseResp cadetCourseResp = new CadetCourseResp();
            BeanUtils.copyProperties(cadet,cadetCourseResp);
            if (cadet.getCadetCourse() != null){
                cadetCourseResp.setCadetCourseId(cadet.getCadetCourse().getId());
                cadetCourseResp.setCourse(cadet.getCadetCourse().getCourse());
            }
            cadetPayResps.add(cadetCourseResp);
        }

        Pager<CadetCourseResp> result = new Pager<>(cadetPayResps,cadets.getTotalElements());

        return new Response<>(result, StatusCode.OK);
    }
}
