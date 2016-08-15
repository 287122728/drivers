package com.drivers.manager.service;

import com.drivers.entity.School;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/12
 */
public interface SchoolService {

    public School findAll();

    public School saveOrUpdateSchool(School school);
}
