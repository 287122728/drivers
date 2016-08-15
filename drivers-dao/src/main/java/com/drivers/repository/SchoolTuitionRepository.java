package com.drivers.repository;

import com.drivers.entity.SchoolTuition;
import com.drivers.repository.base.JpaSpecificationPagingRepository;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
public interface SchoolTuitionRepository extends JpaSpecificationPagingRepository<SchoolTuition, Long>,SchoolTuitionDao{
}
