package top.buukle.generator.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By zhanglei
 * Description: 
 * 配置执行表
 *
 * @author  zhaongleiqt@chinamobile.com
 */
public class ConfiguresExecute implements Serializable {
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
     * 配置id
     *
     */
    private Integer configuresId;

    /**
     * zip包下载位置
     *
     */
    private String zipDownUrl;

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
     * 连接信息
     *
     */
    private String databasesInfo;

    /**
     * 模板信息
     *
     */
    private String templatesInfo;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.id
     *
     * @return the value of buukle-generator..configures_execute.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public ConfiguresExecute withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.id
     *
     * @param id the value for buukle-generator..configures_execute.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.audit_id
     *
     * @return the value of buukle-generator..configures_execute.audit_id
     */
    public Integer getAuditId() {
        return auditId;
    }

    /**
     */
    public ConfiguresExecute withAuditId(Integer auditId) {
        this.setAuditId(auditId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.audit_id
     *
     * @param auditId the value for buukle-generator..configures_execute.audit_id
     */
    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.configures_id
     *
     * @return the value of buukle-generator..configures_execute.configures_id
     */
    public Integer getConfiguresId() {
        return configuresId;
    }

    /**
     */
    public ConfiguresExecute withConfiguresId(Integer configuresId) {
        this.setConfiguresId(configuresId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.configures_id
     *
     * @param configuresId the value for buukle-generator..configures_execute.configures_id
     */
    public void setConfiguresId(Integer configuresId) {
        this.configuresId = configuresId;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.zip_down_url
     *
     * @return the value of buukle-generator..configures_execute.zip_down_url
     */
    public String getZipDownUrl() {
        return zipDownUrl;
    }

    /**
     */
    public ConfiguresExecute withZipDownUrl(String zipDownUrl) {
        this.setZipDownUrl(zipDownUrl);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.zip_down_url
     *
     * @param zipDownUrl the value for buukle-generator..configures_execute.zip_down_url
     */
    public void setZipDownUrl(String zipDownUrl) {
        this.zipDownUrl = zipDownUrl == null ? null : zipDownUrl.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.application_code
     *
     * @return the value of buukle-generator..configures_execute.application_code
     */
    public String getApplicationCode() {
        return applicationCode;
    }

    /**
     */
    public ConfiguresExecute withApplicationCode(String applicationCode) {
        this.setApplicationCode(applicationCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.application_code
     *
     * @param applicationCode the value for buukle-generator..configures_execute.application_code
     */
    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode == null ? null : applicationCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.dir_location
     *
     * @return the value of buukle-generator..configures_execute.dir_location
     */
    public String getDirLocation() {
        return dirLocation;
    }

    /**
     */
    public ConfiguresExecute withDirLocation(String dirLocation) {
        this.setDirLocation(dirLocation);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.dir_location
     *
     * @param dirLocation the value for buukle-generator..configures_execute.dir_location
     */
    public void setDirLocation(String dirLocation) {
        this.dirLocation = dirLocation == null ? null : dirLocation.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.base_package
     *
     * @return the value of buukle-generator..configures_execute.base_package
     */
    public String getBasePackage() {
        return basePackage;
    }

    /**
     */
    public ConfiguresExecute withBasePackage(String basePackage) {
        this.setBasePackage(basePackage);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.base_package
     *
     * @param basePackage the value for buukle-generator..configures_execute.base_package
     */
    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage == null ? null : basePackage.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.name
     *
     * @return the value of buukle-generator..configures_execute.name
     */
    public String getName() {
        return name;
    }

    /**
     */
    public ConfiguresExecute withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.name
     *
     * @param name the value for buukle-generator..configures_execute.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.url
     *
     * @return the value of buukle-generator..configures_execute.url
     */
    public String getUrl() {
        return url;
    }

    /**
     */
    public ConfiguresExecute withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.url
     *
     * @param url the value for buukle-generator..configures_execute.url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.description
     *
     * @return the value of buukle-generator..configures_execute.description
     */
    public String getDescription() {
        return description;
    }

    /**
     */
    public ConfiguresExecute withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.description
     *
     * @param description the value for buukle-generator..configures_execute.description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.remark
     *
     * @return the value of buukle-generator..configures_execute.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public ConfiguresExecute withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.remark
     *
     * @param remark the value for buukle-generator..configures_execute.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.gmt_created
     *
     * @return the value of buukle-generator..configures_execute.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public ConfiguresExecute withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.gmt_created
     *
     * @param gmtCreated the value for buukle-generator..configures_execute.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.creator
     *
     * @return the value of buukle-generator..configures_execute.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public ConfiguresExecute withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.creator
     *
     * @param creator the value for buukle-generator..configures_execute.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.creator_dept_id
     *
     * @return the value of buukle-generator..configures_execute.creator_dept_id
     */
    public Integer getCreatorDeptId() {
        return creatorDeptId;
    }

    /**
     */
    public ConfiguresExecute withCreatorDeptId(Integer creatorDeptId) {
        this.setCreatorDeptId(creatorDeptId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.creator_dept_id
     *
     * @param creatorDeptId the value for buukle-generator..configures_execute.creator_dept_id
     */
    public void setCreatorDeptId(Integer creatorDeptId) {
        this.creatorDeptId = creatorDeptId;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.creator_code
     *
     * @return the value of buukle-generator..configures_execute.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public ConfiguresExecute withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.creator_code
     *
     * @param creatorCode the value for buukle-generator..configures_execute.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.gmt_modified
     *
     * @return the value of buukle-generator..configures_execute.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public ConfiguresExecute withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.gmt_modified
     *
     * @param gmtModified the value for buukle-generator..configures_execute.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.modifier
     *
     * @return the value of buukle-generator..configures_execute.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public ConfiguresExecute withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.modifier
     *
     * @param modifier the value for buukle-generator..configures_execute.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.modifier_code
     *
     * @return the value of buukle-generator..configures_execute.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public ConfiguresExecute withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.modifier_code
     *
     * @param modifierCode the value for buukle-generator..configures_execute.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.audit_status
     *
     * @return the value of buukle-generator..configures_execute.audit_status
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     */
    public ConfiguresExecute withAuditStatus(Integer auditStatus) {
        this.setAuditStatus(auditStatus);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.audit_status
     *
     * @param auditStatus the value for buukle-generator..configures_execute.audit_status
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.status
     *
     * @return the value of buukle-generator..configures_execute.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public ConfiguresExecute withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.status
     *
     * @param status the value for buukle-generator..configures_execute.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.bak01
     *
     * @return the value of buukle-generator..configures_execute.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public ConfiguresExecute withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.bak01
     *
     * @param bak01 the value for buukle-generator..configures_execute.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.bak02
     *
     * @return the value of buukle-generator..configures_execute.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public ConfiguresExecute withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.bak02
     *
     * @param bak02 the value for buukle-generator..configures_execute.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.bak03
     *
     * @return the value of buukle-generator..configures_execute.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public ConfiguresExecute withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.bak03
     *
     * @param bak03 the value for buukle-generator..configures_execute.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.bak04
     *
     * @return the value of buukle-generator..configures_execute.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public ConfiguresExecute withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.bak04
     *
     * @param bak04 the value for buukle-generator..configures_execute.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.bak05
     *
     * @return the value of buukle-generator..configures_execute.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public ConfiguresExecute withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.bak05
     *
     * @param bak05 the value for buukle-generator..configures_execute.bak05
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.tables
     *
     * @return the value of buukle-generator..configures_execute.tables
     */
    public String getTables() {
        return tables;
    }

    /**
     */
    public ConfiguresExecute withTables(String tables) {
        this.setTables(tables);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.tables
     *
     * @param tables the value for buukle-generator..configures_execute.tables
     */
    public void setTables(String tables) {
        this.tables = tables == null ? null : tables.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.databases_info
     *
     * @return the value of buukle-generator..configures_execute.databases_info
     */
    public String getDatabasesInfo() {
        return databasesInfo;
    }

    /**
     */
    public ConfiguresExecute withDatabasesInfo(String databasesInfo) {
        this.setDatabasesInfo(databasesInfo);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.databases_info
     *
     * @param databasesInfo the value for buukle-generator..configures_execute.databases_info
     */
    public void setDatabasesInfo(String databasesInfo) {
        this.databasesInfo = databasesInfo == null ? null : databasesInfo.trim();
    }

    /**
     * This method returns the value of the database column buukle-generator..configures_execute.templates_info
     *
     * @return the value of buukle-generator..configures_execute.templates_info
     */
    public String getTemplatesInfo() {
        return templatesInfo;
    }

    /**
     */
    public ConfiguresExecute withTemplatesInfo(String templatesInfo) {
        this.setTemplatesInfo(templatesInfo);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-generator..configures_execute.templates_info
     *
     * @param templatesInfo the value for buukle-generator..configures_execute.templates_info
     */
    public void setTemplatesInfo(String templatesInfo) {
        this.templatesInfo = templatesInfo == null ? null : templatesInfo.trim();
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
        sb.append(", configuresId=").append(configuresId);
        sb.append(", zipDownUrl=").append(zipDownUrl);
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
        sb.append(", databasesInfo=").append(databasesInfo);
        sb.append(", templatesInfo=").append(templatesInfo);
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
        ConfiguresExecute other = (ConfiguresExecute) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuditId() == null ? other.getAuditId() == null : this.getAuditId().equals(other.getAuditId()))
            && (this.getConfiguresId() == null ? other.getConfiguresId() == null : this.getConfiguresId().equals(other.getConfiguresId()))
            && (this.getZipDownUrl() == null ? other.getZipDownUrl() == null : this.getZipDownUrl().equals(other.getZipDownUrl()))
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
            && (this.getDatabasesInfo() == null ? other.getDatabasesInfo() == null : this.getDatabasesInfo().equals(other.getDatabasesInfo()))
            && (this.getTemplatesInfo() == null ? other.getTemplatesInfo() == null : this.getTemplatesInfo().equals(other.getTemplatesInfo()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAuditId() == null) ? 0 : getAuditId().hashCode());
        result = prime * result + ((getConfiguresId() == null) ? 0 : getConfiguresId().hashCode());
        result = prime * result + ((getZipDownUrl() == null) ? 0 : getZipDownUrl().hashCode());
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
        result = prime * result + ((getDatabasesInfo() == null) ? 0 : getDatabasesInfo().hashCode());
        result = prime * result + ((getTemplatesInfo() == null) ? 0 : getTemplatesInfo().hashCode());
        return result;
    }
}