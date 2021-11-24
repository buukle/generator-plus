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
import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.Actions;
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
public class ActionStatus {

    private MasterStatus masterStatus;
    private AuditStatus auditStatus;
    private Actions action;

    public ActionStatus(Actions action, MasterStatus masterStatus, AuditStatus auditStatus) {
        this.action = action;
        this.masterStatus = masterStatus;
        this.auditStatus = auditStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionStatus)) return false;
        ActionStatus that = (ActionStatus) o;
        return  getMasterStatus().value().equals(that.getMasterStatus().value()) &&
                 getAuditStatus().value().equals(that.getAuditStatus().value())  &&
                Objects.equals(getAction(), that.getAction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMasterStatus().value(), getAuditStatus().value(), getAction());
    }

    @Override
    public String toString() {
        return "ActionStatus{" +
                "masterStatus=" + masterStatus +
                ", auditStatus=" + auditStatus +
                ", action=" + action +
                '}';
    }
}