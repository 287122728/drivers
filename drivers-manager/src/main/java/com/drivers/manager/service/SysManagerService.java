package com.drivers.manager.service;

import com.drivers.entity.SysManager;
import com.drivers.manager.web.request.SysManagerReq;
import com.drivers.manager.web.request.base.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
public interface SysManagerService {

    public Page<SysManager> findByPageSearch(final SysManagerReq request, Pageable pageable);
}
