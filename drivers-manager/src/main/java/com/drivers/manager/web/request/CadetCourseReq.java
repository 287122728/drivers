package com.drivers.manager.web.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xhuji on 2016/8/13.
 */
@Data
public class CadetCourseReq implements Serializable {

    private Long id;

    private String name;

    private String mobile;

    private String weixinNum;

    private String idcardNum;
}
