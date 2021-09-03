package top.buukle.opensource.arche.generator.invoker.enums;

import java.sql.Driver;

/**
 * @description
 * @Author elvin
 * @Date 2021/5/12
 */
public enum DatabaseType {
    // 数据库类型枚举
    MySQL("com.mysql.cj.jdbc.Driver"),
    ;

    private String driverClazz;

    /**
     * @param driver           Driver的类名
     */
    DatabaseType(String driver) {
        this.driverClazz = driver;
    }

    public String getDriverClazzName() {
        return driverClazz;
    }

    public Driver getDriver() {
        try {
            Class o = Class.forName(driverClazz);
            return (Driver) o.newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}