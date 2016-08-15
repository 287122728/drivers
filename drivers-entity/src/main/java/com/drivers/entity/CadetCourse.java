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
@Table(name = "cadet_course")
@Data
@DynamicInsert
@DynamicUpdate
public class CadetCourse extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "cadet_id",insertable = false,updatable = false)
    private Cadet cadet;

    @Column(name = "cadet_id")
    private Long cadetId;

    @Column(name = "course")
    private Integer course;
}
