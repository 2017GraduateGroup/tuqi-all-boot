package com.tuqi.mapper;

import com.tuqi.domain.model.UserPositionDO;
import com.tuqi.domain.query.UserPositionQuery;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * MyBatis Mapper for UserPosition.
 */
public interface UserPositionMapper {
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
    int insertSelective(UserPositionDO record);

    /**
     * select by query condition.
     */
    List<UserPositionDO> selectByQuery(UserPositionQuery query);

    /**
     * select by primary key.
     */
    UserPositionDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") UserPositionDO record, @Param("query") UserPositionQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") UserPositionDO record, @Param("query") UserPositionQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(UserPositionDO record);
}