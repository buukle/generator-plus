/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: DataBaseUtil
 * Author:   elvin
 * Date:     2021/5/12 10:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.generator.plus.service.util;

import top.buukle.opensource.generator.plus.service.util.enums.DatabaseType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/5/12
 * @since 1.0.0
 */
public class DataBaseUtil {



    /**
     * @description 获取数据库连接
     * @param databaseType
     * @param userName
     * @param password
     * @param url
     * @return java.sql.Connection
     * @Author elvin
     * @Date 2021/5/12
     */
    public static Connection getConnection(DatabaseType databaseType, String userName, String password, String url) throws SQLException {
        if(databaseType.equals(DatabaseType.MySQL)){
            // 加载驱动
            Driver driver = databaseType.getDriver();
            // 获得数据库连接
            Properties p = new Properties();
            p.put("user", userName);
            p.put("password", password);
            // 获取表注释
            p.put("useInformationSchema", "true");
            return driver.connect(url, p);
        }
        throw new SQLException("不支持的库类型!");
    }

    public static List<String> getTables(Connection connection) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        // 不查询视图的
        String[] types = {"TABLE", "VIEW"};
//        String[] types = {"TABLE"};
        ResultSet resultSet = meta.getTables(connection.getCatalog(), null, "%", types);
        List<String> tables = new ArrayList<>();
        while (resultSet.next()) {
            tables.add(resultSet.getString("TABLE_NAME"));
        }
        return tables;
    }
}