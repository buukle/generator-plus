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
package top.buukle.opensource.arche.generator.entity.vo.antd;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
@Data
public class ANTDPPermissionVO {

    private String roleId;
    private String permissionId;
    private String permissionName;
    private String actions;
    private Set<ANTDPActionVO> actionEntitySet;
    private List<ANTDPActionVO> actionList;
    private String dataAccess;
}