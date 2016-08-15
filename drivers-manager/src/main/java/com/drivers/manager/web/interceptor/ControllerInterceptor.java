//package com.drivers.manager.web.interceptor;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import javax.annotation.Resource;
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//
//import com.drivers.manager.exceptions.BizException;
//import com.drivers.manager.web.request.base.Request;
//import com.drivers.manager.web.response.base.Response;
//import com.drivers.manager.web.response.base.StatusCode;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.stereotype.Component;
//
///**
// * Title:controller aop
// * Description:
// * Copyright: Copyright (c) 2012
// * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
// * @author fengwen
// * @version 1.0 2016年2月2日
// */
//@Component
//@Aspect
//@Slf4j
//public class ControllerInterceptor {
//
//    //Controller层切点  Validate
//    @Pointcut("@annotation(com.drivers.manager.web.interceptor.Validate)")
//    public void validateControllerAspect() {
//
//    }
//    /**
//     * 验证请求
//     * @param joinPoint
//     * @throws Throwable
//     */
//    @Before("validateControllerAspect()")
//    public  void validateRequest(JoinPoint  joinPoint) throws Throwable {
//    	Object[] args = joinPoint.getArgs();
//    	if(args.length==0){
//    		throw new BizException(StatusCode.ValidateError,
//    				"the method "+joinPoint.getSignature()+" must has parameter Request<T>");
//    	}
//    	if(!(args[0] instanceof Request<?>)){
//    		throw new BizException(StatusCode.ValidateError,
//    				"the method "+joinPoint.getSignature()+" must has parameter Request<T> at the first position");
//    	}
//    	validateReq((Request<?>) args[0],getGroupCalss(joinPoint));
//    }
//
//
//    /**
//     * 获得@Validate注解中的groups
//     * @param joinPoint
//     * @return
//     */
//    @SuppressWarnings("rawtypes")
//	private Class[] getGroupCalss(JoinPoint joinPoint){
//    	Class clazz = joinPoint.getTarget().getClass();
//    	String methodName = joinPoint.getSignature().getName();
//    	Method[] methods = clazz.getMethods();
//    	for(Method m:methods){
//    		if(!m.getName().equals(methodName)){
//    			continue;
//    		}
//    		if(m.getParameters().length!=joinPoint.getArgs().length){
//    			continue;
//    		}
//    		Validate v = m.getDeclaredAnnotation(Validate.class);
//    		if(v==null){
//    			continue;
//    		}
//    		return v.groups();
//    	}
//    	return null;
//    }
//
//    /**
//     * 验证请求
//     * @param request
//     */
//    private <T> void validateReq(Request<T> request,Class<?>[] groups){
//    	validate(request,groups);
//    }
//
//    /**
//     * hibernate-validator验证
//     * @param obj
//     * @param groups
//     */
//    private void validate(Object obj,Class<?>[] groups){
//    	Validator vf = Validation.buildDefaultValidatorFactory().getValidator();
//		Set<ConstraintViolation<Object>> rsList = null;
//		if(groups==null||groups.length==0){
//			rsList = vf.validate(obj);
//		}else{
//			rsList = vf.validate(obj,groups);
//		}
//		if(rsList.size()==0){
//			return;
//		}
//		String msg = "";
//		for(ConstraintViolation<Object> rs:rsList){
//			msg += rs.getPropertyPath()+rs.getMessage()+";";
//		}
//		Response<String> resp = new Response<String>();
//		resp.setStatusCode(StatusCode.ValidateError);
//		resp.setMessage(StatusCode.ValidateError.getMessage());
//		resp.setContent(msg);
//		throw new BizException(resp);
//    }
//
//
//	/**
//	 * by fw 2016-6-28 refactor
//	 * @param rs
//	 * @param args
//	 * @return
//	 */
//	private boolean basicValidate(Object rs,Object[] args){
//		if(args.length==0){
//			return false;
//		}
//		if(!(args[0] instanceof Request<?>)){
//			return false;
//		}
//		if(!(rs instanceof Response<?>)){
//			return false;
//		}
//		//过滤原始操作失败的情况
//		if(((Response<?>)rs).getStatus()!=StatusCode.OK.getCode()){
//			return false;
//		}
//		return true;
//	}
//}
