package com.drivers.manager.web.response;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/8/11.
 */
@Data
public class SuggestionResp {

    private Long id;

    private String name;

    private String mobile;

    private String content;

    private Integer businessStatus;

    private Integer dataStatus;

    private ZonedDateTime dataCreateDatetime;
}
