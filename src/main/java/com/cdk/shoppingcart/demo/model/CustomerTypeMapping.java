package com.cdk.shoppingcart.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer_type_mapping")
public class CustomerTypeMapping {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JoinColumn(name="customer_id", referencedColumnName ="id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="customer_type_id", referencedColumnName ="id")
	private CustomerType customerType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	
}
