package top.buukle.opensource.generator.plus.dos.enums;


/**
 * @Author: elvin
 * @Date: 2019/7/28/028 3:56
 */
public class TemplatesEnums {

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
            TemplatesEnums.status[] values = TemplatesEnums.status.values();
            StringBuffer stringBuffer = new StringBuffer();
            for (TemplatesEnums.status status : values) {
                stringBuffer.append(status.value());
                stringBuffer.append(";");
                stringBuffer.append(status.getDescription());
                stringBuffer.append(",");
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
            TemplatesEnums.auditStatus[] values = TemplatesEnums.auditStatus.values();
            StringBuffer stringBuffer = new StringBuffer();
            for (TemplatesEnums.auditStatus status : values) {
                stringBuffer.append(status.value());
                stringBuffer.append(";");
                stringBuffer.append(status.getDescription());
                stringBuffer.append(",");
            }
            return stringBuffer.toString();
        }
    }
    public enum openTablePath {

        OPEN("1","开启"),
        ;

        private String code;
        private String description;

        openTablePath(String code, String description) {
            this.description = description;
            this.code = code;
        }
        public String getDescription() {
            return description;
        }
        public String value() {
            return code;
        }
    }
    public enum addNameSuffix {

        TABLE_BIG_CALM("0","表名大驼峰"),
        TEMPLATE_FRONT_MIDDLE("1","模板前中段"),
        TABLE_BIG_CALM_PLUS_TEMPLATE_FRONT_MIDDLE("2","表名大驼峰+模板前段"),
        ;

        private String code;
        private String description;

        addNameSuffix(String code, String description) {
            this.description = description;
            this.code = code;
        }
        public String getDescription() {
            return description;
        }
        public String value() {
            return code;
        }
    }
}