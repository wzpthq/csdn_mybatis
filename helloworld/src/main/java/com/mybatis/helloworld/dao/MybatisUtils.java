package com.mybatis.helloworld.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created by wangzhiping on 17/2/21.
 */
public class MybatisUtils {

    private static MybatisUtils mybatisUtils = null;

    private SqlSessionFactory factory = null;


    private MybatisUtils(){
        init();
    }

    public static MybatisUtils getInstance(){
        if (mybatisUtils == null) {
            mybatisUtils = new MybatisUtils();
        }

        return mybatisUtils;
    }

    private void init() {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取session
     */
    public SqlSession getSession() {
        return factory.openSession();
    }

    /**
     * 关闭session
     */
    public void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }


}
