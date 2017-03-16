package com.mapper.daos;

import com.mapper.pojo.Teacher;
import com.mapper.pojo.User;
import com.mapper.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by wangzhiping on 17/3/15.
 */
public class TeacherDao {

    private static TeacherDao teacherDao = new TeacherDao();

    private static MybatisUtils instance = MybatisUtils.getInstance(null);

    private TeacherDao(){}

    public static TeacherDao getInstance(){
        return teacherDao;
    }


    /**
     * 根据主键查询
     * @param id
     */
    public Teacher findById(int id){

        Teacher teacher = null;
        SqlSession session = instance.getSession();

        try{
            teacher = session.selectOne(Teacher.class.getName() + ".findById", id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }

        return teacher;
    }

}
