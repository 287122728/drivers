package com.drivers.manager.service;

import com.drivers.entity.Driver;
import com.drivers.manager.web.request.DriverReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by xhuji on 2016/8/28.
 */
public interface DriverService {
    public Page<Driver> findAllBySearch(final DriverReq request, Pageable pageable);
}
