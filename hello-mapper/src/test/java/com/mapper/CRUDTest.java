package com.mapper;

import com.mapper.daos.UserDao;
import com.mapper.pojo.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by wangzhiping on 17/3/15.
 */
public class CRUDTest {

    @Test
    public void testAdd(){
        User user = UserDao.getInstance().addUser(new User(null, "testCRUD", new Date(), new Date()));
        System.out.println(user);
    }

    @Test
    public void testFindById(){
        User user = UserDao.getInstance().findById(210);
        Assert.assertEquals(user.getName(), "testCRUD");
        Assert.assertEquals(user.getId(), 210);
    }

    @Test
    public void testUpdate() {
        int updateCount = UserDao.getInstance().update(new User(210, "testCRUD1", new Date(), new Date()));
        Assert.assertEquals(updateCount, 1);
    }

    @Test
    public void testDeleteById() {
        UserDao.getInstance().deleteById(210);
    }

}
