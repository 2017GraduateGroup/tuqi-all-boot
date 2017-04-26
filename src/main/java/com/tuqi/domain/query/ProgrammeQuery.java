package com.tuqi.domain.query;


import com.tuqi.mybatisgenerate.query.BaseQuery;
import com.tuqi.mybatisgenerate.query.BaseCriteria;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgrammeQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProgrammeQuery() {
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
     * This class corresponds to the database table programme
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andProgrammeidIsNull() {
            addCriterion("programmeId is null");
            return (Criteria) this;
        }

        public Criteria andProgrammeidIsNotNull() {
            addCriterion("programmeId is not null");
            return (Criteria) this;
        }

        public Criteria andProgrammeidEqualTo(Long value) {
            addCriterion("programmeId =", value, "id");
            return (Criteria) this;
        }

        public Criteria andProgrammeidNotEqualTo(Long value) {
            addCriterion("programmeId <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anProgrammeidGreaterThan(Long value) {
            addCriterion("programmeId >", value, "id");
            return (Criteria) this;
        }

        public Criteria andProgrammeidGreaterThanOrEqualTo(Long value) {
            addCriterion("programmeId >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andProgrammeidLessThan(Long value) {
            addCriterion("programmeId <", value, "id");
            return (Criteria) this;
        }

        public Criteria andProgrammeidLessThanOrEqualTo(Long value) {
            addCriterion("programmeId <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andProgrammeidIn(List<Long> values) {
            addCriterion("programmeId in", values, "id");
            return (Criteria) this;
        }

        public Criteria andProgrammeidNotIn(List<Long> values) {
            addCriterion("programmeId not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andProgrammeidBetween(Long value1, Long value2) {
            addCriterion("programmeId between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProgrammeidNotBetween(Long value1, Long value2) {
            addCriterion("programmeId not between", value1, value2, "id");
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

        public Criteria andProgrammeTimeIsNull() {
            addCriterion("programme_time is null");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeIsNotNull() {
            addCriterion("programme_time is not null");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeEqualTo(String value) {
            addCriterion("programme_time =", value, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeNotEqualTo(String value) {
            addCriterion("programme_time <>", value, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeGreaterThan(String value) {
            addCriterion("programme_time >", value, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeGreaterThanOrEqualTo(String value) {
            addCriterion("programme_time >=", value, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeLessThan(String value) {
            addCriterion("programme_time <", value, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeLessThanOrEqualTo(String value) {
            addCriterion("programme_time <=", value, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("programme_time like", strValue, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeNotLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("programme_time not like", strValue, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeIn(List<String> values) {
            addCriterion("programme_time in", values, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeNotIn(List<String> values) {
            addCriterion("programme_time not in", values, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeBetween(String value1, String value2) {
            addCriterion("programme_time between", value1, value2, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgrammeTimeNotBetween(String value1, String value2) {
            addCriterion("programme_time not between", value1, value2, "programmeTime");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdIsNull() {
            addCriterion("program_user_id is null");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdIsNotNull() {
            addCriterion("program_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdEqualTo(Long value) {
            addCriterion("program_user_id =", value, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdNotEqualTo(Long value) {
            addCriterion("program_user_id <>", value, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdGreaterThan(Long value) {
            addCriterion("program_user_id >", value, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("program_user_id >=", value, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdLessThan(Long value) {
            addCriterion("program_user_id <", value, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdLessThanOrEqualTo(Long value) {
            addCriterion("program_user_id <=", value, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("program_user_id like", strValue, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdNotLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("program_user_id not like", strValue, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdIn(List<Long> values) {
            addCriterion("program_user_id in", values, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdNotIn(List<Long> values) {
            addCriterion("program_user_id not in", values, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdBetween(Long value1, Long value2) {
            addCriterion("program_user_id between", value1, value2, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramUserIdNotBetween(Long value1, Long value2) {
            addCriterion("program_user_id not between", value1, value2, "programUserId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdIsNull() {
            addCriterion("program_type_id is null");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdIsNotNull() {
            addCriterion("program_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdEqualTo(Integer value) {
            addCriterion("program_type_id =", value, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdNotEqualTo(Integer value) {
            addCriterion("program_type_id <>", value, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdGreaterThan(Integer value) {
            addCriterion("program_type_id >", value, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("program_type_id >=", value, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdLessThan(Integer value) {
            addCriterion("program_type_id <", value, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("program_type_id <=", value, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdLike(Integer value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("program_type_id like", strValue, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdNotLike(Integer value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("program_type_id not like", strValue, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdIn(List<Integer> values) {
            addCriterion("program_type_id in", values, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdNotIn(List<Integer> values) {
            addCriterion("program_type_id not in", values, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("program_type_id between", value1, value2, "programTypeId");
            return (Criteria) this;
        }

        public Criteria andProgramTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("program_type_id not between", value1, value2, "programTypeId");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table programme
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