package com.objectfactory;

import com.objectfactory.pojo.User;
import com.objectfactory.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by wangzhiping on 17/3/12.
 */
public class ObjectFactoryTest {

    private MybatisUtils instance =  MybatisUtils.getInstance("mybatis-config.xml");

    @Test
    public void testObjectFactory() {

        SqlSession session = instance.getSession();
        User user = session.selectOne(User.class.getName() + ".findById", 5);
        System.out.println(user);

    }

}
