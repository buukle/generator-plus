package top.buukle.opensource.generator.plus.dos.vo.configures;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.buukle.opensource.generator.plus.dos.vo.tables.TableVo;
import top.buukle.opensource.generator.plus.dos.vo.templates.TemplatesForConfigureEditVO;

import java.util.Date;
import java.util.List;


/**
* @author elvin
* @description  Datasources 查询包装类
*/
@Data
@ApiModel(value = "配置 - 查询响应")
public class ConfiguresVO {

    /** 连接名称*/
    @ApiModelProperty(value = "连接名称")
    private String datasourcesName;
    /** 模板分组名称*/
    @ApiModelProperty(value = "模板分组名称")
    private String templatesGroupName;
    /** 模板ids*/
    @ApiModelProperty(value = "模板ids")
    private String templateIds;
    /** 模板集合*/
    @ApiModelProperty(value = "模板集合")
    private List<TemplatesForConfigureEditVO> templatesList;
    /** 表名集合*/
    @ApiModelProperty(value = "表名集合")
    private List<TableVo> tableList;

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 审批记录id
     */
    @ApiModelProperty(value = "审批记录id")
    private Integer auditId;
    /**
     * 连接id
     */
    @ApiModelProperty(value = "连接id")
    private Integer datasourcesId;
    /**
     * 模板分组id
     */
    @ApiModelProperty(value = "模板分组id")
    private Integer templatesGroupId;
    /**
     * 应用编码
     */
    @ApiModelProperty(value = "应用编码")
    private String applicationCode;
    /**
     * 目录所在位置
     */
    @ApiModelProperty(value = "目录所在位置")
    private String dirLocation;
    /**
     * 基础包
     */
    @ApiModelProperty(value = "基础包")
    private String basePackage;
    /**
     * 数据源名称
     */
    @ApiModelProperty(value = "数据源名称")
    private String name;
    /**
     * 文件地址
     */
    @ApiModelProperty(value = "文件地址")
    private String url;
    /**
     * 表名(,分割)
     */
    @ApiModelProperty(value = "表名(,分割)")
    private String tables;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;
    /**
     * 审核状态  -1:待提交 0:提交审核  1:审核中 2: 审核不通过 3:审核通过
     */
    @ApiModelProperty(value = "审核状态  -1:待提交 0:提交审核  1:审核中 2: 审核不通过 3:审核通过")
    private Integer auditStatus;
    /**
     *  状态 -1:已删除 0:创建完成 1:审核中 2: 停用 3: 正常
     */
    @ApiModelProperty(value = "状态 -1:已删除 0:创建完成 1:审核中 2: 停用 3: 正常")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreated;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String creator;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String modifier;

}
