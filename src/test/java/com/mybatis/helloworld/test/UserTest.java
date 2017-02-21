package com.mybatis.helloworld.test;

import com.mybatis.helloworld.pojo.User;
import com.mybatis.helloworld.dao.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * Created by wangzhiping on 17/2/21.
 */
public class UserTest {

    @Test
    public void testAdd(){
        SqlSession session = MybatisUtils.getInstance().getSession();
        try{
            session.insert(User.class.getName() + ".add", new User(null, "wangzhiping", new Date(), new Date()));
            session.commit();
        }catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtils.getInstance().closeSession(session);
        }
    }

    @Test
    public void testFindById(){
        SqlSession session = MybatisUtils.getInstance().getSession();
        try{
            User user = session.selectOne(User.class.getName() + ".findById", 210);
            System.out.println(user);
        }catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtils.getInstance().closeSession(session);
        }
    }

    @Test
    public void testDeleteById(){
        SqlSession session = MybatisUtils.getInstance().getSession();
        try{
            session.delete(User.class.getName() + ".deleteById", 210);
            session.commit();
        }catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtils.getInstance().closeSession(session);
        }
    }

    @Test
    public void testUpdate(){
        SqlSession session = MybatisUtils.getInstance().getSession();
        try{
            session.update(User.class.getName() + ".update", new User(201, "wangzhiping", new Date(), new Date()));
            session.commit();
        }catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtils.getInstance().closeSession(session);
        }
    }

}
