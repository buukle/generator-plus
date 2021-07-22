package top.buukle.generator.web.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.buukle.generator.utils.SystemUtil;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	    @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/resources/")
                    .addResourceLocations("classpath:/static/")
                    .addResourceLocations("classpath:/public/");
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