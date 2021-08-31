package top.buukle.generator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By zhanglei
 * Description: 
 * 应用表
 *
 * @author  zhaongleiqt@chinamobile.com
 */
@Data
public class Datasources implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * 审批记录id
     *
     */
    private Integer auditId;

    /**
     *
     */
    private String applicationCode;

    /**
     * 数据源名称
     *
     */
    private String name;

    /**
     *
     */
    private String url;

    /**
     * 用户名
     *
     */
    private String username;

    /**
     * 密码
     *
     */
    private String password;

    /**
     * 数据库名称
     *
     */
    private String databaseName;

    /**
     * 描述
     *
     */
    private String description;

    /**
     * 备注
     *
     */
    private String remark;

    /**
     * 创建时间
     *
     */
    private Date gmtCreated;

    /**
     *
     */
    private String creator;

    /**
     * 创建者部门id
     *
     */
    private Integer creatorDeptId;

    /**
     * 创建者UID
     *
     */
    private String creatorCode;

    /**
     * 更新时间
     *
     */
    private Date gmtModified;

    /**
     *
     */
    private String modifier;

    /**
     * 更新者UID
     *
     */
    private String modifierCode;

    /**
     * 审核状态  -1:待提交 0:提交审核  1:审核中 2: 审核不通过 3:审核通过
     *
     */
    private Integer auditStatus;

    /**
     *  状态 -1:已删除 0:创建完成 1:审核中 2: 停用 3: 正常
     *
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

    /**
     */
    private static final long serialVersionUID = 1L;

}