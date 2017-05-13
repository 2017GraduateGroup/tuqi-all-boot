package com.tuqi.manager;

import com.tuqi.mybatisgenerate.query.PageResult;
import com.tuqi.domain.model.DailyRecordDO;
import com.tuqi.domain.query.DailyRecordQuery;

import java.util.List;


/**
 * Manager for DailyRecord.
 */
public interface DailyRecordManager {
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
    long insertSelective(DailyRecordDO record);

    /**
     * select by query condition.
     */
    List<DailyRecordDO> selectByQuery(DailyRecordQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<DailyRecordDO> selectByQueryWithPage(DailyRecordQuery query);

    /**
     * select by primary key.
     */
    DailyRecordDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( DailyRecordDO record,  DailyRecordQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(DailyRecordDO record, DailyRecordQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(DailyRecordDO record);
}