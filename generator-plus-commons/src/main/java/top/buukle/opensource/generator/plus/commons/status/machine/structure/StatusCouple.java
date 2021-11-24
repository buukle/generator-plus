/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: StatusDTO
 * Author:   86180
 * Date:     2021/2/25 3:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.generator.plus.commons.status.machine.structure;


import lombok.Data;
import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.AuditStatus;
import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.MasterStatus;

import java.util.Objects;

/**
 * @description 〈〉
 * @author 86180
 * @create 2021/2/25
 * @since 1.0.0
 */
@Data
public class StatusCouple {

    private Integer masterStatusValue;
    private String masterStatusDescription;
    private Integer auditStatusValue;
    private String auditStatusDescription;

    public StatusCouple(MasterStatus masterStatus, AuditStatus auditStatus) {
        this.masterStatusValue = masterStatus.value();
        this.auditStatusValue = auditStatus.value();
        this.masterStatusDescription = masterStatus.getDescription();
        this.auditStatusDescription = auditStatus.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusCouple that = (StatusCouple) o;
        return Objects.equals(masterStatusValue, that.masterStatusValue)
                && Objects.equals(auditStatusValue, that.auditStatusValue)
                && Objects.equals(masterStatusDescription, that.masterStatusDescription)
                && Objects.equals(auditStatusDescription, that.auditStatusDescription)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterStatusValue, auditStatusValue,masterStatusDescription,auditStatusDescription);
    }

    @Override
    public String toString() {
        return "StatusValueCouple{" +
                "masterStatusValue=" + masterStatusValue +
                ", masterStatusDescription='" + masterStatusDescription + '\'' +
                ", auditStatusValue=" + auditStatusValue +
                ", auditStatusDescription='" + auditStatusDescription + '\'' +
                '}';
    }
}