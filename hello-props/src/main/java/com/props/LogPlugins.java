package com.props;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * 插件，通过实现interceptor接口
 * Created by wangzhiping on 17/2/27.
 */
@Intercepts(@Signature(
        type= Executor.class,
        method="update",
        args={
            MappedStatement.class,
            Object.class
        }
))
public class LogPlugins implements Interceptor{

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
