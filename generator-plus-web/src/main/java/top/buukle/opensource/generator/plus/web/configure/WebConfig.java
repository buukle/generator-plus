package top.buukle.opensource.generator.plus.web.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.buukle.opensource.generator.plus.utils.SystemUtil;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/") .addResourceLocations("classpath:/static/").addResourceLocations("classpath:/public/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations( "classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/generator-plus/**")
                .addResourceLocations("classpath:/static/");

        if(SystemUtil.isWindows()){
            registry.addResourceHandler("/upload/**")
                    .addResourceLocations("file:D://file/temp");
        }else{
            registry.addResourceHandler("/upload/**")
                    .addResourceLocations("file:/opt/temp");
        }
        super.addResourceHandlers(registry);
    }
}
