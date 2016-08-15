package com.drivers.manager.web.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/8/13.
 */
@Data
public class CadetCourseResp {

    //--------------学员基本信息
    private Long id;

    private String username;

    private String password;

    private String name;

    private Integer age;

    private String phone;

    private String weixinNum;

    private String idcardNum;

    //  学员课程情况
    private Long cadetCourseId;

    private Integer course;

    private String dataUpdater;

    private ZonedDateTime dataUpdateDatetime;
}
