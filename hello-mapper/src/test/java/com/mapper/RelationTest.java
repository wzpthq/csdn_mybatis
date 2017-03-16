package com.mapper;

import com.mapper.daos.HusbandDao;
import com.mapper.pojo.Husband;
import org.junit.Test;

/**
 * 实体关联关系测试
 * Created by wangzhiping on 17/3/16.
 */
public class RelationTest {

    @Test
    public void testOneToOne() {
        Husband husband = HusbandDao.getInstance().findById(1);
        System.out.println(husband);
    }


}
