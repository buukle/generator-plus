package top.buukle.opensource.arche.generator.dos.enums;


import top.buukle.business.base.utils.StringUtil;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 3:56
 */
public class ConfiguresExecuteEnums {

    public enum status {

        DELETED(-1,"已经删除"),
        INIT(0,"创建完成"),
        AUDITING(1,"审核中"),
        REJECT(2,"停用"),
        PUBLISHED(3,"正常"),
        EXECUTING(4,"执行中"),
        EXECUTE_FAILED(5,"执行失败"),
        EXECUTE_SUCCESS(6,"执行成功"),
        ;

        private Integer status;
        private String description;

        status(int status, String description) {
            this.description = description;
            this.status = status;
        }
        public String getDescription() {
            return description;
        }
        public Integer value() {
            return status;
        }

        public static String getPairs() {
            ConfiguresExecuteEnums.status[] values = ConfiguresExecuteEnums.status.values();
            StringBuffer stringBuffer = new StringBuffer();
            for (ConfiguresExecuteEnums.status status : values) {
                stringBuffer.append(status.value());
                stringBuffer.append(StringUtil.COLON);
                stringBuffer.append(status.getDescription());
                stringBuffer.append(StringUtil.COMMA);
            }
            return stringBuffer.toString();
        }
    }

    public enum auditStatus {

        INIT(-1,"待提交"),
        COMMITTED(0,"提交审核"),
        AUDITING(1,"审核中"),
        PUBLISHED(2,"通过"),
        REJECT(3,"不通过"),
        ;

        private Integer status;
        private String description;

        auditStatus(int status, String description) {
            this.description = description;
            this.status = status;
        }
        public String getDescription() {
            return description;
        }
        public Integer value() {
            return status;
        }

        public static String getPairs() {
            ConfiguresExecuteEnums.auditStatus[] values = ConfiguresExecuteEnums.auditStatus.values();
            StringBuffer stringBuffer = new StringBuffer();
            for (ConfiguresExecuteEnums.auditStatus status : values) {
                stringBuffer.append(status.value());
                stringBuffer.append(StringUtil.COLON);
                stringBuffer.append(status.getDescription());
                stringBuffer.append(StringUtil.COMMA);
            }
            return stringBuffer.toString();
        }
    }
}