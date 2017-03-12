/**
 * 有关mybatis的plugins的使用，有点类似于拦截器的意思，并且也是通过动态代理实现的拦截作用
 * 主要能拦截的对象过程有：
 * 1、参数处理器: ParameterHandler
 * 2、结果处理器: ResultSetHandler
 * 3、语句处理器: StatementHandler
 * 4、执行器:    Executor
 *
 * Created by wangzhiping on 17/3/7.
 */
package com.plugins;