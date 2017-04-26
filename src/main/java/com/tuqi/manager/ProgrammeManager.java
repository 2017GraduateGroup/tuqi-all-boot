package com.tuqi.manager;

import com.tuqi.mybatisgenerate.query.PageResult;
import com.tuqi.domain.model.ProgrammeDO;
import com.tuqi.domain.query.ProgrammeQuery;

import java.util.List;


/**
 * Manager for Programme.
 */
public interface ProgrammeManager {
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
    long insertSelective(ProgrammeDO record);

    /**
     * select by query condition.
     */
    List<ProgrammeDO> selectByQuery(ProgrammeQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<ProgrammeDO> selectByQueryWithPage(ProgrammeQuery query);

    /**
     * select by primary key.
     */
    ProgrammeDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( ProgrammeDO record,  ProgrammeQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(ProgrammeDO record, ProgrammeQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(ProgrammeDO record);
}