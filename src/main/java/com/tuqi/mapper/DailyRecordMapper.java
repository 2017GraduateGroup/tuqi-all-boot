package com.tuqi.mapper;

import com.tuqi.domain.model.DailyRecordDO;
import com.tuqi.domain.query.DailyRecordQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for DailyRecord.
 */
public interface DailyRecordMapper {
    /**
     * query count by query condition.
     */
    int countByQuery(DailyRecordQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(DailyRecordQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(DailyRecordDO record);

    /**
     * insert selective.
     */
    int insertSelective(DailyRecordDO record);

    /**
     * select by query condition.
     */
    List<DailyRecordDO> selectByQuery(DailyRecordQuery query);

    /**
     * select by primary key.
     */
    DailyRecordDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") DailyRecordDO record, @Param("query") DailyRecordQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") DailyRecordDO record, @Param("query") DailyRecordQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(DailyRecordDO record);
}