package com.drivers.manager.web.request;

import com.drivers.manager.web.request.base.Request;
import lombok.Data;

import java.time.ZonedDateTime;

/**
 * Created by xhuji on 2016/8/11.
 */
@Data
public class SuggestionReq extends Request {

    private String name;

    private String mobile;

    private String businessStatus;

    private ZonedDateTime dataCreateDatetime;
}
