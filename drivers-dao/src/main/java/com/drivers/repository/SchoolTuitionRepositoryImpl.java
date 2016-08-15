package com.drivers.repository;

import com.drivers.entity.School;
import com.drivers.entity.SchoolTuition;
import com.drivers.jdbc.sql.Select;
import com.drivers.jdbc.sql.Update;
import com.drivers.vo.SchoolTuitionVo;

import java.util.List;

/**
 * Created by xhuji on 2016/8/14.
 */
public class SchoolTuitionRepositoryImpl extends CommonDaoImpl implements SchoolTuitionDao {
    @Override
    public List<SchoolTuitionVo> findSchoolTuition() {
        //Failed to convert request element: org.springframework.beans.ConversionNotSupportedException: Failed to convert property value of type [java.sql.Timestamp] to required type [java.time.ZonedDateTime] for property 'dataCreateDatetime'
//        ,tuition.data_create_datetime,tuition.data_update_datetime
        String sql = "select school.name AS school_name,tuition.* " +
                "FROM school school " +
                "LEFT JOIN school_tuition tuition on school.id = tuition.school_id";
        printSqlLog(sql);
        List<SchoolTuitionVo> result = this.getJdbcTemplate().query(sql,new Object[]{},newAnnotationRowMapper(SchoolTuitionVo.class));
        return result;
    }

//    @Override
//    public Integer update(SchoolTuition schoolTuition) {
//        Update update = new Update(SchoolTuition.class);
//        update.toSQL();
//
//        return null;
//    }
}
