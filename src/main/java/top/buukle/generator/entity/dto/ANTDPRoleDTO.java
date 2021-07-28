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
package top.buukle.generator.entity.dto;

import java.util.List;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ANTDPRoleDTO {

    private String id;
    private String name;
    private String describe;
    private String status;
    private String creatorId;
    private String createTime;
    private String deleted;

    private List<ANTDPPermissionDTO> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public List<ANTDPPermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<ANTDPPermissionDTO> permissions) {
        this.permissions = permissions;
    }
}