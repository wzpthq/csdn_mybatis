package com.plugins.utils;

import com.plugins.entity.Pager;
import com.plugins.pojo.User;

/**
 * Created by wangzhiping on 17/3/11.
 */
public class ThreadLocalUtil {

    public final static ThreadLocal<Pager<?>> threadLocal = new ThreadLocal<Pager<?>>();

}
