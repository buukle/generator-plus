package top.buukle.opensource.arche.generator.commons.status.machine.model.demo;

import top.buukle.opensource.arche.generator.commons.status.machine.model.interfac.Actions;

import java.util.HashMap;
import java.util.Map;

public enum DemoActions implements Actions {

    /*编辑*/
    EDIT,
    /*删除*/
    DELETE,

    /*申请发布*/
    APPLY_PUBLISH,
    /*撤回发布申请*/
    RESUME_APPLY_PUBLISH,
    /*已读发布申请*/
    READ_PUBLISH_APPLY,
    /*通过发布申请*/
    PASS_PUBLISH_APPLY,
    /*驳回发布申请*/
    REJECT_PUBLISH_APPLY,

    /*申请停用*/
    APPLY_STOP,
    /*取消停用申请*/
    CANCEL_APPLY_STOP,
    /*已读停用申请*/
    READ_STOP_APPLY,
    /*通过停用申请*/
    PASS_STOP_APPLY,
    /*驳回停用申请*/
    REJECT_STOP_APPLY,

    /*申请变更*/
    APPLY_CHANGE,
    /*取消停用申请*/
    CANCEL_APPLY_CHANGE,
    /*已读停用申请*/
    READ_STOP_CHANGE,
    /*通过停用申请*/
    PASS_STOP_CHANGE,
    /*驳回停用申请*/
    REJECT_STOP_CHANGE,

    /*申请启用*/
    APPLY_OPEN,
    /*撤回启用申请*/
    RESUME_APPLY_OPEN,
    /*已读启用申请*/
    READ_OPEN_APPLY,
    /*通过启用申请*/
    PASS_OPEN_APPLY,
    /*驳回启用申请*/
    REJECT_OPEN_APPLY,
    ;

    private static final Map<Actions, String> ACTION_NAME_MAP = new HashMap<>();

    static {
        ACTION_NAME_MAP.put(EDIT, "编辑");
        ACTION_NAME_MAP.put(DELETE, "删除");
        ACTION_NAME_MAP.put(APPLY_PUBLISH, "申请发布");
        ACTION_NAME_MAP.put(RESUME_APPLY_PUBLISH, "撤回发布申请");
        ACTION_NAME_MAP.put(READ_PUBLISH_APPLY, "已读发布申请");
        ACTION_NAME_MAP.put(PASS_PUBLISH_APPLY, "通过发布申请");
        ACTION_NAME_MAP.put(REJECT_PUBLISH_APPLY, "驳回发布申请");
        ACTION_NAME_MAP.put(APPLY_STOP, "申请停用");
        ACTION_NAME_MAP.put(CANCEL_APPLY_STOP, "取消停用申请");
        ACTION_NAME_MAP.put(READ_STOP_APPLY, "已读停用申请");
        ACTION_NAME_MAP.put(PASS_STOP_APPLY, "通过停用申请");
        ACTION_NAME_MAP.put(REJECT_STOP_APPLY, "驳回停用申请");
        ACTION_NAME_MAP.put(APPLY_CHANGE, "申请变更");
        ACTION_NAME_MAP.put(CANCEL_APPLY_CHANGE, "取消变更申请");
        ACTION_NAME_MAP.put(READ_STOP_CHANGE, "已读变更申请");
        ACTION_NAME_MAP.put(PASS_STOP_CHANGE, "通过变更申请");
        ACTION_NAME_MAP.put(REJECT_STOP_CHANGE, "驳回变更申请");
        ACTION_NAME_MAP.put(APPLY_OPEN, "申请启用");
        ACTION_NAME_MAP.put(RESUME_APPLY_OPEN, "撤回启用申请");
        ACTION_NAME_MAP.put(READ_OPEN_APPLY, "已读启用申请");
        ACTION_NAME_MAP.put(PASS_OPEN_APPLY, "通过启用申请");
        ACTION_NAME_MAP.put(REJECT_OPEN_APPLY, "驳回启用申请");
    }

    @Override
    public String getActionDesc() {
        return ACTION_NAME_MAP.get(this);
    }
}