package top.buukle.generator.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 模板表
 *
 * @author  dongzuozheng
 */
public class Templates implements Serializable {
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
     * 文件地址
     *
     */
    private String url;

    /**
     * 模板类型(entity,dao,xml,service,serviceImpl,controller)
     *
     */
    private String type;

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
     * 内容
     *
     */
    private String content;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-generator..templates.id
     *
     * @return the value of buukle-generator..templates.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public Templates withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.id
     *
     * @param id the value for buukle-generator..templates.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.audit_id
     *
     * @return the value of buukle-generator..templates.audit_id
     */
    public Integer getAuditId() {
        return auditId;
    }

    /**
     */
    public Templates withAuditId(Integer auditId) {
        this.setAuditId(auditId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.audit_id
     *
     * @param auditId the value for buukle-generator..templates.audit_id
     */
    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.application_code
     *
     * @return the value of buukle-generator..templates.application_code
     */
    public String getApplicationCode() {
        return applicationCode;
    }

    /**
     */
    public Templates withApplicationCode(String applicationCode) {
        this.setApplicationCode(applicationCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.application_code
     *
     * @param applicationCode the value for buukle-generator..templates.application_code
     */
    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode == null ? null : applicationCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.name
     *
     * @return the value of buukle-generator..templates.name
     */
    public String getName() {
        return name;
    }

    /**
     */
    public Templates withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.name
     *
     * @param name the value for buukle-generator..templates.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.url
     *
     * @return the value of buukle-generator..templates.url
     */
    public String getUrl() {
        return url;
    }

    /**
     */
    public Templates withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.url
     *
     * @param url the value for buukle-generator..templates.url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.type
     *
     * @return the value of buukle-generator..templates.type
     */
    public String getType() {
        return type;
    }

    /**
     */
    public Templates withType(String type) {
        this.setType(type);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.type
     *
     * @param type the value for buukle-generator..templates.type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.description
     *
     * @return the value of buukle-generator..templates.description
     */
    public String getDescription() {
        return description;
    }

    /**
     */
    public Templates withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.description
     *
     * @param description the value for buukle-generator..templates.description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.remark
     *
     * @return the value of buukle-generator..templates.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public Templates withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.remark
     *
     * @param remark the value for buukle-generator..templates.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.gmt_created
     *
     * @return the value of buukle-generator..templates.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public Templates withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.gmt_created
     *
     * @param gmtCreated the value for buukle-generator..templates.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.creator
     *
     * @return the value of buukle-generator..templates.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public Templates withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.creator
     *
     * @param creator the value for buukle-generator..templates.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.creator_dept_id
     *
     * @return the value of buukle-generator..templates.creator_dept_id
     */
    public Integer getCreatorDeptId() {
        return creatorDeptId;
    }

    /**
     */
    public Templates withCreatorDeptId(Integer creatorDeptId) {
        this.setCreatorDeptId(creatorDeptId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.creator_dept_id
     *
     * @param creatorDeptId the value for buukle-generator..templates.creator_dept_id
     */
    public void setCreatorDeptId(Integer creatorDeptId) {
        this.creatorDeptId = creatorDeptId;
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.creator_code
     *
     * @return the value of buukle-generator..templates.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public Templates withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.creator_code
     *
     * @param creatorCode the value for buukle-generator..templates.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.gmt_modified
     *
     * @return the value of buukle-generator..templates.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public Templates withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.gmt_modified
     *
     * @param gmtModified the value for buukle-generator..templates.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.modifier
     *
     * @return the value of buukle-generator..templates.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public Templates withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.modifier
     *
     * @param modifier the value for buukle-generator..templates.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.modifier_code
     *
     * @return the value of buukle-generator..templates.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public Templates withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.modifier_code
     *
     * @param modifierCode the value for buukle-generator..templates.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.audit_status
     *
     * @return the value of buukle-generator..templates.audit_status
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     */
    public Templates withAuditStatus(Integer auditStatus) {
        this.setAuditStatus(auditStatus);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.audit_status
     *
     * @param auditStatus the value for buukle-generator..templates.audit_status
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.status
     *
     * @return the value of buukle-generator..templates.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public Templates withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.status
     *
     * @param status the value for buukle-generator..templates.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.bak01
     *
     * @return the value of buukle-generator..templates.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public Templates withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.bak01
     *
     * @param bak01 the value for buukle-generator..templates.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.bak02
     *
     * @return the value of buukle-generator..templates.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public Templates withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.bak02
     *
     * @param bak02 the value for buukle-generator..templates.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.bak03
     *
     * @return the value of buukle-generator..templates.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public Templates withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.bak03
     *
     * @param bak03 the value for buukle-generator..templates.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.bak04
     *
     * @return the value of buukle-generator..templates.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public Templates withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.bak04
     *
     * @param bak04 the value for buukle-generator..templates.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.bak05
     *
     * @return the value of buukle-generator..templates.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public Templates withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.bak05
     *
     * @param bak05 the value for buukle-generator..templates.bak05
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..templates.content
     *
     * @return the value of buukle-generator..templates.content
     */
    public String getContent() {
        return content;
    }

    /**
     */
    public Templates withContent(String content) {
        this.setContent(content);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..templates.content
     *
     * @param content the value for buukle-generator..templates.content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", auditId=").append(auditId);
        sb.append(", applicationCode=").append(applicationCode);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", type=").append(type);
        sb.append(", description=").append(description);
        sb.append(", remark=").append(remark);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", creator=").append(creator);
        sb.append(", creatorDeptId=").append(creatorDeptId);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", status=").append(status);
        sb.append(", bak01=").append(bak01);
        sb.append(", bak02=").append(bak02);
        sb.append(", bak03=").append(bak03);
        sb.append(", bak04=").append(bak04);
        sb.append(", bak05=").append(bak05);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }

    /**
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Templates other = (Templates) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuditId() == null ? other.getAuditId() == null : this.getAuditId().equals(other.getAuditId()))
            && (this.getApplicationCode() == null ? other.getApplicationCode() == null : this.getApplicationCode().equals(other.getApplicationCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorDeptId() == null ? other.getCreatorDeptId() == null : this.getCreatorDeptId().equals(other.getCreatorDeptId()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getAuditStatus() == null ? other.getAuditStatus() == null : this.getAuditStatus().equals(other.getAuditStatus()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAuditId() == null) ? 0 : getAuditId().hashCode());
        result = prime * result + ((getApplicationCode() == null) ? 0 : getApplicationCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorDeptId() == null) ? 0 : getCreatorDeptId().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getAuditStatus() == null) ? 0 : getAuditStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}