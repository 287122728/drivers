package com.drivers.manager.service;

import com.drivers.entity.SchoolTuition;
import com.drivers.vo.SchoolTuitionVo;

import java.util.List;

/**
 * Created by xhuji on 2016/8/13.
 */
public interface SchoolTuitionService {

    public List<SchoolTuitionVo> findAll();

    public SchoolTuition update(SchoolTuition schoolTuition);
}
