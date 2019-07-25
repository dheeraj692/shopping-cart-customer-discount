package com.cdk.shoppingcart.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(mappedBy="customer")
	private CustomerTypeMapping customerTypeMapping;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerTypeMapping getCustomerTypeMapping() {
		return customerTypeMapping;
	}

	public void setCustomerTypeMapping(CustomerTypeMapping customerTypeMapping) {
		this.customerTypeMapping = customerTypeMapping;
	}
	
}
