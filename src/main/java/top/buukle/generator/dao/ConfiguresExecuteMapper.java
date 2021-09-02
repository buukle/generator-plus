package top.buukle.generator.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.generator.entity.ConfiguresExecute;
import top.buukle.generator.entity.ConfiguresExecuteExample;

import java.util.List;

@Mapper
public interface ConfiguresExecuteMapper {
    /**
     */
    long countByExample(ConfiguresExecuteExample example);

    /**
     */
    int deleteByExample(ConfiguresExecuteExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(ConfiguresExecute record);

    /**
     */
    int insertSelective(ConfiguresExecute record);

    /**
     */
    List<ConfiguresExecute> selectByExampleWithBLOBs(ConfiguresExecuteExample example);

    /**
     */
    List<ConfiguresExecute> selectByExample(ConfiguresExecuteExample example);

    /**
     */
    ConfiguresExecute selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") ConfiguresExecute record, @Param("example") ConfiguresExecuteExample example);

    /**
     */
    int updateByExampleWithBLOBs(@Param("record") ConfiguresExecute record, @Param("example") ConfiguresExecuteExample example);

    /**
     */
    int updateByExample(@Param("record") ConfiguresExecute record, @Param("example") ConfiguresExecuteExample example);

    /**
     */
    int updateByPrimaryKeySelective(ConfiguresExecute record);

    /**
     */
    int updateByPrimaryKeyWithBLOBs(ConfiguresExecute record);

    /**
     */
    int updateByPrimaryKey(ConfiguresExecute record);
}