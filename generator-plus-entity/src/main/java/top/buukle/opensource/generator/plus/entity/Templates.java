package top.buukle.opensource.generator.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 模板表
 * </p>
 *
 * @author 
 * @since 2021-09-04
 */
@Data
@TableName("templates")
public class Templates implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 审批记录id
     */
    private Integer auditId;
    /**
     * 模板分组id
     */
    private Integer templatesGroupId;
    /**
     * 
     */
    private String applicationCode;
    /**
     * 数据源名称
     */
    private String name;
    /**
     * 生成路径
     */
    private String path;
    /**
     * 开启表名目录
     */
    private String openTablePath;
    /**
     * 文件名是否追加模板名前段 1: 追加,0:不追加
     */
    private String addNameSuffix;
    /**
     * 包名
     */
    private String packageInfo;
    /**
     * 文件地址
     */
    private String url;
    /**
     * 模板类型(entity,dao,xml,service,serviceImpl,controller)
     */
    private String type;
    /**
     * 内容
     */
    private String content;
    /**
     * 描述
     */
    private String description;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date gmtCreated;
    /**
     * 
     */
    private String creator;
    /**
     * 创建者部门id
     */
    private Integer tenantId;
    /**
     * 创建者UID
     */
    private String creatorCode;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 
     */
    private String modifier;
    /**
     * 更新者UID
     */
    private String modifierCode;
    /**
     * 审核状态  -1:待提交 0:提交审核  1:审核中 2: 审核不通过 3:审核通过
     */
    private Integer auditStatus;
    /**
     *  状态 -1:已删除 0:创建完成 1:审核中 2: 停用 3: 正常
     */
    private Integer status;
    /**
     * 
     */
    private String bak01;
    /**
     * 
     */
    private String bak02;
    /**
     * 
     */
    private String bak03;
    /**
     * 
     */
    private String bak04;
    /**
     * 
     */
    private String bak05;

}