package top.buukle.opensource.arche.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.buukle.opensource.arche.generator.entity.Datasources;

@Mapper
public interface DatasourcesMapper extends BaseMapper<Datasources> {
}