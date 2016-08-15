package com.drivers.manager.web.request;

import com.drivers.manager.web.request.base.Request;
import lombok.Data;

import java.io.Serializable;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/12
 */
@Data
public class SchoolReq extends Request{

    private Long id;

    private String name;

    private String mobile;

    private String phone;

    private String email;

    private String addr;

    private String introduction;
}
