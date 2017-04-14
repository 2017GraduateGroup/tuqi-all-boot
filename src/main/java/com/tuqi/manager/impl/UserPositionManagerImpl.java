package com.tuqi.manager.impl;

import com.tuqi.mybatisgenerate.query.PageResult;
import com.tuqi.domain.model.UserPositionDO;
import com.tuqi.domain.query.UserPositionQuery;
import com.tuqi.mapper.ext.UserPositionExtMapper;
import com.tuqi.manager.UserPositionManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for UserPosition.
 */

@Component
public class UserPositionManagerImpl implements UserPositionManager{
    private static final Logger log = LoggerFactory.getLogger(UserPositionManagerImpl.class);

    
    @Autowired
    protected UserPositionExtMapper userPositionExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(UserPositionQuery query){
        return userPositionExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(UserPositionQuery query){
        return userPositionExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(UserPositionDO record){
        return userPositionExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(UserPositionDO record){
        return userPositionExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<UserPositionDO> selectByQuery(UserPositionQuery query){
        return userPositionExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<UserPositionDO> selectByQueryWithPage(UserPositionQuery query) {
        PageResult<UserPositionDO> result = new PageResult<UserPositionDO>();
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
    public UserPositionDO selectByPrimaryKey(Long id){
        return userPositionExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( UserPositionDO record,  UserPositionQuery query){
        return userPositionExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( UserPositionDO record,  UserPositionQuery query){

        return userPositionExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(UserPositionDO record){
        return userPositionExtMapper.updateByPrimaryKeySelective(record);
    }
}