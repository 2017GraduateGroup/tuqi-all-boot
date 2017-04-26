package com.tuqi.manager.impl;

import com.tuqi.mybatisgenerate.query.PageResult;
import com.tuqi.domain.model.ProgrammeDO;
import com.tuqi.domain.query.ProgrammeQuery;
import com.tuqi.mapper.ext.ProgrammeExtMapper;
import com.tuqi.manager.ProgrammeManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for Programme.
 */

@Component
public class ProgrammeManagerImpl implements ProgrammeManager{
    private static final Logger log = LoggerFactory.getLogger(ProgrammeManagerImpl.class);

    
    @Autowired
    protected ProgrammeExtMapper programmeExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(ProgrammeQuery query){
        return programmeExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(ProgrammeQuery query){
        return programmeExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(ProgrammeDO record){
        return programmeExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(ProgrammeDO record){
        return programmeExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<ProgrammeDO> selectByQuery(ProgrammeQuery query){
        return programmeExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<ProgrammeDO> selectByQueryWithPage(ProgrammeQuery query) {
        PageResult<ProgrammeDO> result = new PageResult<ProgrammeDO>();
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
    public ProgrammeDO selectByPrimaryKey(Long id){
        return programmeExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( ProgrammeDO record,  ProgrammeQuery query){
        return programmeExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( ProgrammeDO record,  ProgrammeQuery query){

        return programmeExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(ProgrammeDO record){
        return programmeExtMapper.updateByPrimaryKeySelective(record);
    }
}