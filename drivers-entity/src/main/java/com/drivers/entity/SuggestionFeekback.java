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
@Table(name = "suggestion_feekback")
@Data
public class SuggestionFeekback extends BaseEntity{

    @Column(name = "suggestion_id")
    private Long suggestionId;

    @Column(name = "content")
    private Long content;
}
