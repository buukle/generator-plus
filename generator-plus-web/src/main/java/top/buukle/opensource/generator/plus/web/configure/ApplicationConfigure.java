/**
 * Copyright (C), 2015-2020  http://www.buukle.top
 * FileName: BossClientConfigure
 * Author:   86180
 * Date:     2020/10/13 9:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.generator.plus.web.configure;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.buukle.login.cube.session.tenant.TenantInterceptor;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

/**
 * @description 〈〉
 * @author 86180
 * @create 2020/10/13
 * @since 1.0.0
 */
@Configuration
public class ApplicationConfigure implements WebMvcConfigurer {

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    /**
     * @description Properties  bean 注册
     * @param
     * @return java.util.Properties
     * @Author 86180
     * @Date 2020/10/13
     */
    @Bean
    @ConfigurationProperties(prefix = "pagehelper")
    public Properties pageHelperProperties() {
        Properties properties = new Properties();
        properties.setProperty("reasonable","true");
        return properties;
    }

    /**
     * @description TenantInterceptor , PageInterceptor 插拔
     * @param
     * @return void
     * @Author 86180
     * @Date 2020/10/13
     */
    @PostConstruct
    public void addMysqlInterceptor() {
        // 分页拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(this.pageHelperProperties());
        // 租户拦截器
        TenantInterceptor tenantInterceptor = new TenantInterceptor();
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(pageInterceptor);
            sqlSessionFactory.getConfiguration().addInterceptor(tenantInterceptor);
        }
    }
}