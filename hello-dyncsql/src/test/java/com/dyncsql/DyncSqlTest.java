package com.dyncsql;

import com.dyncsql.pojo.User;
import com.dyncsql.util.MybatisUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by wangzhiping on 17/3/19.
 */
public class DyncSqlTest {

    private MybatisUtils instance = MybatisUtils.getInstance(null);


    /**
     * 异常：There is no getter for property named 'name' in 'class java.lang.String'
     */
    @Test(expected = PersistenceException.class)
    public void testIfException(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName1", "admin");
        System.out.println(users);
        session.close();
    }


    /**
     * 正常case：使用_parameter替代之前的参数
     */
    @Test
    public void testIfSuccess(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName2", "admin");
        System.out.println(users);
        session.close();
    }

    /**
     * 异常Case
     */
    @Test
    public void testIfExceptionForNotCDATA(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName3", "admin");
        System.out.println(users);
        session.close();
    }

    /**
     * 正常Case: <![CDATA[ 内容 解决]]>
     */
    @Test
    public void testIfSuccessForCDATA(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName4", "admin");
        System.out.println(users);
        session.close();
    }

    /**
     * choose: When name == 'admin'
     */
    @Test
    public void testChooseForAdmin(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName5", "admin");
        System.out.println(users);
        session.close();
    }

    /**
     * choose: When name == 'admin1'
     */
    @Test
    public void testChooseForAdmin1(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName5", "admin1");
        System.out.println(users);
        session.close();
    }

    /**
     * choose: otherwise
     */
    @Test
    public void testChooseForOtherwise(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName5", "admin6");
        System.out.println(users);
        session.close();
    }

    /**
     * foreach
     */
    @Test
    public void tesForeach(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByIds", Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(users);
        session.close();
    }

    /**
     * bind
     */
    @Test
    public void testBind(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findLikeByName", "admin1");
        System.out.println(users);
        session.close();
    }

    /**
     * where for null
     */
    @Test
    public void testWhereForNull(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName6", null);
        System.out.println(users);
        session.close();
    }

    /**
     * where for value
     */
    @Test
    public void testWhereForNotNull(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName6", "admin");
        System.out.println(users);
        session.close();
    }

    /**
     * where for and
     */
    @Test
    public void testWhereForAnd(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName7", "admin");
        System.out.println(users);
        session.close();
    }

    /**
     * update
     */
    @Test
    public void testUpdateForSet(){
        SqlSession session = instance.getSession();
        session.update(User.class.getName() + ".updateById", new User(5, "wangzhiping", new Date(), new Date()));
        session.commit();
        session.close();
    }

    /**
     * trim实现where
     */
    @Test
    public void testTrimImplWhere(){
        SqlSession session = instance.getSession();
        List<User> users = session.selectList(User.class.getName() + ".findByName8", "admin");
        System.out.println(users);
        session.close();
    }

    /**
     * trim实现set
     */
    @Test
    public void testTrimForSet(){
        SqlSession session = instance.getSession();
        session.update(User.class.getName() + ".updateById", new User(6, "wangzhiping", new Date(), new Date()));
        session.commit();
        session.close();
    }


}
