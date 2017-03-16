package com.mapper.daos;

import com.mapper.pojo.Husband;
import com.mapper.pojo.Wife;
import com.mapper.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by wangzhiping on 17/3/16.
 */
public class WifeDao {


    private static WifeDao wifeDao = new WifeDao();

    private static MybatisUtils instance = MybatisUtils.getInstance(null);

    private WifeDao(){}

    public static WifeDao getInstance(){
        return wifeDao;
    }

    /**
     * 根据主键查询
     * @param id
     */
    public Wife findById(int id){

        Wife wife = null;

        SqlSession session = instance.getSession();

        try{
            wife = session.selectOne(Wife.class.getName() + ".findById", id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }

        return wife;
    }

}
