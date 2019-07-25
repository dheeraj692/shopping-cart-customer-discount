package com.cdk.shoppingcart.demo.service;

public interface BillingService {
	public Float calculateBillAmount(Long purchaseAmount, Long customerId) throws Exception;
}
