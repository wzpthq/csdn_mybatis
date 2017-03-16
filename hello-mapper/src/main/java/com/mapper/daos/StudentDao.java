package com.mapper.daos;

import com.mapper.pojo.Student;
import com.mapper.pojo.Teacher;
import com.mapper.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by wangzhiping on 17/3/15.
 */
public class StudentDao {

    private static StudentDao teacherDao = new StudentDao();

    private static MybatisUtils instance = MybatisUtils.getInstance(null);

    private StudentDao(){}

    public static StudentDao getInstance(){
        return teacherDao;
    }


    /**
     * 根据主键查询
     * @param id
     */
    public Student findById(int id){

        Student student = null;
        SqlSession session = instance.getSession();

        try{
            student = session.selectOne(Student.class.getName() + ".findById", id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }

        return student;
    }

}
