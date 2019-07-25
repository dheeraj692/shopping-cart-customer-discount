package com.cdk.shoppingcart.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "discount_slab")
public class DiscountSlab {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name="customer_type_id", referencedColumnName ="id")
	private CustomerType customerType;
	
	@Column(name="min_amount")
	private Long minAmount;
	
	@Column(name="max_amount")
	private Long maxAmount;
	
	@Column(name="discount")
	private Long discount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Long getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Long minAmount) {
		this.minAmount = minAmount;
	}

	public Long getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Long maxAmount) {
		this.maxAmount = maxAmount;
	}
	
}
