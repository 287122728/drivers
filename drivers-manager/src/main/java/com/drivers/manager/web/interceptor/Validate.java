package com.drivers.manager.web.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title:需要验证请求的方法注解
 * Description: 
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 * @author fengwen
 * @version 1.0 2016年2月3日
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented
public @interface Validate {

	int reqParamIndex() default 0;
	
	Class<?>[] groups() default {};
	
}
