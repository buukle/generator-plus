package top.buukle.opensource.generator.plus.commons.session;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

    /**
     * @description 从请求中获取用户信息
     * @param
     * @return void
     * @Author zhanglei451
     * @Date 2021/9/2
     */
    public static UserDO getOperator() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        UserDO userDO = new UserDO();

        if(request != null){
            String authorization = request.getHeader("Authorization");
            userDO.setUsername(request.getHeader("Authorization"));
            userDO.setUserId(request.getHeader("UID"));
            userDO.setDeptId(request.getHeader("DEPT_ID"));
            String subDeptIdsStr = request.getHeader("SUB_DEPT_IDS");
            userDO.setSubDeptIds(subDeptIdsStr);
        }
        return userDO;
    }
}