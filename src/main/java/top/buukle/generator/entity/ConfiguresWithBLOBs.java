package top.buukle.generator.entity;

import java.io.Serializable;

/**
 * Created By zhanglei
 * Description: 
 * 配置表
 *
 * @author  zhaongleiqt@chinamobile.com
 */
public class ConfiguresWithBLOBs extends top.buukle.generator.entity.Configures implements Serializable {
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
     * This method returns the value of the database column buukle-generator..configures.tables
     *
     * @return the value of buukle-generator..configures.tables
     */
    public String getTables() {
        return tables;
    }

    /**
     */
    public ConfiguresWithBLOBs withTables(String tables) {
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
    public ConfiguresWithBLOBs withContent(String content) {
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
        ConfiguresWithBLOBs other = (ConfiguresWithBLOBs) that;
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