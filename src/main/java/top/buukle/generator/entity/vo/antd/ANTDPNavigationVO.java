/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: ANTDPActionDTO
 * Author:   elvin
 * Date:     2021/7/26 19:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.entity.vo.antd;

import lombok.Data;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
@Data
public class ANTDPNavigationVO {

    private String name      ;
    private Integer parentId  ;
    private String component ;
    private String path ;
    private String redirect ;
    private Integer id       ;
    private MetaVO meta;
}