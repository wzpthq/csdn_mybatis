package com.plugins.interceptors;

import com.plugins.entity.Pager;
import com.plugins.pojo.User;
import com.plugins.utils.MybatisUtils;
import com.plugins.utils.ThreadLocalUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by wangzhiping on 17/3/7.
 */
public class LogPluginTest {

    private MybatisUtils instance = MybatisUtils.getInstance("mybatis-config.xml");

    @Test
    public void testQuery() {

        SqlSession session = instance.getSession();

        User user = session.selectOne(User.class.getName() + ".findById", 10);

        System.out.print(user);

    }

    @Test
    public void testQueryPageByPlugin() {

        SqlSession session = instance.getSession();

        Pager<User> pager = new Pager<User>(1, 10);
        ThreadLocalUtil.threadLocal.set(pager);

        List<User> users = session.selectList(User.class.getName() + ".findByPage");
        pager.setDatas(users);


        System.out.print(pager);

    }

}
