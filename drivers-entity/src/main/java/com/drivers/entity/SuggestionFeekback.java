package com.drivers.entity;

import com.drivers.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@Table(name = "suggestion_feekback")
@Data
@DynamicInsert
@DynamicUpdate
public class SuggestionFeekback extends BaseEntity{

    @Column(name = "suggestion_id")
    private Long suggestionId;

    @Column(name = "content")
    private Long content;
}
