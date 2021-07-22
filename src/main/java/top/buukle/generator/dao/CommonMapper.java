/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: CommonMapprt
 * Author:   zhanglei1102
 * Date:     2019/8/6 20:42
 * Description: common mapper
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.dao;

import org.apache.ibatis.annotations.Mapper;
import top.buukle.generator.commons.call.vo.FuzzyVo;

import java.util.List;


/**
 * @description 〈common mapper〉
 * @author zhanglei1102
 * @create 2019/8/6
 * @since 1.0.0
 */
@Mapper
public interface CommonMapper {

    List<FuzzyVo> fuzzySearch(FuzzyVo fuzzyVo);

    List<FuzzyVo> fuzzySearchNoMulti(FuzzyVo fuzzyVo);

    List<FuzzyVo> fuzzySearchNoAutomaticCreateObject(FuzzyVo fuzzyVo);
}