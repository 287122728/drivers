package com.drivers.manager.web.request;

import com.drivers.manager.web.request.base.Request;
import lombok.Data;

import javax.validation.constraints.NotNull;
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
public class SysManagerReq extends Request {
    @NotNull
    private String username;
    @NotNull
    private String name;
}
