package com.tuqi.manager;

import com.tuqi.mybatisgenerate.query.PageResult;
import com.tuqi.domain.model.UserPositionDO;
import com.tuqi.domain.query.UserPositionQuery;

import java.util.List;


/**
 * Manager for UserPosition.
 */
public interface UserPositionManager {
    /**
     * query count by query condition.
     */
    int countByQuery(UserPositionQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(UserPositionQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(UserPositionDO record);

    /**
     * insert selective.
     */
    long insertSelective(UserPositionDO record);

    /**
     * select by query condition.
     */
    List<UserPositionDO> selectByQuery(UserPositionQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<UserPositionDO> selectByQueryWithPage(UserPositionQuery query);

    /**
     * select by primary key.
     */
    UserPositionDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( UserPositionDO record,  UserPositionQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(UserPositionDO record, UserPositionQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(UserPositionDO record);
}