/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: ReflectUtil
 * Author:   zhanglei1102
 * Date:     2019/11/28 18:35
 * Description: 反射工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.arche.generator.utils;


import java.lang.reflect.Method;

/**
 * @description 〈反射工具类〉
 * @author zhanglei1102
 * @create 2019/11/28
 * @since 1.0.0
 */
public class ReflectUtils {

    public static Object invoke(String beanReferenceName , String methodName , Class<?>... parameterTypes) throws Exception {
        Class<?> aClass = Class.forName(beanReferenceName);
        Object obj = aClass.newInstance();
        Method declaredMethod = aClass.getDeclaredMethod(methodName, parameterTypes);
        return declaredMethod.invoke(obj);
    }
}