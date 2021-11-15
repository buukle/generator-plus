/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: STATUS_TABLE
 * Author:   86180
 * Date:     2021/2/25 18:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.generator.plus.commons.status.machine.model.demo;


import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.CirculationListTable;
import top.buukle.opensource.generator.plus.commons.status.machine.structure.StatusTable;

import java.util.ArrayList;

/**
 * @description 〈〉
 * @author 86180
 * @create 2021/2/25
 * @since 1.0.0
 */
public class DemoCirculationListTable implements CirculationListTable {

    public static  final ArrayList<StatusTable> LIST_TABLE = new ArrayList<>();

    static{

/*-|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-
   |                                                                                                               状态机设计                                                                                                                                          |
   |------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                                                                                                                                                                                                                        |
 * |                             主状态                                      |                     审核状态                         |           允许的 ACTIONS              |               流转审核状态                |                      流转主状态                  |
 *-|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-
 */
        /*   主状态为创建完成 M_INIT(0,"创建完成")   */
//                                              M_INIT(0,"创建完成")                  A_INIT(0,"初始化")                                EDIT -[编辑]                            A_INIT(0,"初始化")                  		   M_INIT(0,"创建完成")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.A_INIT.value(),                   DemoActions.EDIT,                       DemoAuditStatus.A_INIT.value(),          	   DemoMasterStatus.M_INIT .value()));
//                                              M_INIT(0,"创建完成")                  A_INIT(0,"初始化")                                DELETE-[删除]                           A_INIT(0,"初始化")                  		   M_DELETED(-1,"已删除")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.A_INIT.value(),                   DemoActions.DELETE,                     DemoAuditStatus.A_INIT.value(),          	   DemoMasterStatus.M_DELETED .value()));
//                                              M_INIT(0,"创建完成")                  A_INIT(0,"初始化")                                APPLY_PUBLISH-[申请发布]                AP_TOBE_AUDITED(1,"发布待审核")    		       M_INIT(0,"创建完成")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.A_INIT.value(),                   DemoActions.APPLY_PUBLISH,              DemoAuditStatus.AP_TOBE_AUDITED.value(), 	   DemoMasterStatus.M_INIT .value()));
//                                              M_INIT(0,"创建完成")                  AP_TOBE_AUDITED(1,"发布待审核")                   RESUME_APPLY_PUBLISH-[撤回发布申请]     A_INIT(0,"初始化")                		       M_INIT(0,"创建完成")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.AP_TOBE_AUDITED.value(),          DemoActions.RESUME_APPLY_PUBLISH,       DemoAuditStatus.A_INIT.value(),          	   DemoMasterStatus.M_INIT .value()));
//                                              M_INIT(0,"创建完成")                  AP_TOBE_AUDITED(1,"发布待审核")                   READ_PUBLISH_APPLY-[已读发布申请]       AP_AUDITING(2,"发布审核中")       		       M_INIT(0,"创建完成")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.AP_TOBE_AUDITED.value(),          DemoActions.READ_PUBLISH_APPLY,         DemoAuditStatus.AP_AUDITING.value(),     	   DemoMasterStatus.M_INIT .value()));
//                                              M_INIT(0,"创建完成")                  AP_AUDITING(2,"发布审核中")                       PASS_PUBLISH_APPLY-[通过发布申请]       AP_PASS(3,"发布审核通过")         		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.AP_AUDITING.value(),              DemoActions.PASS_PUBLISH_APPLY,         DemoAuditStatus.AP_PASS.value(),         	   DemoMasterStatus.M_PUBLISHED .value()));
//                                              M_INIT(0,"创建完成")                  AP_AUDITING(2,"发布审核中")                       REJECT_PUBLISH_APPLY-[驳回发布申请]     AP_REJECT(4,"发布审核驳回")       		       M_INIT(0,"创建完成")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.AP_AUDITING.value(),              DemoActions.REJECT_PUBLISH_APPLY,       DemoAuditStatus.AP_REJECT.value(),       	   DemoMasterStatus.M_INIT .value()));
//                                              M_INIT(0,"创建完成")                  AP_REJECT(4,"发布审核驳回")                       EDIT-[编辑]                             AP_REJECT(4,"发布审核驳回")        		       M_INIT(0,"创建完成")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.AP_REJECT.value(),                DemoActions.EDIT,                       DemoAuditStatus.AP_REJECT.value(),       	   DemoMasterStatus.M_INIT .value()));
//                                              M_INIT(0,"创建完成")                  AP_REJECT(4,"发布审核驳回")                       APPLY_PUBLISH-[申请发布]                AP_TOBE_AUDITED(1,"发布待审核")    		       M_INIT(0,"创建完成")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus.M_INIT.value(),               DemoAuditStatus.AP_REJECT.value(),                DemoActions.APPLY_PUBLISH,              DemoAuditStatus.AP_TOBE_AUDITED .value(),	   DemoMasterStatus.M_INIT .value()));

        /*   主状态为已发布 M_PUBLISHED(3,"已发布")   */

        // M_PUBLISHED - 停用流程
//                                               M_PUBLISHED(3,"已发布")              AP_PASS(3,"发布审核通过")                         APPLY_STOP-[申请停用]                   AS_TOBE_AUDITED(5,"停用待审核")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AP_PASS.value(),                 DemoActions.APPLY_STOP,                 DemoAuditStatus.AS_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AO_PASS(11,"启用审核通过")                        APPLY_STOP-[申请停用]                   AS_TOBE_AUDITED(5,"停用待审核")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AO_PASS.value(),                 DemoActions.APPLY_STOP,                 DemoAuditStatus.AS_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AS_CANCEL(18,"取消停用申请")                      APPLY_STOP-[申请停用]                   AS_TOBE_AUDITED(5,"停用待审核")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AS_CANCEL.value(),               DemoActions.APPLY_STOP,                 DemoAuditStatus.AS_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AC_PASS(16,"变更审核通过")                        APPLY_STOP-[申请停用]                   AS_TOBE_AUDITED(5,"停用待审核")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_PASS.value(),                 DemoActions.APPLY_STOP,                 DemoAuditStatus.AS_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AC_REJECT(17,"变更审核驳回")                      APPLY_STOP-[申请停用]                   AS_TOBE_AUDITED(5,"停用待审核")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_REJECT.value(),               DemoActions.APPLY_STOP,                 DemoAuditStatus.AS_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AC_CANCEL(14,"取消变更申请")                      APPLY_STOP-[申请停用]                   AS_TOBE_AUDITED(5,"停用待审核")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_CANCEL.value(),               DemoActions.APPLY_STOP,                 DemoAuditStatus.AS_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));

//                                               M_PUBLISHED(3,"已发布")              AS_TOBE_AUDITED(5,"停用待审核")                   CANCEL_APPLY_STOP-[取消停用申请]        AS_CANCEL(18,"取消停用申请")      		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AS_TOBE_AUDITED.value(),         DemoActions.CANCEL_APPLY_STOP,          DemoAuditStatus.AS_CANCEL.value(),       	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AS_TOBE_AUDITED(5,"停用待审核")                   READ_STOP_APPLY-[已读停用申请]          AS_AUDITING(6,"停用审核中")       		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AS_TOBE_AUDITED.value(),         DemoActions.READ_STOP_APPLY,            DemoAuditStatus.AS_AUDITING.value(),     	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AS_AUDITING(6,"停用审核中")                       PASS_STOP_APPLY-[通过停用申请]          AS_PASS(7,"停用审核通过")          		       M_BANED(4,"已停用")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AS_AUDITING.value(),             DemoActions.PASS_STOP_APPLY,            DemoAuditStatus.AS_PASS.value(),         	   DemoMasterStatus.M_BANED .value()));
//                                               M_PUBLISHED(3,"已发布")              AS_AUDITING(6,"停用审核中")                       REJECT_STOP_APPLY-[驳回停用申请]        AS_REJECT(8,"停用审核驳回")       		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AS_AUDITING.value(),             DemoActions.REJECT_STOP_APPLY,          DemoAuditStatus.AS_REJECT.value(),       	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AS_REJECT(8,"停用审核驳回")                       APPLY_STOP-[申请停用]                   AS_TOBE_AUDITED(5,"停用待审核")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AS_REJECT.value(),               DemoActions.APPLY_STOP,                 DemoAuditStatus.AS_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));


        // M_PUBLISHED - 变更流程
//                                               M_PUBLISHED(3,"已发布")              AP_PASS(3,"发布审核通过")                         APPLY_CHANGE-[申请变更]                 AC_TOBE_AUDITED(13,"变更待审核")   		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AP_PASS.value(),                 DemoActions.APPLY_CHANGE,               DemoAuditStatus.AC_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AO_PASS(11,"启用审核通过")                        APPLY_CHANGE-[申请变更]                 AC_TOBE_AUDITED(13,"变更待审核")   		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AO_PASS.value(),                 DemoActions.APPLY_CHANGE,               DemoAuditStatus.AC_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AS_CANCEL(18,"取消停用申请")                      APPLY_CHANGE-[申请变更]                 AC_TOBE_AUDITED(13,"变更待审核")   		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AS_CANCEL.value(),               DemoActions.APPLY_CHANGE,               DemoAuditStatus.AC_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AC_PASS(16,"变更审核通过")                        APPLY_CHANGE-[申请变更]                 AC_TOBE_AUDITED(13,"变更待审核")   		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_PASS.value(),                 DemoActions.APPLY_CHANGE,               DemoAuditStatus.AC_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AC_REJECT(17,"变更审核驳回")                      APPLY_CHANGE-[申请变更]                 AC_TOBE_AUDITED(13,"变更待审核")   		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_REJECT.value(),               DemoActions.APPLY_CHANGE,               DemoAuditStatus.AC_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_PUBLISHED(3,"已发布")              AC_CANCEL(14,"取消变更申请")                      APPLY_CHANGE-[申请变更]                 AC_TOBE_AUDITED(13,"变更待审核")   		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_CANCEL.value(),               DemoActions.APPLY_CHANGE,               DemoAuditStatus.AC_TOBE_AUDITED .value(),	   DemoMasterStatus.M_PUBLISHED .value()));

//                                               M_PUBLISHED(3,"已发布")              AC_TOBE_AUDITED(13,"变更待审核")                  CANCEL_APPLY_CHANGE-[取消变更申请]      AC_CANCEL(14,"取消变更申请")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_TOBE_AUDITED.value() ,        DemoActions.CANCEL_APPLY_CHANGE,        DemoAuditStatus.AC_CANCEL.value(),     		   DemoMasterStatus.M_PUBLISHED .value()))  ;
//                                               M_PUBLISHED(3,"已发布")              AC_TOBE_AUDITED(13,"变更待审核")                  READ_STOP_CHANGE-[已读变更申请]         AC_AUDITING(15,"变更审核中")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_TOBE_AUDITED.value(),         DemoActions.READ_STOP_CHANGE,           DemoAuditStatus.AC_AUDITING.value(),   		   DemoMasterStatus.M_PUBLISHED .value()))  ;
//                                               M_PUBLISHED(3,"已发布")              AC_AUDITING(14,"变更审核中")                      PASS_STOP_CHANGE-[通过变更申请]         AC_PASS(16,"变更审核通过")      		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_AUDITING.value(),             DemoActions.PASS_STOP_CHANGE,           DemoAuditStatus.AC_PASS.value(),       		   DemoMasterStatus.M_PUBLISHED .value()))  ;
//                                               M_PUBLISHED(3,"已发布")              AC_AUDITING(14,"变更审核中")                      REJECT_STOP_CHANGE-[驳回变更申请]       AC_REJECT(17,"变更审核驳回")    		       M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_PUBLISHED .value(),        DemoAuditStatus. AC_AUDITING.value(),             DemoActions.REJECT_STOP_CHANGE,         DemoAuditStatus.AC_REJECT.value(),     		   DemoMasterStatus.M_PUBLISHED .value()))  ;

        /*   主状态为已发布 M_BANED(4,"已停用")   */

//                                               M_BANED(4,"已停用")                  AS_PASS(7,"停用审核通过")                         DELETE-[删除]                           AS_PASS(7,"停用审核通过")                      M_DELETED(-1,"已删除")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AS_PASS.value(),                 DemoActions.DELETE,                     DemoAuditStatus.AS_PASS.value(),               DemoMasterStatus.M_DELETED .value()));
//                                               M_BANED(4,"已停用")                  AS_PASS(7,"停用审核通过")                         EDIT-[编辑]                             AS_PASS(7,"停用审核通过")                      M_BANED(4,"已停用")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AS_PASS.value(),                 DemoActions.EDIT,                       DemoAuditStatus.AS_PASS.value(),               DemoMasterStatus.M_BANED.value()));
//                                               M_BANED(4,"已停用")                  AS_PASS(7,"停用审核通过")                         APPLY_OPEN-[申请启用]                   AO_TOBE_AUDITED(9,"启用待审核")                M_BANED(4,"已停用")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AS_PASS.value(),                 DemoActions.APPLY_OPEN,                 DemoAuditStatus.AO_TOBE_AUDITED.value(),       DemoMasterStatus.M_BANED.value()));
//                                               M_BANED(4,"已停用")                  AO_TOBE_AUDITED(9,"启用待审核")                   RESUME_APPLY_OPEN-[撤回启用申请]        AS_PASS(7,"停用审核通过")                      M_BANED(4,"已停用")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AO_TOBE_AUDITED.value(),         DemoActions.RESUME_APPLY_OPEN,          DemoAuditStatus.AS_PASS.value(),               DemoMasterStatus.M_BANED.value()));
//                                               M_BANED(4,"已停用")                  AO_TOBE_AUDITED(9,"启用待审核")                   READ_OPEN_APPLY-[已读启用申请]          AO_AUDITING(10,"启用审核中")                   M_BANED(4,"已停用")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AO_TOBE_AUDITED.value(),         DemoActions.READ_OPEN_APPLY,            DemoAuditStatus.AO_AUDITING.value(),           DemoMasterStatus.M_BANED.value()));
//                                               M_BANED(4,"已停用")                  AO_AUDITING(10,"启用审核中")                      PASS_OPEN_APPLY-[通过启用申请]          AO_PASS(11,"启用审核通过")                     M_PUBLISHED(3,"已发布")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AO_AUDITING.value(),             DemoActions.PASS_OPEN_APPLY,            DemoAuditStatus.AO_PASS.value(),               DemoMasterStatus.M_PUBLISHED .value()));
//                                               M_BANED(4,"已停用")                  AO_AUDITING(10,"启用审核中")                      REJECT_OPEN_APPLY-[驳回启用申请]        AO_REJECT(12,"启用审核驳回")                   M_BANED(4,"已停用")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AO_AUDITING.value(),             DemoActions.REJECT_OPEN_APPLY,          DemoAuditStatus.AO_REJECT.value(),             DemoMasterStatus.M_BANED .value()));
//                                               M_BANED(4,"已停用")                  AO_REJECT(12,"启用审核驳回")                      APPLY_OPEN-[申请启用]                   AO_TOBE_AUDITED(9,"启用待审核")                M_BANED(4,"已停用")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AO_REJECT.value(),               DemoActions.APPLY_OPEN,                	DemoAuditStatus.AO_TOBE_AUDITED.value(),       DemoMasterStatus.M_BANED .value()));
//                                               M_BANED(4,"已停用")                  AO_REJECT(12,"启用审核驳回")                      DELETE-[删除]                           AO_REJECT(12,"启用审核驳回")                   M_DELETED(-1,"已删除")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AO_REJECT.value(),               DemoActions.DELETE,                     DemoAuditStatus.AO_REJECT.value(),             DemoMasterStatus.M_DELETED .value()));
//                                               M_BANED(4,"已停用")                  AO_REJECT(12,"启用审核驳回")                      EDIT-[编辑]                             AO_REJECT(12,"启用审核驳回")                   M_BANED(4,"已停用")
        LIST_TABLE.add(new StatusTable(DemoMasterStatus. M_BANED.value(),             DemoAuditStatus. AO_REJECT.value(),               DemoActions.EDIT,                       DemoAuditStatus.AO_REJECT.value(),             DemoMasterStatus.M_BANED  .value()));

    }

    @Override
    public ArrayList<StatusTable> listTable() {
        return LIST_TABLE;
    }

}