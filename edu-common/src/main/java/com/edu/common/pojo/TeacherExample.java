package com.edu.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTchNameIsNull() {
            addCriterion("tch_name is null");
            return (Criteria) this;
        }

        public Criteria andTchNameIsNotNull() {
            addCriterion("tch_name is not null");
            return (Criteria) this;
        }

        public Criteria andTchNameEqualTo(String value) {
            addCriterion("tch_name =", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameNotEqualTo(String value) {
            addCriterion("tch_name <>", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameGreaterThan(String value) {
            addCriterion("tch_name >", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameGreaterThanOrEqualTo(String value) {
            addCriterion("tch_name >=", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameLessThan(String value) {
            addCriterion("tch_name <", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameLessThanOrEqualTo(String value) {
            addCriterion("tch_name <=", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameLike(String value) {
            addCriterion("tch_name like", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameNotLike(String value) {
            addCriterion("tch_name not like", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameIn(List<String> values) {
            addCriterion("tch_name in", values, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameNotIn(List<String> values) {
            addCriterion("tch_name not in", values, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameBetween(String value1, String value2) {
            addCriterion("tch_name between", value1, value2, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameNotBetween(String value1, String value2) {
            addCriterion("tch_name not between", value1, value2, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchPasswordIsNull() {
            addCriterion("tch_password is null");
            return (Criteria) this;
        }

        public Criteria andTchPasswordIsNotNull() {
            addCriterion("tch_password is not null");
            return (Criteria) this;
        }

        public Criteria andTchPasswordEqualTo(String value) {
            addCriterion("tch_password =", value, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordNotEqualTo(String value) {
            addCriterion("tch_password <>", value, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordGreaterThan(String value) {
            addCriterion("tch_password >", value, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("tch_password >=", value, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordLessThan(String value) {
            addCriterion("tch_password <", value, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordLessThanOrEqualTo(String value) {
            addCriterion("tch_password <=", value, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordLike(String value) {
            addCriterion("tch_password like", value, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordNotLike(String value) {
            addCriterion("tch_password not like", value, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordIn(List<String> values) {
            addCriterion("tch_password in", values, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordNotIn(List<String> values) {
            addCriterion("tch_password not in", values, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordBetween(String value1, String value2) {
            addCriterion("tch_password between", value1, value2, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andTchPasswordNotBetween(String value1, String value2) {
            addCriterion("tch_password not between", value1, value2, "tchPassword");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("role like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("role not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("role not between", value1, value2, "role");
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

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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