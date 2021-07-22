package top.buukle.generator.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By zhanglei
 * Description: 
 * 配置表
 *
 * @author  zhaongleiqt@chinamobile.com
 */
public class Configures implements Serializable {
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
     * 连接id
     *
     */
    private Integer datasourcesId;

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
     * 内容
     *
     */
    private String content;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-generator..configures.id
     *
     * @return the value of buukle-generator..configures.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public Configures withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.id
     *
     * @param id the value for buukle-generator..configures.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.audit_id
     *
     * @return the value of buukle-generator..configures.audit_id
     */
    public Integer getAuditId() {
        return auditId;
    }

    /**
     */
    public Configures withAuditId(Integer auditId) {
        this.setAuditId(auditId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.audit_id
     *
     * @param auditId the value for buukle-generator..configures.audit_id
     */
    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.datasources_id
     *
     * @return the value of buukle-generator..configures.datasources_id
     */
    public Integer getDatasourcesId() {
        return datasourcesId;
    }

    /**
     */
    public Configures withDatasourcesId(Integer datasourcesId) {
        this.setDatasourcesId(datasourcesId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.datasources_id
     *
     * @param datasourcesId the value for buukle-generator..configures.datasources_id
     */
    public void setDatasourcesId(Integer datasourcesId) {
        this.datasourcesId = datasourcesId;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.application_code
     *
     * @return the value of buukle-generator..configures.application_code
     */
    public String getApplicationCode() {
        return applicationCode;
    }

    /**
     */
    public Configures withApplicationCode(String applicationCode) {
        this.setApplicationCode(applicationCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.application_code
     *
     * @param applicationCode the value for buukle-generator..configures.application_code
     */
    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode == null ? null : applicationCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.dir_location
     *
     * @return the value of buukle-generator..configures.dir_location
     */
    public String getDirLocation() {
        return dirLocation;
    }

    /**
     */
    public Configures withDirLocation(String dirLocation) {
        this.setDirLocation(dirLocation);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.dir_location
     *
     * @param dirLocation the value for buukle-generator..configures.dir_location
     */
    public void setDirLocation(String dirLocation) {
        this.dirLocation = dirLocation == null ? null : dirLocation.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.base_package
     *
     * @return the value of buukle-generator..configures.base_package
     */
    public String getBasePackage() {
        return basePackage;
    }

    /**
     */
    public Configures withBasePackage(String basePackage) {
        this.setBasePackage(basePackage);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.base_package
     *
     * @param basePackage the value for buukle-generator..configures.base_package
     */
    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage == null ? null : basePackage.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.name
     *
     * @return the value of buukle-generator..configures.name
     */
    public String getName() {
        return name;
    }

    /**
     */
    public Configures withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.name
     *
     * @param name the value for buukle-generator..configures.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.url
     *
     * @return the value of buukle-generator..configures.url
     */
    public String getUrl() {
        return url;
    }

    /**
     */
    public Configures withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.url
     *
     * @param url the value for buukle-generator..configures.url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.description
     *
     * @return the value of buukle-generator..configures.description
     */
    public String getDescription() {
        return description;
    }

    /**
     */
    public Configures withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.description
     *
     * @param description the value for buukle-generator..configures.description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.remark
     *
     * @return the value of buukle-generator..configures.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public Configures withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.remark
     *
     * @param remark the value for buukle-generator..configures.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.gmt_created
     *
     * @return the value of buukle-generator..configures.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public Configures withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.gmt_created
     *
     * @param gmtCreated the value for buukle-generator..configures.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.creator
     *
     * @return the value of buukle-generator..configures.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public Configures withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.creator
     *
     * @param creator the value for buukle-generator..configures.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.creator_dept_id
     *
     * @return the value of buukle-generator..configures.creator_dept_id
     */
    public Integer getCreatorDeptId() {
        return creatorDeptId;
    }

    /**
     */
    public Configures withCreatorDeptId(Integer creatorDeptId) {
        this.setCreatorDeptId(creatorDeptId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.creator_dept_id
     *
     * @param creatorDeptId the value for buukle-generator..configures.creator_dept_id
     */
    public void setCreatorDeptId(Integer creatorDeptId) {
        this.creatorDeptId = creatorDeptId;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.creator_code
     *
     * @return the value of buukle-generator..configures.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public Configures withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.creator_code
     *
     * @param creatorCode the value for buukle-generator..configures.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.gmt_modified
     *
     * @return the value of buukle-generator..configures.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public Configures withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.gmt_modified
     *
     * @param gmtModified the value for buukle-generator..configures.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.modifier
     *
     * @return the value of buukle-generator..configures.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public Configures withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.modifier
     *
     * @param modifier the value for buukle-generator..configures.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.modifier_code
     *
     * @return the value of buukle-generator..configures.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public Configures withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.modifier_code
     *
     * @param modifierCode the value for buukle-generator..configures.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.audit_status
     *
     * @return the value of buukle-generator..configures.audit_status
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     */
    public Configures withAuditStatus(Integer auditStatus) {
        this.setAuditStatus(auditStatus);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.audit_status
     *
     * @param auditStatus the value for buukle-generator..configures.audit_status
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.status
     *
     * @return the value of buukle-generator..configures.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public Configures withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.status
     *
     * @param status the value for buukle-generator..configures.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.bak01
     *
     * @return the value of buukle-generator..configures.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public Configures withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.bak01
     *
     * @param bak01 the value for buukle-generator..configures.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.bak02
     *
     * @return the value of buukle-generator..configures.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public Configures withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.bak02
     *
     * @param bak02 the value for buukle-generator..configures.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.bak03
     *
     * @return the value of buukle-generator..configures.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public Configures withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.bak03
     *
     * @param bak03 the value for buukle-generator..configures.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.bak04
     *
     * @return the value of buukle-generator..configures.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public Configures withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.bak04
     *
     * @param bak04 the value for buukle-generator..configures.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.bak05
     *
     * @return the value of buukle-generator..configures.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public Configures withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.bak05
     *
     * @param bak05 the value for buukle-generator..configures.bak05
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.tables
     *
     * @return the value of buukle-generator..configures.tables
     */
    public String getTables() {
        return tables;
    }

    /**
     */
    public Configures withTables(String tables) {
        this.setTables(tables);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.tables
     *
     * @param tables the value for buukle-generator..configures.tables
     */
    public void setTables(String tables) {
        this.tables = tables == null ? null : tables.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures.content
     *
     * @return the value of buukle-generator..configures.content
     */
    public String getContent() {
        return content;
    }

    /**
     */
    public Configures withContent(String content) {
        this.setContent(content);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures.content
     *
     * @param content the value for buukle-generator..configures.content
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
        sb.append(", datasourcesId=").append(datasourcesId);
        sb.append(", applicationCode=").append(applicationCode);
        sb.append(", dirLocation=").append(dirLocation);
        sb.append(", basePackage=").append(basePackage);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
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
        sb.append(", tables=").append(tables);
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
        Configures other = (Configures) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuditId() == null ? other.getAuditId() == null : this.getAuditId().equals(other.getAuditId()))
            && (this.getDatasourcesId() == null ? other.getDatasourcesId() == null : this.getDatasourcesId().equals(other.getDatasourcesId()))
            && (this.getApplicationCode() == null ? other.getApplicationCode() == null : this.getApplicationCode().equals(other.getApplicationCode()))
            && (this.getDirLocation() == null ? other.getDirLocation() == null : this.getDirLocation().equals(other.getDirLocation()))
            && (this.getBasePackage() == null ? other.getBasePackage() == null : this.getBasePackage().equals(other.getBasePackage()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
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
            && (this.getTables() == null ? other.getTables() == null : this.getTables().equals(other.getTables()))
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
        result = prime * result + ((getDatasourcesId() == null) ? 0 : getDatasourcesId().hashCode());
        result = prime * result + ((getApplicationCode() == null) ? 0 : getApplicationCode().hashCode());
        result = prime * result + ((getDirLocation() == null) ? 0 : getDirLocation().hashCode());
        result = prime * result + ((getBasePackage() == null) ? 0 : getBasePackage().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
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
        result = prime * result + ((getTables() == null) ? 0 : getTables().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}