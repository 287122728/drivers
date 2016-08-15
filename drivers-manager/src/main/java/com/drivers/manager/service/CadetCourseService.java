package com.drivers.manager.service;

import com.drivers.entity.Cadet;
import com.drivers.manager.web.request.CadetCourseReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by xhuji on 2016/8/13.
 */
public interface CadetCourseService {

    public Page<Cadet> findAllBySearch(final CadetCourseReq request, Pageable pageable);
}
