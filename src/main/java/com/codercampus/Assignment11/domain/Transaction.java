package com.codercampus.Assignment11.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction implements Serializable, Comparable<Transaction> {
	// Curious, are we using this number?
	private static final long serialVersionUID = 5489045104890844953L;
	
	private Long id;
	private String retailer;
	private String description;
	private LocalDateTime date;
	private BigDecimal amount;
	private String type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", retailer=" + retailer + ", description=" + description + ", date=" + date
				+ ", amount=" + amount + ", type=" + type + "]";
	}
	// if 'this.getDate()' compared to 'that.getDate()' returns positive num.
	// 'this' should go after 'that', otherwise 'that' goes after 'this'
	@Override
	public int compareTo(Transaction that) {
		return this.getDate().compareTo(that.getDate());
	}

	// Best practices:
	// override 'hashCode()' and 'equals()' of objects 
	// in 'Domain' package
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}