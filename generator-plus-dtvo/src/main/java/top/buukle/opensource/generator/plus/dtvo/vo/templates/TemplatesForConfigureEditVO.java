package top.buukle.opensource.generator.plus.dtvo.vo.templates;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
* @author elvin
* @description  Datasources 查询包装类
*/
@Data
@ApiModel(value = "模板 - 配置详情响应")
public class TemplatesForConfigureEditVO extends TemplatesVO {

    private Boolean checked;
}