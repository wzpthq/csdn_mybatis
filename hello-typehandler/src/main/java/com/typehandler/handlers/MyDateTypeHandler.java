package com.typehandler.handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangzhiping on 17/3/1.
 */


// 设置映射的数据库类型，必须是JdbcType指定类型
@MappedJdbcTypes(JdbcType.VARCHAR)
// 设置映射的java类型，主要是java的类型
@MappedTypes(value=java.util.Date.class)
// 如果没有在javacode中指定javaType 和 javaType那么需要配置文件指定，如果制定了可以不需要再制定
public class MyDateTypeHandler extends BaseTypeHandler<Date>{  // 继承BaseTypeHandler，期泛型就是需要转化的类型

    /**
     * 该函数：
     * @param ps jdbc中的PreparedStatement对象
     * @param i 数据的位置索引
     * @param parameter 需要插入的数据参数（一般是执行更新、删除、插入时调用）
     * @param jdbcType 数据库类型
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        // 注入值时
        Long timestamp = parameter.getTime() / 1000;
        ps.setString(i, timestamp.toString());
    }

    
    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 从数据库中获取数据
        String timestamp = rs.getString(columnName);
        return new Date(Long.parseLong(timestamp) * 1000);
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        String timestamp = rs.getString(columnIndex);
        return new Date(Long.parseLong(timestamp) * 1000);
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String timestamp = cs.getString(columnIndex);
        return new Date(Long.parseLong(timestamp) * 1000);


    }

}
