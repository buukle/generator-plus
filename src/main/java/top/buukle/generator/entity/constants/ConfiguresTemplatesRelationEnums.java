package top.buukle.generator.entity.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 3:56
 */
public class ConfiguresTemplatesRelationEnums {

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
    }

    public enum allowStatus {

    ALLOW_STATUS(status.PUBLISHED.value()),
    ;

    private List<Integer> list;

        allowStatus(Integer ... allowStatus) {
            List<Integer> allowList = new ArrayList<>();
            for (Integer status: allowStatus) {
                allowList.add(status);
            }
            this.list = allowList;
        }

        public List<Integer> list() {
            return list;
        }
    }
}