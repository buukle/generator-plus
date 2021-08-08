package top.buukle.generator.web.configure;


import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/23.
 * @Description : AppConfigure Mvc 系统配置类
 */
@Configuration
public class AppConfigure {

    /** feign-http 链接超時時間*/
    public static int connectTimeOutMillis = 3000;
    /** feign-http 等待超时时间*/
    public static int readTimeOutMillis = 6000;


    /**
     * @description feign-http 超时设置 bean 注册
     * @param
     * @return feign.Request.Options
     * @Author elvin
     * @Date 2019/8/4
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

    /**
     * @description feign-http 重试机制设置 bean 注册
     * @param
     * @return feign.Retryer
     * @Author elvin
     * @Date 2019/8/4
     */
    @Bean
    public Retryer feignRetryer() {
        // 超时后每隔200ms ~ 2000ms 重试一次,最多重试0次;
        return new Retryer.Default(200,2000,0);
    }

    /**
     * @description 时区设置
     * @param
     * @return void
     * @Author 86180
     * @Date 2020/9/11
     */
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }

}
