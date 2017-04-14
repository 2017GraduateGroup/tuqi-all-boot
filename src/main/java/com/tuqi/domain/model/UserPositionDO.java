package com.tuqi.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPositionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column user_position.position_id
     */
    private Integer positionId;

    /**
     * This field corresponds to the database column user_position.position_name
     */
    private String positionName;

    /**
     * This field corresponds to the database column user_position.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column user_position.gmt_modified
     */
    private Date gmtModified;

}