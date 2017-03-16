/**
 * 可以自定义自己的cache，在mybatis中，cache结构大致如下
 * 有点类似于java io的设计，大量使用了装饰器模式的设计
 * | -- Cache
 * | -- -- PerpetualCache    其实就是HashMap的实现
 * | -- -- -- BlockingCache  阻塞Cache，实际上就是加个锁的实现
 * | -- -- -- FifoCache      队列Cache，First in First Out
 * | -- -- -- LoggingCache   日志Cache
 * | -- -- -- WeaKCache      弱引用Cache
 * | -- -- -- TransactionalCache 事务Cache
 * | -- -- -- LRUCache       LRU Cache
 * | -- -- -- ScheduledCache 定时Cache
 * | -- -- -- SerializedCache 序列化Cache
 * | -- -- -- SoftCache       和Weak有点类似，引用Cache
 * | -- -- -- SynchronizedCache 同步Cache
 * 这些实现，基本都是在base PerpetualCache 上做了一些处理，加了一些特性，默认是 PerpetualCache
 * Created by wangzhiping on 17/3/14.
 */
package com.mapper.caches;