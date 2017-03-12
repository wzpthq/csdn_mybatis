package com.plugins.interceptors;

import com.plugins.entity.Pager;
import com.plugins.utils.ThreadLocalUtil;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * ThreadLocal分页插件
 * Created by wangzhiping on 17/3/10.
 */
// 拦截StatementHandler的Prepare方法
@Intercepts(value = {@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {
                Connection.class,
                Integer.class
        }
)})
public class ThreadLocalPagePlugin implements Interceptor{

    /**
     * 这个方法是实际的拦截逻辑，我们的目的是在这里来实现分页，需要达到什么程度的使用。
     * 假设从ThreadLocal获取分页信息，来进行分页操作；
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        // 获取目标对象，注意StatementHandler中的属性都是protected
        // 不能直接访问，因此需要通过其他的方式来获取，就是MetaObject
        // 其基本实现是BaseStatementHandler其中最重要的属性是MappedStatment
        // 包含了SQL相关信息

        // 实际返回的是RoutingStatementHandler
        StatementHandler handler = (StatementHandler) invocation.getTarget();

        // 获取指定对象的元信息
        MetaObject metaObject = MetaObject.forObject(
                handler,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory()
        );

        // 然后就可以通过MetaObject获取对象的属性
        // 获取RoutingStatementHandler->PrepareStatementHandler->BaseStatementHandler中的mappedStatement
        // mappedStatement 包含了Sql的信息
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

        // 获取statement id
        String statementId = mappedStatement.getId();

        // 会拦截每个属性
        if (statementId.endsWith("ByPage")){
            // ByPage 表示的是分页查询
            BoundSql boundSql = handler.getBoundSql();

            String sql = boundSql.getSql();

            // 获取当前线程分页信息
            Pager<?> pager =  ThreadLocalUtil.threadLocal.get();

            String countSql = "SELECT COUNT(*) " + sql.substring(sql.indexOf("FROM"));

            Connection conn = (Connection) invocation.getArgs()[0];
            PreparedStatement ps = conn.prepareStatement(countSql);

            // 获取参数处理器来处理参数
            ParameterHandler ph = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            ph.setParameters(ps);

            // 执行查询
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pager.setTotalCount(rs.getInt(1));
            }

            String pageSql = sql + " LIMIT " + pager.getStartPos() + ", " + pager.getPageSize();

            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }


        return invocation.proceed();
    }

    // 指定需要拦截的对象
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    // 初始化属性
    @Override
    public void setProperties(Properties properties) {

    }
}
