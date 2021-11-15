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
                    .addResourceLocations("classpath:/resources/")
                    .addResourceLocations("classpath:/static/")
                    .addResourceLocations("classpath:/public/");
            registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                    "classpath:/META-INF/resources/");
            registry.addResourceHandler("doc.html").addResourceLocations(
                    "classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
	        if(SystemUtil.isWindows()){
                registry.addResourceHandler("/upload/**")
                        .addResourceLocations("file:D://file/temp");
                registry.addResourceHandler("/generator-plus/**")
                        .addResourceLocations("file:C:/Users/17600/Desktop/elvin/generator-plus.all/generator-plus-front/dist/");
            }else{
                registry.addResourceHandler("/upload/**")
                        .addResourceLocations("file:/opt/temp");
                registry.addResourceHandler("/generator-plus/**")
                        .addResourceLocations("file:/root/webrun/front/generator-plus-front/dist/");
            }
            super.addResourceHandlers(registry);
        }
}