package com.drivers.manager.service.impl;

import com.drivers.entity.School;
import com.drivers.manager.service.SchoolService;
import com.drivers.repository.SchoolRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/12
 */
@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolRepository repository;

    @Transactional(readOnly = true)
    @Override
    public School findAll() {
        List<School> schools = repository.findAll();
        if (CollectionUtils.isNotEmpty(schools)){
            return  schools.get(0);
        }else {
            //TODO ：抛出异常
            return null;
        }
    }

    @Override
    public School saveOrUpdateSchool(School school) {
        return repository.save(school);
    }
}
