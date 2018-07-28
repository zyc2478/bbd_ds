package com.autobid.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * bid_list
 * @author 
 */
@Table(name="bid_list")
public class BidList implements Serializable {
    @Id
    @GeneratedValue
    private Integer listingId;

    @NotEmpty
    private String title;

    @NotEmpty
    private Integer months;

    @NotEmpty
    private Double rate;

    @NotEmpty
    private Long amount;

    @NotEmpty
    private Integer bidAmount;

    private Date bidDate;

    private static final long serialVersionUID = 1L;

    public Integer getListingId() {
        return listingId;
    }

    public void setListingId(Integer listingId) {
        this.listingId = listingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
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
        BidList other = (BidList) that;
        return (this.getListingId() == null ? other.getListingId() == null : this.getListingId().equals(other.getListingId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getMonths() == null ? other.getMonths() == null : this.getMonths().equals(other.getMonths()))
            && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getBidAmount() == null ? other.getBidAmount() == null : this.getBidAmount().equals(other.getBidAmount()))
            && (this.getBidDate() == null ? other.getBidDate() == null : this.getBidDate().equals(other.getBidDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getListingId() == null) ? 0 : getListingId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getMonths() == null) ? 0 : getMonths().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getBidAmount() == null) ? 0 : getBidAmount().hashCode());
        result = prime * result + ((getBidDate() == null) ? 0 : getBidDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", listingId=").append(listingId);
        sb.append(", title=").append(title);
        sb.append(", months=").append(months);
        sb.append(", rate=").append(rate);
        sb.append(", amount=").append(amount);
        sb.append(", bidAmount=").append(bidAmount);
        sb.append(", bidDate=").append(bidDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}