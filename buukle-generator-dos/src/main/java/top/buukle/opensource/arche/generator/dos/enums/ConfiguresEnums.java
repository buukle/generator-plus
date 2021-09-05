package top.buukle.opensource.arche.generator.dos.enums;


import top.buukle.business.base.utils.StringUtil;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 3:56
 */
public class ConfiguresEnums {

    public enum status {

        DELETED(-1,"已经删除"),
        INIT(0,"创建完成"),
        AUDITING(1,"审核中"),
        REJECT(2,"停用"),
        PUBLISHED(3,"正常"),
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
            ConfiguresEnums.status[] values = ConfiguresEnums.status.values();
            StringBuffer stringBuffer = new StringBuffer();
            for (ConfiguresEnums.status status : values) {
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
            ConfiguresEnums.auditStatus[] values = ConfiguresEnums.auditStatus.values();
            StringBuffer stringBuffer = new StringBuffer();
            for (ConfiguresEnums.auditStatus status : values) {
                stringBuffer.append(status.value());
                stringBuffer.append(StringUtil.COLON);
                stringBuffer.append(status.getDescription());
                stringBuffer.append(StringUtil.COMMA);
            }
            return stringBuffer.toString();
        }
    }
}