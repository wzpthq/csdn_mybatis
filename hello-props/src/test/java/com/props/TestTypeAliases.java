package com.props;

import com.props.pojo.User;
import com.props.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 测试TypeAliases标签相关的配置
 * Created by wangzhiping on 17/2/24.
 */
public class TestTypeAliases {

    private MybatisUtils instance = MybatisUtils.getInstance("mybatis-config-properties-typealiases.xml");

    @Test
    public void testNotTypeAlias(){
        SqlSession session = instance.getSession();
        try{
            User user = session.selectOne("com.props.pojo.User.findByIdAndNotTypeAlias", 201);
            System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
    }


    @Test
    public void testWithTypeAlias(){
        SqlSession session = instance.getSession();
        try{
            User user = session.selectOne("com.props.pojo.User.findByIdAndTypeAlias", 201);
            System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
    }

    @Test
    public void testWithPackage(){
        SqlSession session = instance.getSession();
        try{
            User user = session.selectOne("com.props.pojo.User.findByIdAndTypeAlias", 201);
            System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
    }

}
