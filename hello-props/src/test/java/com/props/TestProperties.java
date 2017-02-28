package com.props;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * 测试properties标签的使用情况
 * Created by wangzhiping on 17/2/24.
 */
public class TestProperties {


    /**
     * 配置文件：mybatis-config-properties-url.xml
     */
    @Test
    public void testUrlProperties(){
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config-properties-url.xml"));
            Configuration configuration = factory.getConfiguration();
            Properties properties = configuration.getVariables();
            Assert.assertEquals(properties.getProperty("db.username"), "root");
            Assert.assertEquals(properties.getProperty("db.password"), "root");
            Assert.assertEquals(properties.getProperty("db.driver"), "com.mysql.cj.jdbc.Driver");
            Assert.assertEquals(properties.getProperty("db.url"), "jdbc:mysql://localhost:3306/csdn?charset=utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 配置文件：mybatis-config-properties-resource.xml
     */
    @Test
    public void testResourceProperties(){
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config-properties-resource.xml"));
            Configuration configuration = factory.getConfiguration();
            Properties properties = configuration.getVariables();
            Assert.assertEquals(properties.getProperty("db.username"), "root");
            Assert.assertEquals(properties.getProperty("db.password"), "root");
            Assert.assertEquals(properties.getProperty("db.driver"), "com.mysql.cj.jdbc.Driver");
            Assert.assertEquals(properties.getProperty("db.url"), "jdbc:mysql://localhost:3306/csdn?charset=utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 配置文件：mybatis-config-properties-property.xml
     * property标签，设置的也会加载到配置变量中，供后续配置使用，会出现一种情况需要解决
     * 情况：
     * 如果resource/url加载的配置文件与property属性名重复了，是怎么取值的？
     */
    @Test
    public void testPropertiesProperty(){
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config-properties-property.xml"));
            Configuration configuration = factory.getConfiguration();
            Properties properties = configuration.getVariables();
            Assert.assertEquals(properties.getProperty("db.username"), "root");
            Assert.assertEquals(properties.getProperty("db.password"), "root");
            Assert.assertEquals(properties.getProperty("db.driver"), "com.mysql.cj.jdbc.Driver");
            Assert.assertEquals(properties.getProperty("db.url"), "jdbc:mysql://localhost:3306/csdn?charset=utf8");
            Assert.assertEquals(properties.getProperty("db.test01"), "test01");
            Assert.assertEquals(properties.getProperty("db.test02"), "test02");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 配置文件：mybatis-config-properties-property.xml
     * property标签，设置的也会加载到配置变量中，供后续配置使用，会出现一种情况需要解决
     * 情况：
     * 如果resource/url加载的配置文件与property属性名重复了，是怎么取值的？
     * 结果：
     * 1，mybatis先加载property子标签的属性值；
     * 2，然后在加载resource/url加载的属性值，这样就会导致resource/url加载配置文件覆盖标签<property></property>的重复属性值
     */
    @Test
    public void testResetPropertiesProperty(){
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config-properties-property.xml"));
            Configuration configuration = factory.getConfiguration();
            Properties properties = configuration.getVariables();

            // 如果resource/url加载的配置文件与property标签重复属性;
            // 那么属性值会按照property先加载，在加载resource/url的属性配置，后者覆盖前者
            Assert.assertEquals(properties.getProperty("db.username"), "root");
            Assert.assertEquals(properties.getProperty("db.password"), "root");

            Assert.assertEquals(properties.getProperty("db.driver"), "com.mysql.cj.jdbc.Driver");
            Assert.assertEquals(properties.getProperty("db.url"), "jdbc:mysql://localhost:3306/csdn?charset=utf8");

            // 这里是property标签没有的属性值，会按照property属性值设置
            Assert.assertEquals(properties.getProperty("db.test01"), "test01");
            Assert.assertEquals(properties.getProperty("db.test02"), "test02");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
