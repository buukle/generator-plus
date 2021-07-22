package top.buukle.generator.commons.status.machine.model.interfac;

/**
 * @Author elvin
 * @Date Created by elvin on 2021/2/25.
 * @Description : 审核状态接口
 */
public interface AuditStatus {

    Integer value();

    String getDescription();

    AuditStatus getEnumWithValue(Integer auditStatus);
}
