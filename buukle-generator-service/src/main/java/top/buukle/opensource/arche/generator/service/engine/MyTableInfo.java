package top.buukle.opensource.arche.generator.service.engine;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.Data;

@Data
public class MyTableInfo extends TableInfo {

    private String packageInfo;
}
