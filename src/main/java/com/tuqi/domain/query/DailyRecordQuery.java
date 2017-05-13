package com.tuqi.domain.query;


import com.tuqi.mybatisgenerate.query.BaseQuery;
import com.tuqi.mybatisgenerate.query.BaseCriteria;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DailyRecordQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public DailyRecordQuery() {
        super();
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        super.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This class corresponds to the database table daily_record
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andRecordid,userUserIdIsNull() {
            addCriterion("recordId,user_user_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdIsNotNull() {
            addCriterion("recordId,user_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdEqualTo(Long value) {
            addCriterion("recordId,user_user_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdNotEqualTo(Long value) {
            addCriterion("recordId,user_user_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anRecordid,userUserIdGreaterThan(Long value) {
            addCriterion("recordId,user_user_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recordId,user_user_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdLessThan(Long value) {
            addCriterion("recordId,user_user_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdLessThanOrEqualTo(Long value) {
            addCriterion("recordId,user_user_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdIn(List<Long> values) {
            addCriterion("recordId,user_user_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdNotIn(List<Long> values) {
            addCriterion("recordId,user_user_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdBetween(Long value1, Long value2) {
            addCriterion("recordId,user_user_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRecordid,userUserIdNotBetween(Long value1, Long value2) {
            addCriterion("recordId,user_user_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNull() {
            addCriterion("recordid is null");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNotNull() {
            addCriterion("recordid is not null");
            return (Criteria) this;
        }

        public Criteria andRecordidEqualTo(Long value) {
            addCriterion("recordid =", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotEqualTo(Long value) {
            addCriterion("recordid <>", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThan(Long value) {
            addCriterion("recordid >", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThanOrEqualTo(Long value) {
            addCriterion("recordid >=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThan(Long value) {
            addCriterion("recordid <", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThanOrEqualTo(Long value) {
            addCriterion("recordid <=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("recordid like", strValue, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("recordid not like", strValue, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidIn(List<Long> values) {
            addCriterion("recordid in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotIn(List<Long> values) {
            addCriterion("recordid not in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidBetween(Long value1, Long value2) {
            addCriterion("recordid between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotBetween(Long value1, Long value2) {
            addCriterion("recordid not between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("title like", strValue, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("title not like", strValue, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("content like", strValue, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("content not like", strValue, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("status like", strValue, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("status not like", strValue, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("remarks like", strValue, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("remarks not like", strValue, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andUserUserIdIsNull() {
            addCriterion("user_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserUserIdIsNotNull() {
            addCriterion("user_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserUserIdEqualTo(Long value) {
            addCriterion("user_user_id =", value, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdNotEqualTo(Long value) {
            addCriterion("user_user_id <>", value, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdGreaterThan(Long value) {
            addCriterion("user_user_id >", value, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_user_id >=", value, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdLessThan(Long value) {
            addCriterion("user_user_id <", value, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_user_id <=", value, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("user_user_id like", strValue, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdNotLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("user_user_id not like", strValue, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdIn(List<Long> values) {
            addCriterion("user_user_id in", values, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdNotIn(List<Long> values) {
            addCriterion("user_user_id not in", values, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdBetween(Long value1, Long value2) {
            addCriterion("user_user_id between", value1, value2, "userUserId");
            return (Criteria) this;
        }

        public Criteria andUserUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_user_id not between", value1, value2, "userUserId");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table daily_record
    */
    public  static class Criteria extends GeneratedCriteria{
        protected Criteria() {
            super();
        }
    }



    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}