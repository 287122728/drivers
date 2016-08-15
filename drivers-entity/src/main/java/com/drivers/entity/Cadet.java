package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;

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
public class Cadet extends BaseEntity {

    @OneToOne(mappedBy = "cadet")
    private CadetPay cadetPay;

    @OneToOne(mappedBy = "cadet")
    private CadetCourse cadetCourse;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "mobile")
    private String phone;

    @Column(name = "weixin_num")
    private String weixinNum;

    @Column(name = "idcard_num")
    private String idcardNum;

    @Column(name = "data_status")
    private Integer dataStatus;

    @Override
    public String toString() {
        return "Cadet{" +
                "id=" + getId() +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", weixinNum='" + weixinNum + '\'' +
                ", idcardNum='" + idcardNum + '\'' +
                ", dataStatus=" + dataStatus +
                '}';
    }
}
