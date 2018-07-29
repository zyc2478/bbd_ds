package com.autobid.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

public class VwBidListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public VwBidListExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
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

        public Criteria andBid_total_amountIsNull() {
            addCriterion("bid_total_amount is null");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountIsNotNull() {
            addCriterion("bid_total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountEqualTo(BigDecimal value) {
            addCriterion("bid_total_amount =", value, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountNotEqualTo(BigDecimal value) {
            addCriterion("bid_total_amount <>", value, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountGreaterThan(BigDecimal value) {
            addCriterion("bid_total_amount >", value, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bid_total_amount >=", value, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountLessThan(BigDecimal value) {
            addCriterion("bid_total_amount <", value, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bid_total_amount <=", value, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountIn(List<BigDecimal> values) {
            addCriterion("bid_total_amount in", values, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountNotIn(List<BigDecimal> values) {
            addCriterion("bid_total_amount not in", values, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bid_total_amount between", value1, value2, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_total_amountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bid_total_amount not between", value1, value2, "bid_total_amount");
            return (Criteria) this;
        }

        public Criteria andBid_countIsNull() {
            addCriterion("bid_count is null");
            return (Criteria) this;
        }

        public Criteria andBid_countIsNotNull() {
            addCriterion("bid_count is not null");
            return (Criteria) this;
        }

        public Criteria andBid_countEqualTo(Long value) {
            addCriterion("bid_count =", value, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countNotEqualTo(Long value) {
            addCriterion("bid_count <>", value, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countGreaterThan(Long value) {
            addCriterion("bid_count >", value, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countGreaterThanOrEqualTo(Long value) {
            addCriterion("bid_count >=", value, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countLessThan(Long value) {
            addCriterion("bid_count <", value, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countLessThanOrEqualTo(Long value) {
            addCriterion("bid_count <=", value, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countIn(List<Long> values) {
            addCriterion("bid_count in", values, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countNotIn(List<Long> values) {
            addCriterion("bid_count not in", values, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countBetween(Long value1, Long value2) {
            addCriterion("bid_count between", value1, value2, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_countNotBetween(Long value1, Long value2) {
            addCriterion("bid_count not between", value1, value2, "bid_count");
            return (Criteria) this;
        }

        public Criteria andBid_dateIsNull() {
            addCriterion("bid_date is null");
            return (Criteria) this;
        }

        public Criteria andBid_dateIsNotNull() {
            addCriterion("bid_date is not null");
            return (Criteria) this;
        }

        public Criteria andBid_dateEqualTo(Date value) {
            addCriterion("bid_date =", value, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateNotEqualTo(Date value) {
            addCriterion("bid_date <>", value, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateGreaterThan(Date value) {
            addCriterion("bid_date >", value, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("bid_date >=", value, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateLessThan(Date value) {
            addCriterion("bid_date <", value, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateLessThanOrEqualTo(Date value) {
            addCriterion("bid_date <=", value, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateIn(List<Date> values) {
            addCriterion("bid_date in", values, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateNotIn(List<Date> values) {
            addCriterion("bid_date not in", values, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateBetween(Date value1, Date value2) {
            addCriterion("bid_date between", value1, value2, "bid_date");
            return (Criteria) this;
        }

        public Criteria andBid_dateNotBetween(Date value1, Date value2) {
            addCriterion("bid_date not between", value1, value2, "bid_date");
            return (Criteria) this;
        }
    }

    /**
     */
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