package com.drivers.manager.web.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
public class CadetReq implements Serializable{

    private Long id;

    private String name;

    private String mobile;

    private String weixinNum;

    private String idcardNum;
    /**
     * 数据创建时间->学员注册时间
     */
    private ZonedDateTime dataCreateDatetime;
}
