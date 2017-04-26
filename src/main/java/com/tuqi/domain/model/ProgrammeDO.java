package com.tuqi.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammeDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column programme.programmeid
     */
    private Long programmeid;

    /**
     * This field corresponds to the database column programme.content
     */
    private String content;

    /**
     * This field corresponds to the database column programme.status
     */
    private String status;

    /**
     * This field corresponds to the database column programme.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column programme.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column programme.programme_time
     */
    private String programmeTime;

    /**
     * This field corresponds to the database column programme.program_user_id
     */
    private Long programUserId;

    /**
     * This field corresponds to the database column programme.program_type_id
     */
    private Integer programTypeId;

}