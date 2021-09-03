package top.buukle.opensource.arche.generator.commons.session;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.buukle.opensource.arche.generator.utils.StringUtil;

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
            userDO.setUsername(request.getHeader("USERNAME"));
            userDO.setUserId(request.getHeader("UID"));
            userDO.setDeptId(StringUtil.isEmpty(request.getHeader("DEPT_ID")) ? null : Integer.parseInt(request.getHeader("DEPT_ID")));
            String subDeptIdsStr = request.getHeader("SUB_DEPT_IDS");
            if(StringUtil.isNotEmpty(subDeptIdsStr)){
                userDO.setSubDeptIds(StringUtil.parseStringToListComma(subDeptIdsStr));
            }
        }
        return userDO;
    }
}
