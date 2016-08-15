package com.drivers.manager.service;

import com.drivers.entity.Cadet;
import com.drivers.manager.web.request.CadetPayReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by xhuji on 2016/8/13.
 */
public interface CadetPayService {

    public Cadet findOneById(Long id);

    public Page<Cadet> findAllBySearch(final CadetPayReq request, Pageable pageable);

}
