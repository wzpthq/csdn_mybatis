package com.props;

import com.props.pojo.User;
import com.props.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by wangzhiping on 17/2/24.
 */
public class TestAnnotationAlias {

    private MybatisUtils instance = MybatisUtils.getInstance("mybatis-config-properties-annotation-aliases.xml");

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
    public void testWithPackageAndAnnotation(){
        SqlSession session = instance.getSession();
        try{
            User user = session.selectOne("com.props.pojo.User.findByIdAndAnnotationAlias", 201);
            System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
    }

    @Test
    public void testWithTypeHandler(){
        SqlSession session = instance.getSession();
        try{
            User user = session.selectOne("com.props.pojo.User.findByIdAndTypeHandler", 201);
            System.out.println(user);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
    }

}
