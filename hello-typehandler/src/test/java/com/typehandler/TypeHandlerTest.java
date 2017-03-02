package com.typehandler;

import com.typehandler.pojo.User1;
import com.typehandler.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/**
 * Created by wangzhiping on 17/3/1.
 */
public class TypeHandlerTest {

    private MybatisUtils instance = MybatisUtils.getInstance("mybatis-config.xml");

    @Test
    public void testWirteDateTypeHandler(){

        SqlSession session = instance.getSession();

        try{
            session.insert("com.typehandler.pojo.User1.add", new User1(null, "test", new Date(), new Date()));
            session.commit();
        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        } finally {
          instance.closeSession(session);
        }
    }

    @Test
    public void testReadDateTypeHandler(){

        SqlSession session = instance.getSession();

        try{
            User1 user1 = session.selectOne("com.typehandler.pojo.User1.findById", 1);
            System.out.println(user1);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
    }

}
