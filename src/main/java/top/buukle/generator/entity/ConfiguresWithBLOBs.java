package top.buukle.generator.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created By zhanglei
 * Description: 
 * 配置表
 *
 * @author  zhaongleiqt@chinamobile.com
 */
@Data
public class ConfiguresWithBLOBs extends top.buukle.generator.entity.Configures implements Serializable {
    /**
     * 表名(,分割)
     *
     */
    private String tables;

    /**
     * 内容
     *
     */
    private String content;

    /**
     */
    private static final long serialVersionUID = 1L;

}