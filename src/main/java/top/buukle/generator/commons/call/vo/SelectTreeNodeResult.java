/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: ApplicationNode
 * Author:   zhanglei1102
 * Date:     2019/8/9 16:37
 * Description: 应用树节点包装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.commons.call.vo;

import lombok.Data;

import java.util.List;

/**
 * @description 〈layui树节点包装类〉
 * @author zhanglei1102
 * @create 2019/8/9
 * @since 1.0.0
 */
@Data
public class SelectTreeNodeResult {

    private String title;
    private Integer id;
    private boolean disabled;
    private boolean checked;
    private boolean spread;
    private List<SelectTreeNodeResult> children;

}