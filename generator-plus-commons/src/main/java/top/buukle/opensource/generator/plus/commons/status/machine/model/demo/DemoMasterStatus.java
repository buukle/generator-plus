package top.buukle.opensource.generator.plus.commons.status.machine.model.demo;


import top.buukle.opensource.generator.plus.commons.status.machine.model.interfac.MasterStatus;

public enum DemoMasterStatus implements MasterStatus {

        M_DELETED(-1,"已经删除"),
        M_INIT(0,"创建完成"),
        M_AUDITING(1,"审核中"),
        M_BANED(2,"停用"),
        M_PUBLISHED(3,"正常"),
        ;

        private Integer status;
        private String description;

        DemoMasterStatus(int status, String description) {
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
    public MasterStatus getEnumWithValue(Integer masterStatus) {
        if(masterStatus == null){
            return null;
        }
        DemoMasterStatus[] values = DemoMasterStatus.values();
        for(DemoMasterStatus demoMasterStatus : values){
            if(demoMasterStatus.value().equals(masterStatus)){
                return demoMasterStatus;
            }
        }
        return null;
    }

}