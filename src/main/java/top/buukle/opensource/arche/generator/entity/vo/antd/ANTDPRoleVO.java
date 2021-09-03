/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: ANTDPRoleDTO
 * Author:   elvin
 * Date:     2021/7/26 19:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.arche.generator.entity.vo.antd;

import lombok.Data;

import java.util.List;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
@Data
public class ANTDPRoleVO {

    private String id;
    private String name;
    private String describe;
    private String status;
    private String creatorId;
    private String createTime;
    private String deleted;
    private List<ANTDPPermissionVO> permissions;

}