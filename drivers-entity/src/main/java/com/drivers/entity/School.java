package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Clob;

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
@Table(name = "school")
@Data
@DynamicInsert
@DynamicUpdate
public class School extends BaseEntity{

//    @OneToOne(mappedBy = "school")
//    private SchoolTuition schoolTuition;
    /**
     * 驾校名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 驾校logo
     */
    @Column(name = "logo")
    private byte[] logo;
    /**
     * 驾校logo地址
     */
    @Column(name = "logo_url")
    private String logoUrl;
    /**
     * 手机号码
     */
    @Column(name = "mobile")
    private String mobile;
    /**
     * 电话号码
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 电子邮箱
     */
    @Column(name = "email")
    private String email;
    /**
     * 驾校地址
     */
    @Column(name = "addr")
    private String addr;
    /**
     * 驾校简介
     */
    @Column(name = "introduction")
    private Clob introduction;
    /**
     * 数据状态
     */
    @Column(name = "dataStatus",insertable = false)
    private Integer dataStatus;
}
