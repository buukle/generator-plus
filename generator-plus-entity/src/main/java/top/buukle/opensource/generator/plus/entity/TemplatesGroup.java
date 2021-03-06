package top.buukle.opensource.generator.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 模板分组
 * </p>
 *
 * @author
 * @since 2021-10-15
 */
@Data
@TableName("templates_group")

public class TemplatesGroup implements Serializable {

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
     *
     */
    private String applicationCode;
    /**
     * 模板分组名称
     */
    private String name;
    /**
     * 模板分组自定义变量
     */
    private String params;
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
