package top.buukle.opensource.arche.generator.service.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import java.util.Map;

/**
 * @description elvin
 * @Author zhanglei1102
 * @Date 2019/11/28
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	public static ApplicationContext applicationContext;


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		//优先获取web上下文
		SpringContextUtil.applicationContext = ContextLoader.getCurrentWebApplicationContext();
		if(SpringContextUtil.applicationContext==null){
			SpringContextUtil.applicationContext = applicationContext;
		}

	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> requiredType) {
		return applicationContext.getBean(name, requiredType);
	}

	public static <T> T getBean(Class<T> requiredType) {
		return applicationContext.getBean( requiredType);
	}

	public static <T> Map<String,T> getBeansOfType(Class clazz){

		return applicationContext.getBeansOfType(clazz);

	}

	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	public static boolean isSingleton(String name) {
		return applicationContext.isSingleton(name);
	}

	public static Class<? extends Object> getType(String name) {
		return applicationContext.getType(name);
	}

}