package top.buukle.opensource.generator.plus.commons.status.machine.model.interfac;

/**
 * @Author elvin
 * @Date Created by elvin on 2021/2/25.
 * @Description : 主状态接口
 */
public interface MasterStatus {

    Integer value();

    String getDescription();

    MasterStatus getEnumWithValue(Integer masterStatus);
}
