/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: Result
 * Author:   elvin
 * Date:     2021/7/26 22:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.arche.generator.entity.vo.antd;

import lombok.Data;

import java.util.List;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
@Data
public class ResultVO<T> {

    private Integer pageSize;
    private Integer pageNo;
    private long totalCount;
    private long totalPage ;
    private List<T> data;

    public ResultVO(List<T> data) {
        this.data = data;
    }
}