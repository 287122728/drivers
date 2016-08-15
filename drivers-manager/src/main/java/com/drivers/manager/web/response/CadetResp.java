package com.drivers.manager.web.response;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/11
 */
@Data
public class CadetResp {
    //--------------学员基本信息
    private Long id;

    private String username;

    private String password;

    private String name;

    private Integer age;

    private String phone;

    private String weixinNum;

    private String idcardNum;

    private String dataUpdater;

    private ZonedDateTime dataCreateDatetime;

    private Integer dataStatus;

    //  学员缴费信息
    private Long cadetPayId;

    private Integer payStatus;

    //  学员课程情况
    private Long cadetCourseId;

    private Integer course;
}
