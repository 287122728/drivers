package com.drivers.repository.base;

import com.drivers.jdbc.SimpleJdbcSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/12
 */
public class CommonDaoImpl extends SimpleJdbcSupport {

    @PersistenceContext
    protected EntityManager entityManager;


}