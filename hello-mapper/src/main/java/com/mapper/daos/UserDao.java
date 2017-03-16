package com.mapper.daos;

import com.mapper.pojo.User;
import com.mapper.util.MybatisUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by wangzhiping on 17/3/14.
 */
public class UserDao {

    private static UserDao userDao = new UserDao();

    private static MybatisUtils instance = MybatisUtils.getInstance(null);

    private UserDao(){}

    public static UserDao getInstance(){
        return userDao;
    }


    /**
     * 根据主键查询
     * @param id
     */
    public User findById(int id){

        User user = null;

        SqlSession session = instance.getSession();

        try{
            user = session.selectOne(User.class.getName() + ".findById", id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }

        return user;
    }


    /**
     * 添加用户
     * @param user
     */
    public User addUser(User user){

        SqlSession session = instance.getSession();
        try{
            session.insert(User.class.getName() + ".add", user);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
        return user;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int update(User user) {
        int updateCount = 0;
        SqlSession session = instance.getSession();
        try{
            updateCount = session.update(User.class.getName() + ".update", user);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
        return updateCount;
    }

    /**
     * 删除用户信息
     */
    public int deleteById(int id){
        int updateCount = 0;
        SqlSession session = instance.getSession();
        try{
            session.delete(User.class.getName() + ".deleteById", id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }
        return updateCount;
    }

}
