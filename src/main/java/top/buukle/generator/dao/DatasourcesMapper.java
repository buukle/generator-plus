package top.buukle.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.buukle.generator.entity.model.Datasources;

@Mapper
public interface DatasourcesMapper extends BaseMapper<Datasources> {
}