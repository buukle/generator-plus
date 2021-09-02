/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: AntRoleDTO
 * Author:   elvin
 * Date:     2021/7/26 14:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.entity.vo.antd;

import lombok.Data;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
@Data
public class ANTDPUserVO {

    private String id;
    private String name;
    private String username;
    private String password;
    private String avatar;
    private String status;
    private String lastLoginIp;
    private String lastLoginTime;
    private String creatorId;
    private String createTime;
    private String merchantCode;
    private String deleted;
    private String roleId;
    private String telephone;
    private String lang;
    private String token;
    private ANTDPRoleVO role;

}