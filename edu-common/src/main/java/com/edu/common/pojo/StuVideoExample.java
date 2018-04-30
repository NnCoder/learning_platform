package com.edu.common.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuVideoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuVideoExample() {
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

        public Criteria andStuAccountIsNull() {
            addCriterion("Stu_account is null");
            return (Criteria) this;
        }

        public Criteria andStuAccountIsNotNull() {
            addCriterion("Stu_account is not null");
            return (Criteria) this;
        }

        public Criteria andStuAccountEqualTo(String value) {
            addCriterion("Stu_account =", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountNotEqualTo(String value) {
            addCriterion("Stu_account <>", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountGreaterThan(String value) {
            addCriterion("Stu_account >", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountGreaterThanOrEqualTo(String value) {
            addCriterion("Stu_account >=", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountLessThan(String value) {
            addCriterion("Stu_account <", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountLessThanOrEqualTo(String value) {
            addCriterion("Stu_account <=", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountLike(String value) {
            addCriterion("Stu_account like", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountNotLike(String value) {
            addCriterion("Stu_account not like", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountIn(List<String> values) {
            addCriterion("Stu_account in", values, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountNotIn(List<String> values) {
            addCriterion("Stu_account not in", values, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountBetween(String value1, String value2) {
            addCriterion("Stu_account between", value1, value2, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountNotBetween(String value1, String value2) {
            addCriterion("Stu_account not between", value1, value2, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNull() {
            addCriterion("Video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNotNull() {
            addCriterion("Video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdEqualTo(Integer value) {
            addCriterion("Video_id =", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotEqualTo(Integer value) {
            addCriterion("Video_id <>", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThan(Integer value) {
            addCriterion("Video_id >", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Video_id >=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThan(Integer value) {
            addCriterion("Video_id <", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThanOrEqualTo(Integer value) {
            addCriterion("Video_id <=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIn(List<Integer> values) {
            addCriterion("Video_id in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotIn(List<Integer> values) {
            addCriterion("Video_id not in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdBetween(Integer value1, Integer value2) {
            addCriterion("Video_id between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Video_id not between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andLastVisitIsNull() {
            addCriterion("Last_visit is null");
            return (Criteria) this;
        }

        public Criteria andLastVisitIsNotNull() {
            addCriterion("Last_visit is not null");
            return (Criteria) this;
        }

        public Criteria andLastVisitEqualTo(Date value) {
            addCriterion("Last_visit =", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotEqualTo(Date value) {
            addCriterion("Last_visit <>", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitGreaterThan(Date value) {
            addCriterion("Last_visit >", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitGreaterThanOrEqualTo(Date value) {
            addCriterion("Last_visit >=", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitLessThan(Date value) {
            addCriterion("Last_visit <", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitLessThanOrEqualTo(Date value) {
            addCriterion("Last_visit <=", value, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitIn(List<Date> values) {
            addCriterion("Last_visit in", values, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotIn(List<Date> values) {
            addCriterion("Last_visit not in", values, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitBetween(Date value1, Date value2) {
            addCriterion("Last_visit between", value1, value2, "lastVisit");
            return (Criteria) this;
        }

        public Criteria andLastVisitNotBetween(Date value1, Date value2) {
            addCriterion("Last_visit not between", value1, value2, "lastVisit");
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