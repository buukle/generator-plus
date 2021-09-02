package top.buukle.generator.entity.dto.datasources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import top.buukle.generator.commons.mvc.dto.CommonDTO;


/**
* @author elvin
* @description  Datasources 查询包装类
*/
@Data
@ApiModel(value = "连接 - 查询请求")
public class DatasourcesQueryDTO implements CommonDTO {

    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码")
    private Integer pageNo;
    /**
     * 页长
     */
    @ApiModelProperty(value = "页长")
    @Builder.Default
    private Integer pageSize = 10;
    /**
     * 起始时间
     */
    @ApiModelProperty(value = "起始时间")
    private String startTime;
    /**
     * 截止时间
     */
    @ApiModelProperty(value = "截止时间")
    private String endTime;

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

}