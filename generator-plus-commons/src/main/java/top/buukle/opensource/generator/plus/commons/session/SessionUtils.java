package top.buukle.opensource.generator.plus.commons.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.buukle.opensource.generator.plus.commons.log.BaseLogger;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

    private static BaseLogger LOGGER = BaseLogger.getLogger(SessionUtils.class);

    private static ObjectMapper mapper = new ObjectMapper();
    /**
     * @description 从请求中获取用户信息
     * @param
     * @return void
     * @Author zhanglei001
     * @Date 2021/9/2
     */
    public static UserDTO getOperator() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId("ANONYMOUS");
        userDTO.setUsername("ANONYMOUS");
        if(request != null){
            String authorization = request.getHeader(Constants.AUTHORIZATION);
            try {
                if(authorization != null && !"".equals(authorization)){
                    userDTO = mapper.readValue(authorization, UserDTO.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error("获取用户会话信息失败,原因:{}",e.getCause() + e.getMessage());
            }
        }
        return userDTO;
    }
}
