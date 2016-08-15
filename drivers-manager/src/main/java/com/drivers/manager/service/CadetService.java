package com.drivers.manager.service;

import com.drivers.entity.Cadet;
import com.drivers.manager.web.request.CadetReq;
import com.drivers.manager.web.request.base.Request;
import com.drivers.manager.web.response.CadetResp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/11
 */
public interface CadetService {

    public Cadet save(Cadet cadet);

    public Page<Cadet> findAllBySearch(final CadetReq request, Pageable pageable);
}
