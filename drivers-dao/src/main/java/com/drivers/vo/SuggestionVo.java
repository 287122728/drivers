package com.drivers.vo;

import com.drivers.jdbc.annotations.Column;
import com.drivers.jdbc.annotations.Id;
import com.drivers.jdbc.annotations.TableEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by xhuji on 2016/8/15.
 */
@TableEntity("suggestion")
@Data
@NoArgsConstructor
public class SuggestionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @Column("name")
    private String name;
    @Column("mobile")
    private String mobile;
    @Column("content")
    private String content;
    @Column("business_status")
    private Integer businessStatus;
    @Column("data_status")
    private Integer dataStatus;
    @Column("data_creator")
    private String dataCreator;
    @Column("data_updater")
    private String dataUpdater;
    @Column("data_create_datetime")
    private Timestamp dataCreateDatetime;
    @Column("data_update_datetime")
    private Timestamp dataUpdateDatetime;

    @Column("username")
    private String username;
}
