package com.mapper;

import com.mapper.daos.StudentDao;
import com.mapper.daos.TeacherDao;
import com.mapper.pojo.Student;
import com.mapper.pojo.Teacher;
import org.junit.Test;

/**
 * Created by wangzhiping on 17/3/15.
 */
public class ResultMapTest {

    @Test
    public void testCollections(){
        Teacher teacher = TeacherDao.getInstance().findById(1);
        System.out.print(teacher);
    }

    @Test
    public void testAssication(){
        Student student = StudentDao.getInstance().findById(1);
        System.out.print(student);
    }
}
