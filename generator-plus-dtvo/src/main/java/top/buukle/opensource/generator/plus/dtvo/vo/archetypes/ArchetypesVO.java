package top.buukle.opensource.generator.plus.dtvo.vo.archetypes;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 应用表
 * </p>
 *
 * @author 
 * @since 2021-09-16
 */
@Data
@ApiModel(value = " 应用表 - 响应")
public class ArchetypesVO {

    
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
    @ApiModelProperty(value = "")
    private String applicationCode;
    /**
     * 数据源名称
     */
    @ApiModelProperty(value = "数据源名称")
    private String name;
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String url;
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
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date gmtCreated;
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String creator;
    /**
     * 创建者部门id
     */
    @ApiModelProperty(value = "创建者部门id")
    private Integer creatorTenantId;
    /**
     * 创建者UID
     */
    @ApiModelProperty(value = "创建者UID")
    private String creatorCode;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String modifier;
    /**
     * 更新者UID
     */
    @ApiModelProperty(value = "更新者UID")
    private String modifierCode;
    /**
     * 审核状态  -1:待提交 0:提交审核  1:审核中 2: 审核不通过 3:审核通过
     */
    @ApiModelProperty(value = "审核状态  -1:待提交 0:提交审核  1:审核中 2: 审核不通过 3:审核通过")
    private Integer auditStatus;
    /**
     *  状态 -1:已删除 0:创建完成 1:审核中 2: 停用 3: 正常
     */
    @ApiModelProperty(value = " 状态 -1:已删除 0:创建完成 1:审核中 2: 停用 3: 正常")
    private Integer status;
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String bak01;
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String bak02;
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String bak03;
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String bak04;
    /**
     * 
     */
    @ApiModelProperty(value = "")
    private String bak05;

}