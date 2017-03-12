package com.objectfactory.factorys;

import com.objectfactory.pojo.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;

import java.util.*;

/**
 * 一般通过继承DefaultObjectFactory来自定义ObjectFactory
 * Created by wangzhiping on 17/3/12.
 */
public class TestObjectFactory extends DefaultObjectFactory {

    /**
     * 设置属性
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        Set<Object> keys = properties.keySet();
        for(Iterator<Object> i = keys.iterator(); i.hasNext();) {
            System.out.println(" ====== " + properties.get(i.next()) + " ====== ");
        }
        super.setProperties(properties);
    }

    /**
     * 创建对象
     * @param type
     * @return
     */
    @Override
    public Object create(Class type) {
        if (type.equals(User.class)){
            User user = (User)super.create(type);
            user.setName("---create---");
            user.setCreatedAt(new Date());
            return user;
        }
        return super.create(type);
    }

    /**
     * 创建对象根据指定的参数对象
     * @param type
     * @param constructorArgTypes
     * @param constructorArgs
     * @param <T>
     * @return
     */
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    /**
     * 判断是否是集合
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
