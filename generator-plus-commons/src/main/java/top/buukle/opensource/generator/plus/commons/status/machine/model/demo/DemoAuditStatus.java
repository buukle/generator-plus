package top.buukle.opensource.generator.plus.commons.status.machine.model.demo;


import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.AuditStatus;

public enum DemoAuditStatus implements AuditStatus {

        A_INIT(0,"初始化") ,

        AP_TOBE_AUDITED(1,"发布待审核") ,
        AP_AUDITING(2,"发布审核中") ,
        AP_PASS(3,"发布审核通过") ,
        AP_REJECT(4,"发布审核驳回"),

        AS_TOBE_AUDITED(5,"停用待审核") ,
        AS_CANCEL(18,"取消停用申请"),
        AS_AUDITING(6,"停用审核中"),
        AS_PASS(7,"停用审核通过"),
        AS_REJECT(8,"停用审核驳回"),

        AO_TOBE_AUDITED(9,"启用待审核") ,
        AO_AUDITING(10,"启用审核中"),
        AO_PASS(11,"启用审核通过"),
        AO_REJECT(12,"启用审核驳回"),

        AC_TOBE_AUDITED(13,"变更待审核"),
        AC_CANCEL(14,"取消变更申请"),
        AC_AUDITING(15,"变更审核中"),
        AC_PASS(16,"变更审核通过"),
        AC_REJECT(17,"变更审核驳回") ,

        ;

        private Integer status;
        private String description;

        DemoAuditStatus(int status, String description) {
            this.description = description;
            this.status = status;
        }
        public String getDescription() {
            return description;
        }
        public Integer value() {
            return status;
        }

        @Override
        public AuditStatus getEnumWithValue(Integer auditStatus) {
                if(auditStatus == null){
                        return null;
                }
                DemoAuditStatus[] values = DemoAuditStatus.values();
                for(DemoAuditStatus demoAuditStatus : values){
                        if(demoAuditStatus.value().equals(auditStatus)){
                                return demoAuditStatus;
                        }
                }
                return null;
        }
}