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
package top.buukle.generator.entity.dto;

import java.util.List;
import java.util.Set;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ANTDPPermissionDTO {

    private String roleId;
    private String permissionId;
    private String permissionName;
    private String actions;
    private Set<ANTDPActionDTO> actionEntitySet;
    private List<ANTDPActionDTO> actionList;
    private String dataAccess;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public Set<ANTDPActionDTO> getActionEntitySet() {
        return actionEntitySet;
    }

    public void setActionEntitySet(Set<ANTDPActionDTO> actionEntitySet) {
        this.actionEntitySet = actionEntitySet;
    }

    public List<ANTDPActionDTO> getActionList() {
        return actionList;
    }

    public void setActionList(List<ANTDPActionDTO> actionList) {
        this.actionList = actionList;
    }

    public String getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(String dataAccess) {
        this.dataAccess = dataAccess;
    }
}