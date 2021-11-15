package top.buukle.opensource.generator.plus.service.engine.codes;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.Data;

import java.util.Map;

@Data
public class MyTableInfo extends TableInfo {

    private String packageInfo;

    private Map<String,String> groupParams;
}
