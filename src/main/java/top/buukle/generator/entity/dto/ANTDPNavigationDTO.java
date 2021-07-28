/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: ANTDPActionDTO
 * Author:   elvin
 * Date:     2021/7/26 19:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.entity.dto;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ANTDPNavigationDTO {

    private String name      ;
    private Integer parentId  ;
    private String component ;
    private String path ;
    private Integer id       ;
    private MetaDTO meta;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }
}