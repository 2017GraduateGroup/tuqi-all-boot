package com.tuqi.mapper;

import com.tuqi.domain.model.ProgrammeDO;
import com.tuqi.domain.query.ProgrammeQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for Programme.
 */
public interface ProgrammeMapper {
    /**
     * query count by query condition.
     */
    int countByQuery(ProgrammeQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(ProgrammeQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(ProgrammeDO record);

    /**
     * insert selective.
     */
    int insertSelective(ProgrammeDO record);

    /**
     * select by query condition.
     */
    List<ProgrammeDO> selectByQuery(ProgrammeQuery query);

    /**
     * select by primary key.
     */
    ProgrammeDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") ProgrammeDO record, @Param("query") ProgrammeQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") ProgrammeDO record, @Param("query") ProgrammeQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ProgrammeDO record);
}