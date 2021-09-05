package top.buukle.opensource.arche.generator.dos.vo.configuresExecute;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.buukle.business.base.commons.mvc.vo.CommonVO;

import java.util.Date;


/**
* @author elvin
* @description  Datasources 查询包装类
*/
@Data
@ApiModel(value = "配置执行 - 查询响应")
public class ConfiguresExecuteVO extends CommonVO {

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
     * 配置id
     */
    @ApiModelProperty(value = "配置id")
    private Integer configuresId;
    /**
     * zip包下载位置
     */
    @ApiModelProperty(value = "zip包下载位置")
    private String zipDownUrl;
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
     * 连接信息
     */
    @ApiModelProperty(value = "连接信息")
    private String databasesInfo;
    /**
     * 模板信息
     */
    @ApiModelProperty(value = "模板信息")
    private String templatesInfo;
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