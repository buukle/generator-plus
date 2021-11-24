/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: StatusTable
 * Author:   86180
 * Date:     2021/2/25 14:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.generator.plus.commons.status.machine.structure;


import lombok.Data;
import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.Actions;

/**
 * @description 〈〉
 * @author 86180
 * @create 2021/2/25
 * @since 1.0.0
 */
@Data
public class StatusTable {

    private Integer currentMasterStatus;

    private Integer currentAuditStatus;

    private Actions allowAction;

    private Integer targetAuditStatus;

    private Integer targetMasterStatus;


    public StatusTable(Integer currentMasterStatus, Integer currentAuditStatus, Actions allowAction, Integer  targetAuditStatus, Integer targetMasterStatus) {
        this.currentMasterStatus = currentMasterStatus;
        this.currentAuditStatus = currentAuditStatus;
        this.allowAction = allowAction;
        this.targetAuditStatus = targetAuditStatus;
        this.targetMasterStatus = targetMasterStatus;
    }

    @Override
    public String toString() {
        return "StatusTable{" +
                "currentMasterStatus=" + currentMasterStatus +
                ", currentAuditStatus=" + currentAuditStatus +
                ", allowAction=" + allowAction +
                ", targetAuditStatus=" + targetAuditStatus +
                ", targetMasterStatus=" + targetMasterStatus +
                '}';
    }
}