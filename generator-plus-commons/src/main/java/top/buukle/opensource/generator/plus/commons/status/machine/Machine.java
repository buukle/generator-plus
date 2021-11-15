package top.buukle.opensource.generator.plus.commons.status.machine;

import org.springframework.util.CollectionUtils;
import top.buukle.opensource.generator.plus.commons.call.code.BaseReturnEnum;
import top.buukle.opensource.generator.plus.commons.exception.CommonException;
import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.Actions;
import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.CirculationListTable;
import top.buukle.opensource.generator.plus.commons.status.machine.structure.ActionStatus;
import top.buukle.opensource.generator.plus.commons.status.machine.structure.StatusCouple;
import top.buukle.opensource.generator.plus.commons.status.machine.structure.StatusTable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Author: elvin
 * @Date: 2019/7/28/028 3:56
 */
public interface Machine {


    ConcurrentHashMap<StatusCouple,Map<Actions, String>>  CACHE_TARGET_ACTIONS_MAP = new ConcurrentHashMap();

    /**
     * @description 根据现有状态 获取 合法 ACTION 集
     * @param statusCouple
     * @param circulationListTable
     * @return java.util.Map<top.buukle.generator.commons.status.machine.model.interfac.Actions,java.lang.String>
     * @Author 86180
     * @Date 2021/2/26
     */
    static Map<Actions, String> getTargetActionsWithStatus(StatusCouple statusCouple, CirculationListTable circulationListTable) {

        Map<Actions, String> targetActions = new HashMap<>(32);

        if (null == statusCouple || statusCouple.getAuditStatusValue() == null ||  statusCouple.getMasterStatusValue() == null) {
            return targetActions;
        }
        Map<Actions, String> targetActionsCache = CACHE_TARGET_ACTIONS_MAP.get(statusCouple);
        if(null != targetActionsCache){
//            System.out.println("命中本地缓存,key : " + statusValueCouple.toString());
            return targetActionsCache;
        }
        for(StatusTable statusTable : circulationListTable.listTable()){
            if (statusTable.getCurrentMasterStatus().equals(statusCouple.getMasterStatusValue()) && statusTable.getCurrentAuditStatus().equals(statusCouple.getAuditStatusValue())) {
                Actions allowAction = statusTable.getAllowAction();
                targetActions.put(allowAction, allowAction.getActionDesc());
            }
        }
        if(!CollectionUtils.isEmpty(targetActions)){
            CACHE_TARGET_ACTIONS_MAP.put(statusCouple,targetActions);
        }
        return targetActions;
    }

    ConcurrentHashMap<ActionStatus, StatusCouple>  CACHE_TARGET_STATUS_MAP = new ConcurrentHashMap();


    /**
     * @description 根据ACTION获取 合法流转状态集
     * @param actionStatus
     * @param circulationListTable
     * @return top.buukle.generator.commons.status.machine.structure.StatusValueCouple
     * @Author 86180
     * @Date 2021/2/26
     */
    static StatusCouple getTargetStatusWithAction(ActionStatus actionStatus, CirculationListTable circulationListTable) {

        StatusCouple targetStatusCoupleCache = CACHE_TARGET_STATUS_MAP.get(actionStatus);
        if(null != targetStatusCoupleCache){
//            System.out.println("命中本地缓存,key : " + actionStatus.toString());
            return targetStatusCoupleCache;
        }
        int count = 0;
        StatusCouple targetStatusCouple = null;
        for(StatusTable  statusTable : circulationListTable.listTable()){
            if (actionStatus.getAction().equals(statusTable.getAllowAction()) && actionStatus.getMasterStatus().value().equals(statusTable.getCurrentMasterStatus()) && actionStatus.getAuditStatus().value().equals(statusTable.getCurrentAuditStatus())) {
                targetStatusCouple = new StatusCouple(actionStatus.getMasterStatus().getEnumWithValue(statusTable.getTargetMasterStatus()),actionStatus.getAuditStatus().getEnumWithValue(statusTable.getTargetAuditStatus()));
                count ++;
            }
        }
        if(count == 0){
            throw new CommonException(BaseReturnEnum.STATUS_MACHINE_TARGET_NULL);
        }
        if(count >  1){
            throw new CommonException(BaseReturnEnum.STATUS_MACHINE_TARGET_MULTI);
        }
        if(count == 1){
            CACHE_TARGET_STATUS_MAP.put(actionStatus,targetStatusCouple);
        }
        return targetStatusCouple;
    }

}