package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "school_tuition")
@Data
public class SchoolTuition extends BaseEntity{

    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "tuition")
    private double tuition;

    @Column(name = "tuition_explain")
    private String tuitionExplain;

}
