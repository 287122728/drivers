package com.drivers.repository;

import com.drivers.entity.SysManager;
import com.drivers.repository.base.JpaSpecificationPagingRepository;

import java.util.Optional;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
public interface SysManagerRepository extends JpaSpecificationPagingRepository<SysManager, Long> {

    public Optional<SysManager> findOneByUsername(String username);
}
