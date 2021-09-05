package top.buukle.opensource.arche.generator.dos.vo.templates;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.buukle.business.base.commons.mvc.dto.CommonDTO;

import java.util.Date;

/**
* @author elvin
* @description  Datasources 查询包装类
*/
@Data
@ApiModel(value = "模板 - 响应")
public class TemplatesVO extends CommonDTO {

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
     *
     */
    @ApiModelProperty(value = "应用编码")
    private String applicationCode;
    /**
     * 数据源名称
     */
    @ApiModelProperty(value = "数据源名称")
    private String name;
    /**
     * 生成路径
     */
    @ApiModelProperty(value = "生成路径")
    private String path;
    /**
     * 开启表名目录
     */
    @ApiModelProperty(value = "开启表名目录 1: 开启,0:不开启")
    private String openTablePath;
    /**
     * 包名
     */
    @ApiModelProperty(value = "包名,前端可不填")
    private String packageInfo;
    /**
     * 文件地址
     */
    @ApiModelProperty(value = "文件地址")
    private String url;
    /**
     * 模板类型(entity,dao,xml,service,serviceImpl,controller)
     */
    @ApiModelProperty(value = "模板类型(entity,dao,xml,service,serviceImpl,controller)")
    private String type;
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