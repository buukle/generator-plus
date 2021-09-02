package top.buukle.generator.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.generator.entity.ConfiguresTemplatesRelation;
import top.buukle.generator.entity.ConfiguresTemplatesRelationExample;

import java.util.List;

@Mapper
public interface ConfiguresTemplatesRelationMapper {
    /**
     */
    long countByExample(ConfiguresTemplatesRelationExample example);

    /**
     */
    int deleteByExample(ConfiguresTemplatesRelationExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(ConfiguresTemplatesRelation record);

    /**
     */
    int insertSelective(ConfiguresTemplatesRelation record);

    /**
     */
    List<ConfiguresTemplatesRelation> selectByExample(ConfiguresTemplatesRelationExample example);

    /**
     */
    ConfiguresTemplatesRelation selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") ConfiguresTemplatesRelation record, @Param("example") ConfiguresTemplatesRelationExample example);

    /**
     */
    int updateByExample(@Param("record") ConfiguresTemplatesRelation record, @Param("example") ConfiguresTemplatesRelationExample example);

    /**
     */
    int updateByPrimaryKeySelective(ConfiguresTemplatesRelation record);

    /**
     */
    int updateByPrimaryKey(ConfiguresTemplatesRelation record);
}