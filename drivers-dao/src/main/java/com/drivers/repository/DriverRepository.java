package com.drivers.repository;

import com.drivers.entity.Driver;
import com.drivers.repository.base.JpaSpecificationPagingRepository;

/**
 * Created by xhuji on 2016/8/28.
 */
public interface DriverRepository extends JpaSpecificationPagingRepository<Driver, Long> {
}
