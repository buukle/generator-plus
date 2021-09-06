package top.buukle.opensource.arche.generator.web.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import top.buukle.business.base.utils.SystemUtil;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	    @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/resources/")
                    .addResourceLocations("classpath:/static/")
                    .addResourceLocations("classpath:/public/")
                    .addResourceLocations("file:C:/Users/17600/Desktop/elvin/buukle-generator.all/buukle-generator-front/dist/")
                    .addResourceLocations("file:/root/webrun/front/buukle-generator/dist/");
            registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                    "classpath:/META-INF/resources/");
            registry.addResourceHandler("doc.html").addResourceLocations(
                    "classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
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