package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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
@DynamicInsert
@DynamicUpdate
public class SchoolTuition extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "school_id",insertable = false,updatable = false)
    private School school;

    @Column(name = "school_id",updatable = false)
    private Long schoolId;

    @Column(name = "tuition")
    private double tuition;

    @Column(name = "tuition_explain")
    private String tuitionExplain;

}
