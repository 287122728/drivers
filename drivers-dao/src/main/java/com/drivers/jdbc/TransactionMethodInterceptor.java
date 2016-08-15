package com.drivers.jdbc;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * 读写分离方法拦截
 *
 * @author tietang
 * @since 2015/6/16 13:43
 */
public class TransactionMethodInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TransactionMethodInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 获取方法的@Transactional
        Method method = invocation.getMethod();
        Transactional methodTransactional = method.getAnnotation(Transactional.class);

        // 获取类上的@Transactional
        Object bean = invocation.getThis();
        Transactional beanTransactional = bean.getClass().getAnnotation(Transactional.class);

        // 首先从方法上获取【只读】；如果方法上没有@Transactional，则从类上获取【只读】；如果都没有，则使用默认【读写】
        boolean isRead = false;
        if (methodTransactional != null) {
            isRead = methodTransactional.readOnly();
        } else if (beanTransactional != null) {
            isRead = beanTransactional.readOnly();
        }

        //如果是只读
        if (isRead) {
            JdbcContextHolder.setReadOnly();
            logger.debug("set read_ds {}.{}为读库,readOnly={}", bean.getClass(), method.getName(), true);
        } else {
            if (beanTransactional != null || methodTransactional != null) {
                logger.debug("set write_ds {}.{},readOnly={}", bean.getClass(), method.getName(), false);
            }
        }

        try {
            return invocation.proceed();
        } finally {
            JdbcContextHolder.reset();
        }
    }
}
