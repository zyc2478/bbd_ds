package com.autobid.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * vw_bid_list
 * @author 
 */
@Table(name="vw_bid_list")
public class VwBidList implements Serializable {
    private String bid_date;

    @NotEmpty
    private Long bid_count;

    private BigDecimal bid_total_amount;

    private Date bid_date_time;

    private static final long serialVersionUID = 1L;

    public String getBid_date() {
        return bid_date;
    }

    public void setBid_date(String bid_date) {
        this.bid_date = bid_date;
    }

    public Long getBid_count() {
        return bid_count;
    }

    public void setBid_count(Long bid_count) {
        this.bid_count = bid_count;
    }

    public BigDecimal getBid_total_amount() {
        return bid_total_amount;
    }

    public void setBid_total_amount(BigDecimal bid_total_amount) {
        this.bid_total_amount = bid_total_amount;
    }

    public Date getBid_date_time() {
        return bid_date_time;
    }

    public void setBid_date_time(Date bid_date_time) {
        this.bid_date_time = bid_date_time;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        VwBidList other = (VwBidList) that;
        return (this.getBid_date() == null ? other.getBid_date() == null : this.getBid_date().equals(other.getBid_date()))
            && (this.getBid_count() == null ? other.getBid_count() == null : this.getBid_count().equals(other.getBid_count()))
            && (this.getBid_total_amount() == null ? other.getBid_total_amount() == null : this.getBid_total_amount().equals(other.getBid_total_amount()))
            && (this.getBid_date_time() == null ? other.getBid_date_time() == null : this.getBid_date_time().equals(other.getBid_date_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBid_date() == null) ? 0 : getBid_date().hashCode());
        result = prime * result + ((getBid_count() == null) ? 0 : getBid_count().hashCode());
        result = prime * result + ((getBid_total_amount() == null) ? 0 : getBid_total_amount().hashCode());
        result = prime * result + ((getBid_date_time() == null) ? 0 : getBid_date_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bid_date=").append(bid_date);
        sb.append(", bid_count=").append(bid_count);
        sb.append(", bid_total_amount=").append(bid_total_amount);
        sb.append(", bid_date_time=").append(bid_date_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}