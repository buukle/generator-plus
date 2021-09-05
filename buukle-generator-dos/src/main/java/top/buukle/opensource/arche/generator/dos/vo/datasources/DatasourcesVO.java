package top.buukle.opensource.arche.generator.dos.vo.datasources;

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
@ApiModel(value = "连接 - 查询响应")
public class DatasourcesVO extends CommonVO {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
     * 数据源名称
     */
    @ApiModelProperty(value = "数据源名称")
    private String name;

    /**
     * url
     */
    @ApiModelProperty(value = "url")
    private String url;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "数据源用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "数据源密码")
    private String password;

    /**
     * 数据库名称
     */
    @ApiModelProperty(value = "数据库名称")
    private String databaseName;

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
     * 备注
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 状态
     */
    @ApiModelProperty(value = "审核状态")
    private Integer auditStatus;

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