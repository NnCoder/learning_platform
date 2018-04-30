package com.edu.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class TchStuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TchStuExample() {
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

        public Criteria andTchAccountIsNull() {
            addCriterion("tch_account is null");
            return (Criteria) this;
        }

        public Criteria andTchAccountIsNotNull() {
            addCriterion("tch_account is not null");
            return (Criteria) this;
        }

        public Criteria andTchAccountEqualTo(String value) {
            addCriterion("tch_account =", value, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountNotEqualTo(String value) {
            addCriterion("tch_account <>", value, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountGreaterThan(String value) {
            addCriterion("tch_account >", value, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountGreaterThanOrEqualTo(String value) {
            addCriterion("tch_account >=", value, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountLessThan(String value) {
            addCriterion("tch_account <", value, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountLessThanOrEqualTo(String value) {
            addCriterion("tch_account <=", value, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountLike(String value) {
            addCriterion("tch_account like", value, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountNotLike(String value) {
            addCriterion("tch_account not like", value, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountIn(List<String> values) {
            addCriterion("tch_account in", values, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountNotIn(List<String> values) {
            addCriterion("tch_account not in", values, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountBetween(String value1, String value2) {
            addCriterion("tch_account between", value1, value2, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andTchAccountNotBetween(String value1, String value2) {
            addCriterion("tch_account not between", value1, value2, "tchAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountIsNull() {
            addCriterion("stu_account is null");
            return (Criteria) this;
        }

        public Criteria andStuAccountIsNotNull() {
            addCriterion("stu_account is not null");
            return (Criteria) this;
        }

        public Criteria andStuAccountEqualTo(String value) {
            addCriterion("stu_account =", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountNotEqualTo(String value) {
            addCriterion("stu_account <>", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountGreaterThan(String value) {
            addCriterion("stu_account >", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountGreaterThanOrEqualTo(String value) {
            addCriterion("stu_account >=", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountLessThan(String value) {
            addCriterion("stu_account <", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountLessThanOrEqualTo(String value) {
            addCriterion("stu_account <=", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountLike(String value) {
            addCriterion("stu_account like", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountNotLike(String value) {
            addCriterion("stu_account not like", value, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountIn(List<String> values) {
            addCriterion("stu_account in", values, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountNotIn(List<String> values) {
            addCriterion("stu_account not in", values, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountBetween(String value1, String value2) {
            addCriterion("stu_account between", value1, value2, "stuAccount");
            return (Criteria) this;
        }

        public Criteria andStuAccountNotBetween(String value1, String value2) {
            addCriterion("stu_account not between", value1, value2, "stuAccount");
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