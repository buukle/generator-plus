/**
 * Copyright (C), 2015-2020  http://www.buukle.top
 * FileName: DuConfigure
 * Author:   86180
 * Date:     2020/10/13 9:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.arche.generator.web.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @description 〈〉
 * @author 86180
 * @create 2020/10/13
 * @since 1.0.0
 */
@Configuration
public class DruidConfigure {

    private static String dbUrl;

    private static String username;

    private static String password;

    private static String driverClassName;

    private static int initialSize;

    private static int minIdle;

    private static int maxActive;

    private static int maxWait;

    private static String filters;

    @Value("${spring.datasource.url}")
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Value("${spring.datasource.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    @Value("${spring.datasource.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    @Value("${spring.datasource.driver-class-name}")
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Value(value = "${spring.datasource.initialSize}")
    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    @Value(value = "${spring.datasource.minIdle}")
    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    @Value(value = "${spring.datasource.maxActive}")
    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    @Value(value = "${spring.datasource.maxWait}")
    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }
    @Value(value = "${spring.datasource.filters}")
    public void setFilters(String filters) {
        this.filters = filters;
    }

    /**
     * @description 德鲁伊 servlet 配置,初始化
     * @param
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     * @Author 86180
     * @Date 2020/10/13
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServlet(){
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //添加初始化参数：initParams
        //白名单：
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
//            servletRegistrationBean.addInitParameter("deny","192.168.0.114");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    /**
     * @description 过滤器 插拔
     * @param
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     * @Author 86180
     * @Date 2020/10/13
     */
    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * 配置DataSource bean 注册
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(dbUrl);
        druidDataSource.setFilters(filters);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setUseGlobalDataSourceStat(true);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }
}