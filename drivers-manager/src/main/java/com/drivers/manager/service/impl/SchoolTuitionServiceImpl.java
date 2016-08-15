package com.drivers.manager.service.impl;

import com.drivers.entity.SchoolTuition;
import com.drivers.manager.service.SchoolTuitionService;
import com.drivers.repository.SchoolTuitionRepository;
import com.drivers.vo.SchoolTuitionVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhuji on 2016/8/13.
 */
@Service
@Transactional
public class SchoolTuitionServiceImpl implements SchoolTuitionService {
    @Autowired
    private SchoolTuitionRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<SchoolTuitionVo> findAll() {
//        List<SchoolTuition> schoolTuitions = repository.findAll();
        List<SchoolTuitionVo> schoolTuitions = repository.findSchoolTuition();
//        if (CollectionUtils.isNotEmpty(schoolTuitions)){
//            return  schoolTuitions.get(0);
//        }
        // TODO : 抛出异常
        return schoolTuitions;
    }

    @Override
    public SchoolTuition update(SchoolTuition schoolTuition) {
        return repository.save(schoolTuition);
    }
}
