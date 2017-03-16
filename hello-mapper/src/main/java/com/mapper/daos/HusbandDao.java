package com.mapper.daos;

import com.mapper.pojo.Husband;
import com.mapper.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by wangzhiping on 17/3/16.
 */
public class HusbandDao {


    private static HusbandDao husbandDao = new HusbandDao();

    private static MybatisUtils instance = MybatisUtils.getInstance(null);

    private HusbandDao(){}

    public static HusbandDao getInstance(){
        return husbandDao;
    }

    /**
     * 根据主键查询
     * @param id
     */
    public Husband findById(int id){

        Husband husband = null;

        SqlSession session = instance.getSession();

        try{
            husband = session.selectOne(Husband.class.getName() + ".findById", id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            instance.closeSession(session);
        }

        return husband;
    }

}
