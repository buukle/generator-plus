package top.buukle.generator.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By zhanglei
 * Description: 
 * 配置执行表
 *
 * @author  zhaongleiqt@chinamobile.com
 */
@Data
public class ConfiguresExecute implements Serializable {
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
     * 配置id
     *
     */
    private Integer configuresId;

    /**
     * zip包下载位置
     *
     */
    private String zipDownUrl;

    /**
     * 应用编码
     *
     */
    private String applicationCode;

    /**
     * 目录所在位置
     *
     */
    private String dirLocation;

    /**
     * 基础包
     *
     */
    private String basePackage;

    /**
     * 数据源名称
     *
     */
    private String name;

    /**
     * 文件地址
     *
     */
    private String url;

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
     * 表名(,分割)
     *
     */
    private String tables;

    /**
     * 连接信息
     *
     */
    private String databasesInfo;

    /**
     * 模板信息
     *
     */
    private String templatesInfo;

    /**
     */
    private static final long serialVersionUID = 1L;


}