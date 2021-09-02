package top.buukle.generator.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.buukle.generator.entity.Configures;
import top.buukle.generator.entity.ConfiguresExample;

import java.util.List;

@Mapper
public interface ConfiguresMapper {
    /**
     */
    long countByExample(ConfiguresExample example);

    /**
     */
    int deleteByExample(ConfiguresExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(Configures record);

    /**
     */
    int insertSelective(Configures record);

    /**
     */
    List<Configures> selectByExampleWithBLOBs(ConfiguresExample example);

    /**
     */
    List<Configures> selectByExample(ConfiguresExample example);

    /**
     */
    Configures selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") Configures record, @Param("example") ConfiguresExample example);

    /**
     */
    int updateByExampleWithBLOBs(@Param("record") Configures record, @Param("example") ConfiguresExample example);

    /**
     */
    int updateByExample(@Param("record") Configures record, @Param("example") ConfiguresExample example);

    /**
     */
    int updateByPrimaryKeySelective(Configures record);

    /**
     */
    int updateByPrimaryKeyWithBLOBs(Configures record);

    /**
     */
    int updateByPrimaryKey(Configures record);
}