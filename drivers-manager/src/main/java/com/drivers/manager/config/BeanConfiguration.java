package com.drivers.manager.config;

import com.drivers.jdbc.JdbcTemplateExt;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springside.modules.mapper.JsonMapper;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/11
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public JsonMapper jsonMapper(){
        return new JsonMapper();
    }


}
