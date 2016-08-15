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
@Table(name = "suggestion")
@Data
@DynamicInsert
@DynamicUpdate
public class Suggestion extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "cadet_id",insertable = false,updatable = false)
    private Cadet cadet;

    @Column(name = "cadet_id")
    private Long cadetId;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "content")
    private String content;

    @Column(name = "business_status")
    private Integer businessStatus;

    @Column(name = "data_status")
    private Integer dataStatus;
}
