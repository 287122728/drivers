package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
@Table(name = "sys_manager")
@Data
@DynamicInsert
@DynamicUpdate
public class SysManager extends BaseEntity{
    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     * 头像地址
     */
    @Column(name = "avatar_url")
    private String avatarUrl;
    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;
    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;
    /**
     * 数据有效状态
     */
    @Column(name = "data_status")
    private Integer dataStatus;
}
