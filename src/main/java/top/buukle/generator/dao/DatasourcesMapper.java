package top.buukle.generator.dao;

import top.buukle.generator.entity.Datasources;
import top.buukle.generator.entity.DatasourcesExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DatasourcesMapper {
    /**
     */
    long countByExample(DatasourcesExample example);

    /**
     */
    int deleteByExample(DatasourcesExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(Datasources record);

    /**
     */
    int insertSelective(Datasources record);

    /**
     */
    List<Datasources> selectByExample(DatasourcesExample example);

    /**
     */
    Datasources selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") Datasources record, @Param("example") DatasourcesExample example);

    /**
     */
    int updateByExample(@Param("record") Datasources record, @Param("example") DatasourcesExample example);

    /**
     */
    int updateByPrimaryKeySelective(Datasources record);

    /**
     */
    int updateByPrimaryKey(Datasources record);
}