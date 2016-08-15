package com.drivers.repository;

import com.drivers.entity.Cadet;
import com.drivers.entity.School;
import com.drivers.entity.SchoolTuition;
import com.drivers.vo.SchoolTuitionVo;

import java.util.List;

/**
 * Created by xhuji on 2016/8/14.
 */
public interface SchoolTuitionDao {

    public List<SchoolTuitionVo> findSchoolTuition();

//    public Integer update(SchoolTuition schoolTuition);
}
