package com.tuqi.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyRecordDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column daily_record.recordid
     */
    private Long recordid;

    /**
     * This field corresponds to the database column daily_record.title
     */
    private String title;

    /**
     * This field corresponds to the database column daily_record.content
     */
    private String content;

    /**
     * This field corresponds to the database column daily_record.status
     */
    private String status;

    /**
     * This field corresponds to the database column daily_record.remarks
     */
    private String remarks;

    /**
     * This field corresponds to the database column daily_record.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column daily_record.gmt_modified
     */
    private Date gmtModified;

    /**
     * This field corresponds to the database column daily_record.user_user_id
     */
    private Long userUserId;

}