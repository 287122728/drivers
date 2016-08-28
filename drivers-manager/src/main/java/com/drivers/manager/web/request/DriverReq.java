package com.drivers.manager.web.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xhuji on 2016/8/28.
 */
@Data
public class DriverReq implements Serializable {

    private String name;

    private String phone;

    private String model;

}
