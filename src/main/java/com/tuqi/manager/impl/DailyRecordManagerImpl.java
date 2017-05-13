package com.tuqi.manager.impl;

import com.tuqi.mybatisgenerate.query.PageResult;
import com.tuqi.domain.model.DailyRecordDO;
import com.tuqi.domain.query.DailyRecordQuery;
import com.tuqi.mapper.ext.DailyRecordExtMapper;
import com.tuqi.manager.DailyRecordManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for DailyRecord.
 */

@Component
public class DailyRecordManagerImpl implements DailyRecordManager{
    private static final Logger log = LoggerFactory.getLogger(DailyRecordManagerImpl.class);

    
    @Autowired
    protected DailyRecordExtMapper dailyRecordExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(DailyRecordQuery query){
        return dailyRecordExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(DailyRecordQuery query){
        return dailyRecordExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(DailyRecordDO record){
        return dailyRecordExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(DailyRecordDO record){
        return dailyRecordExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<DailyRecordDO> selectByQuery(DailyRecordQuery query){
        return dailyRecordExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<DailyRecordDO> selectByQueryWithPage(DailyRecordQuery query) {
        PageResult<DailyRecordDO> result = new PageResult<DailyRecordDO>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setPageData(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    @Override
    public DailyRecordDO selectByPrimaryKey(Long id){
        return dailyRecordExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( DailyRecordDO record,  DailyRecordQuery query){
        return dailyRecordExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( DailyRecordDO record,  DailyRecordQuery query){

        return dailyRecordExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(DailyRecordDO record){
        return dailyRecordExtMapper.updateByPrimaryKeySelective(record);
    }
}