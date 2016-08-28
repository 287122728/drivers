package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by xhuji on 2016/8/28.
 */
@Entity
@Table(name = "driver")
@Data
@DynamicInsert
@DynamicUpdate
public class Driver extends BaseEntity{

    @OneToMany(mappedBy = "driver")
    private List<Cadet> cadet;

    @Column(name = "name")
    private String name;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "model")
    private String model;

    @Column(name = "register_datetime")
    private ZonedDateTime registerDatetime;

    @Column(name = "data_status")
    private Integer dataStatus;
}
