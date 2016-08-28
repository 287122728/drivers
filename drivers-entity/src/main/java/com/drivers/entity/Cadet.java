package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
@Entity
@Table(name = "cadet")
@Data
@DynamicInsert
@DynamicUpdate
public class Cadet extends BaseEntity {

    @OneToOne(mappedBy = "cadet")
    private CadetPay cadetPay;

    @OneToOne(mappedBy = "cadet")
    private CadetCourse cadetCourse;

    @ManyToOne
    @JoinColumn(name = "driver_id",insertable = false,updatable = false)
    private Driver driver;

    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "mobile")
    private String phone;

    @Column(name = "weixin_num")
    private String weixinNum;

    @Column(name = "idcard_num")
    private String idcardNum;

    @Column(name = "addr")
    private String addr;

    @Column(name = "enrol_datetime")
    private ZonedDateTime enrolDatetime;

    @Column(name = "data_status")
    private Integer dataStatus;

}
