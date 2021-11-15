package top.buukle.opensource.generator.plus.dos.dto.datasources;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
* @author elvin
* @description  Datasources 查询包装类
*/
@Data
@ApiModel(value = "连接 - 更新请求")
public class DatasourcesUpdateDTO {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键", required = true)
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
     * 审核状态  -1:待提交 0:提交审核  1:审核中 2: 审核不通过 3:审核通过
     */
    @ApiModelProperty(value = "审核状态  -1:待提交 0:提交审核  1:审核中 2: 审核不通过 3:审核通过")
    private Integer auditStatus;
    /**
     *  状态 -1:已删除 0:创建完成 1:审核中 2: 停用 3: 正常
     */
    @ApiModelProperty(value = "状态 -1:已删除 0:创建完成 1:审核中 2: 停用 3: 正常")
    private Integer status;


}