package top.buukle.generator.dao;

import top.buukle.generator.entity.Templates;
import top.buukle.generator.entity.TemplatesExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TemplatesMapper {
    /**
     */
    long countByExample(TemplatesExample example);

    /**
     */
    int deleteByExample(TemplatesExample example);

    /**
     */
    int deleteByPrimaryKey(Integer id);

    /**
     */
    int insert(Templates record);

    /**
     */
    int insertSelective(Templates record);

    /**
     */
    List<Templates> selectByExampleWithBLOBs(TemplatesExample example);

    /**
     */
    List<Templates> selectByExample(TemplatesExample example);

    /**
     */
    Templates selectByPrimaryKey(Integer id);

    /**
     */
    int updateByExampleSelective(@Param("record") Templates record, @Param("example") TemplatesExample example);

    /**
     */
    int updateByExampleWithBLOBs(@Param("record") Templates record, @Param("example") TemplatesExample example);

    /**
     */
    int updateByExample(@Param("record") Templates record, @Param("example") TemplatesExample example);

    /**
     */
    int updateByPrimaryKeySelective(Templates record);

    /**
     */
    int updateByPrimaryKeyWithBLOBs(Templates record);

    /**
     */
    int updateByPrimaryKey(Templates record);
}