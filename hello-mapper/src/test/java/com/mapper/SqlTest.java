package com.mapper;

import com.mapper.daos.UserDao;
import com.mapper.pojo.User;
import com.mapper.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 测试Sql标签的用法
 * Created by wangzhiping on 17/3/13.
 */
public class SqlTest {

    private MybatisUtils instance = MybatisUtils.getInstance("mybatis-config.xml");

    @Test
    public void testSql(){
        SqlSession session = instance.getSession();
        User user = session.selectOne(User.class.getName() + ".findById", 5);
        System.out.print(user);
    }

    /**
     * 注意这种方式cache是无法使用的，因为会未提交之前的cache会存放在
     * TransactionalCache中
     */
    @Test
    public void testCacheSql(){

        SqlSession session = instance.getSession();

        long t1 = System.currentTimeMillis();
        User user1 = session.selectOne(User.class.getName() + ".findById", 5);
        System.out.println(System.currentTimeMillis() - t1);

        long t2 = System.currentTimeMillis();
        User user2 = session.selectOne(User.class.getName() + ".findById", 5);

        long t3 = System.currentTimeMillis();
        User user3 = session.selectOne(User.class.getName() + ".findById", 5);

        System.out.println(System.currentTimeMillis() - t3);
    }


    /**
     * 这里是可以使用的自定义的缓存的
     */
    @Test
    public void testMyCache(){
        // 这是的查询，在commit时，会将TransactionalCache中的key,value信息
        // 重新设置到LoggingCache->HashMapCache中。
        User user1 = UserDao.getInstance().findById(5);

        // 这样就可以使用到user1操作的cache结果了，这里查询时，不需要使用到TransactionalCache，
        // 而是在执行之前就使用了HashMapCache
        User user2 = UserDao.getInstance().findById(5);

        System.out.print(user1 + " :=====: " + user2);
    }
}
