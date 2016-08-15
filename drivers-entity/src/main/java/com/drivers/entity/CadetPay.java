package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

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
@Table(name = "cadet_pay")
@Data
@DynamicInsert
@DynamicUpdate
public class CadetPay extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "cadet_id",insertable = false,updatable = false)
    private Cadet cadet;
    /**
     * 学员信息数据ID
     */
    @Column(name = "cadet_id")
    private Long cadetId;
    /**
     * 缴费状态
     */
    @Column(name = "pay_status")
    private Integer payStatus;
    /**
     * 缴费金额
     */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;
}
