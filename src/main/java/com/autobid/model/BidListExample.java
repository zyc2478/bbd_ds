package com.autobid.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

public class BidListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public BidListExample() {
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

        public Criteria andListingIdIsNull() {
            addCriterion("listingId is null");
            return (Criteria) this;
        }

        public Criteria andListingIdIsNotNull() {
            addCriterion("listingId is not null");
            return (Criteria) this;
        }

        public Criteria andListingIdEqualTo(Integer value) {
            addCriterion("listingId =", value, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdNotEqualTo(Integer value) {
            addCriterion("listingId <>", value, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdGreaterThan(Integer value) {
            addCriterion("listingId >", value, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("listingId >=", value, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdLessThan(Integer value) {
            addCriterion("listingId <", value, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdLessThanOrEqualTo(Integer value) {
            addCriterion("listingId <=", value, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdIn(List<Integer> values) {
            addCriterion("listingId in", values, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdNotIn(List<Integer> values) {
            addCriterion("listingId not in", values, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdBetween(Integer value1, Integer value2) {
            addCriterion("listingId between", value1, value2, "listingId");
            return (Criteria) this;
        }

        public Criteria andListingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("listingId not between", value1, value2, "listingId");
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
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
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

        public Criteria andMonthsIsNull() {
            addCriterion("`months` is null");
            return (Criteria) this;
        }

        public Criteria andMonthsIsNotNull() {
            addCriterion("`months` is not null");
            return (Criteria) this;
        }

        public Criteria andMonthsEqualTo(Integer value) {
            addCriterion("`months` =", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotEqualTo(Integer value) {
            addCriterion("`months` <>", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsGreaterThan(Integer value) {
            addCriterion("`months` >", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsGreaterThanOrEqualTo(Integer value) {
            addCriterion("`months` >=", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsLessThan(Integer value) {
            addCriterion("`months` <", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsLessThanOrEqualTo(Integer value) {
            addCriterion("`months` <=", value, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsIn(List<Integer> values) {
            addCriterion("`months` in", values, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotIn(List<Integer> values) {
            addCriterion("`months` not in", values, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsBetween(Integer value1, Integer value2) {
            addCriterion("`months` between", value1, value2, "months");
            return (Criteria) this;
        }

        public Criteria andMonthsNotBetween(Integer value1, Integer value2) {
            addCriterion("`months` not between", value1, value2, "months");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(Double value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(Double value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(Double value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(Double value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(Double value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(Double value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<Double> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<Double> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(Double value1, Double value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(Double value1, Double value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andBidAmountIsNull() {
            addCriterion("bidAmount is null");
            return (Criteria) this;
        }

        public Criteria andBidAmountIsNotNull() {
            addCriterion("bidAmount is not null");
            return (Criteria) this;
        }

        public Criteria andBidAmountEqualTo(Integer value) {
            addCriterion("bidAmount =", value, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountNotEqualTo(Integer value) {
            addCriterion("bidAmount <>", value, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountGreaterThan(Integer value) {
            addCriterion("bidAmount >", value, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bidAmount >=", value, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountLessThan(Integer value) {
            addCriterion("bidAmount <", value, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountLessThanOrEqualTo(Integer value) {
            addCriterion("bidAmount <=", value, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountIn(List<Integer> values) {
            addCriterion("bidAmount in", values, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountNotIn(List<Integer> values) {
            addCriterion("bidAmount not in", values, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountBetween(Integer value1, Integer value2) {
            addCriterion("bidAmount between", value1, value2, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("bidAmount not between", value1, value2, "bidAmount");
            return (Criteria) this;
        }

        public Criteria andBidDateIsNull() {
            addCriterion("bidDate is null");
            return (Criteria) this;
        }

        public Criteria andBidDateIsNotNull() {
            addCriterion("bidDate is not null");
            return (Criteria) this;
        }

        public Criteria andBidDateEqualTo(Date value) {
            addCriterion("bidDate =", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateNotEqualTo(Date value) {
            addCriterion("bidDate <>", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateGreaterThan(Date value) {
            addCriterion("bidDate >", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateGreaterThanOrEqualTo(Date value) {
            addCriterion("bidDate >=", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateLessThan(Date value) {
            addCriterion("bidDate <", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateLessThanOrEqualTo(Date value) {
            addCriterion("bidDate <=", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateIn(List<Date> values) {
            addCriterion("bidDate in", values, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateNotIn(List<Date> values) {
            addCriterion("bidDate not in", values, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateBetween(Date value1, Date value2) {
            addCriterion("bidDate between", value1, value2, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateNotBetween(Date value1, Date value2) {
            addCriterion("bidDate not between", value1, value2, "bidDate");
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