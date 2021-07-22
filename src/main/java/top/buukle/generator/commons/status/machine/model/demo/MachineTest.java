/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: Tess
 * Author:   86180
 * Date:     2021/2/25 21:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.commons.status.machine.model.demo;

import top.buukle.generator.commons.status.machine.Machine;
import top.buukle.generator.commons.status.machine.model.interfac.Actions;
import top.buukle.generator.commons.status.machine.structure.ActionStatus;
import top.buukle.generator.commons.status.machine.structure.StatusCouple;

import java.util.Map;

/**
 * @description 〈〉
 * @author 86180
 * @create 2021/2/25
 * @since 1.0.0
 */
public class MachineTest {

    public static void main(String[] args) {
        Map<Actions, String> targetActionsWithStatus = Machine.getTargetActionsWithStatus(new StatusCouple(DemoMasterStatus.M_INIT, DemoAuditStatus.A_INIT), new DemoCirculationListTable());
        System.out.println(targetActionsWithStatus.toString());
        StatusCouple targetStatusWithAction = Machine.getTargetStatusWithAction(new ActionStatus(DemoActions.APPLY_STOP, DemoMasterStatus.M_PUBLISHED, DemoAuditStatus.AC_PASS), new DemoCirculationListTable());
        System.out.println(targetStatusWithAction.toString());
    }
}