package com.edu.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VideoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
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

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andVedioIdIsNull() {
            addCriterion("Vedio_id is null");
            return (Criteria) this;
        }

        public Criteria andVedioIdIsNotNull() {
            addCriterion("Vedio_id is not null");
            return (Criteria) this;
        }

        public Criteria andVedioIdEqualTo(Integer value) {
            addCriterion("Vedio_id =", value, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdNotEqualTo(Integer value) {
            addCriterion("Vedio_id <>", value, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdGreaterThan(Integer value) {
            addCriterion("Vedio_id >", value, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Vedio_id >=", value, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdLessThan(Integer value) {
            addCriterion("Vedio_id <", value, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdLessThanOrEqualTo(Integer value) {
            addCriterion("Vedio_id <=", value, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdIn(List<Integer> values) {
            addCriterion("Vedio_id in", values, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdNotIn(List<Integer> values) {
            addCriterion("Vedio_id not in", values, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdBetween(Integer value1, Integer value2) {
            addCriterion("Vedio_id between", value1, value2, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Vedio_id not between", value1, value2, "vedioId");
            return (Criteria) this;
        }

        public Criteria andVedioNameIsNull() {
            addCriterion("Vedio_name is null");
            return (Criteria) this;
        }

        public Criteria andVedioNameIsNotNull() {
            addCriterion("Vedio_name is not null");
            return (Criteria) this;
        }

        public Criteria andVedioNameEqualTo(String value) {
            addCriterion("Vedio_name =", value, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameNotEqualTo(String value) {
            addCriterion("Vedio_name <>", value, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameGreaterThan(String value) {
            addCriterion("Vedio_name >", value, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameGreaterThanOrEqualTo(String value) {
            addCriterion("Vedio_name >=", value, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameLessThan(String value) {
            addCriterion("Vedio_name <", value, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameLessThanOrEqualTo(String value) {
            addCriterion("Vedio_name <=", value, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameLike(String value) {
            addCriterion("Vedio_name like", value, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameNotLike(String value) {
            addCriterion("Vedio_name not like", value, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameIn(List<String> values) {
            addCriterion("Vedio_name in", values, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameNotIn(List<String> values) {
            addCriterion("Vedio_name not in", values, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameBetween(String value1, String value2) {
            addCriterion("Vedio_name between", value1, value2, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioNameNotBetween(String value1, String value2) {
            addCriterion("Vedio_name not between", value1, value2, "vedioName");
            return (Criteria) this;
        }

        public Criteria andVedioSrcIsNull() {
            addCriterion("Vedio_src is null");
            return (Criteria) this;
        }

        public Criteria andVedioSrcIsNotNull() {
            addCriterion("Vedio_src is not null");
            return (Criteria) this;
        }

        public Criteria andVedioSrcEqualTo(String value) {
            addCriterion("Vedio_src =", value, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcNotEqualTo(String value) {
            addCriterion("Vedio_src <>", value, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcGreaterThan(String value) {
            addCriterion("Vedio_src >", value, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcGreaterThanOrEqualTo(String value) {
            addCriterion("Vedio_src >=", value, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcLessThan(String value) {
            addCriterion("Vedio_src <", value, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcLessThanOrEqualTo(String value) {
            addCriterion("Vedio_src <=", value, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcLike(String value) {
            addCriterion("Vedio_src like", value, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcNotLike(String value) {
            addCriterion("Vedio_src not like", value, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcIn(List<String> values) {
            addCriterion("Vedio_src in", values, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcNotIn(List<String> values) {
            addCriterion("Vedio_src not in", values, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcBetween(String value1, String value2) {
            addCriterion("Vedio_src between", value1, value2, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioSrcNotBetween(String value1, String value2) {
            addCriterion("Vedio_src not between", value1, value2, "vedioSrc");
            return (Criteria) this;
        }

        public Criteria andVedioGradeIsNull() {
            addCriterion("Vedio_grade is null");
            return (Criteria) this;
        }

        public Criteria andVedioGradeIsNotNull() {
            addCriterion("Vedio_grade is not null");
            return (Criteria) this;
        }

        public Criteria andVedioGradeEqualTo(Byte value) {
            addCriterion("Vedio_grade =", value, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeNotEqualTo(Byte value) {
            addCriterion("Vedio_grade <>", value, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeGreaterThan(Byte value) {
            addCriterion("Vedio_grade >", value, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeGreaterThanOrEqualTo(Byte value) {
            addCriterion("Vedio_grade >=", value, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeLessThan(Byte value) {
            addCriterion("Vedio_grade <", value, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeLessThanOrEqualTo(Byte value) {
            addCriterion("Vedio_grade <=", value, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeIn(List<Byte> values) {
            addCriterion("Vedio_grade in", values, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeNotIn(List<Byte> values) {
            addCriterion("Vedio_grade not in", values, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeBetween(Byte value1, Byte value2) {
            addCriterion("Vedio_grade between", value1, value2, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVedioGradeNotBetween(Byte value1, Byte value2) {
            addCriterion("Vedio_grade not between", value1, value2, "vedioGrade");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNull() {
            addCriterion("Visit_time is null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIsNotNull() {
            addCriterion("Visit_time is not null");
            return (Criteria) this;
        }

        public Criteria andVisitTimeEqualTo(Integer value) {
            addCriterion("Visit_time =", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotEqualTo(Integer value) {
            addCriterion("Visit_time <>", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThan(Integer value) {
            addCriterion("Visit_time >", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Visit_time >=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThan(Integer value) {
            addCriterion("Visit_time <", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeLessThanOrEqualTo(Integer value) {
            addCriterion("Visit_time <=", value, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeIn(List<Integer> values) {
            addCriterion("Visit_time in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotIn(List<Integer> values) {
            addCriterion("Visit_time not in", values, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeBetween(Integer value1, Integer value2) {
            addCriterion("Visit_time between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andVisitTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("Visit_time not between", value1, value2, "visitTime");
            return (Criteria) this;
        }

        public Criteria andKpIdIsNull() {
            addCriterion("kp_id is null");
            return (Criteria) this;
        }

        public Criteria andKpIdIsNotNull() {
            addCriterion("kp_id is not null");
            return (Criteria) this;
        }

        public Criteria andKpIdEqualTo(Integer value) {
            addCriterion("kp_id =", value, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdNotEqualTo(Integer value) {
            addCriterion("kp_id <>", value, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdGreaterThan(Integer value) {
            addCriterion("kp_id >", value, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("kp_id >=", value, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdLessThan(Integer value) {
            addCriterion("kp_id <", value, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdLessThanOrEqualTo(Integer value) {
            addCriterion("kp_id <=", value, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdIn(List<Integer> values) {
            addCriterion("kp_id in", values, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdNotIn(List<Integer> values) {
            addCriterion("kp_id not in", values, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdBetween(Integer value1, Integer value2) {
            addCriterion("kp_id between", value1, value2, "kpId");
            return (Criteria) this;
        }

        public Criteria andKpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("kp_id not between", value1, value2, "kpId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNull() {
            addCriterion("create_account is null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIsNotNull() {
            addCriterion("create_account is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAccountEqualTo(String value) {
            addCriterion("create_account =", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotEqualTo(String value) {
            addCriterion("create_account <>", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThan(String value) {
            addCriterion("create_account >", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountGreaterThanOrEqualTo(String value) {
            addCriterion("create_account >=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThan(String value) {
            addCriterion("create_account <", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLessThanOrEqualTo(String value) {
            addCriterion("create_account <=", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountLike(String value) {
            addCriterion("create_account like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotLike(String value) {
            addCriterion("create_account not like", value, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountIn(List<String> values) {
            addCriterion("create_account in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotIn(List<String> values) {
            addCriterion("create_account not in", values, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountBetween(String value1, String value2) {
            addCriterion("create_account between", value1, value2, "createAccount");
            return (Criteria) this;
        }

        public Criteria andCreateAccountNotBetween(String value1, String value2) {
            addCriterion("create_account not between", value1, value2, "createAccount");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}