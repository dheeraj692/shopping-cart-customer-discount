package com.cdk.shoppingcart.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.shoppingcart.demo.model.Customer;
import com.cdk.shoppingcart.demo.model.DiscountSlab;
import com.cdk.shoppingcart.demo.repo.CustomerRepository;
import com.cdk.shoppingcart.demo.repo.DiscountSlabRepository;

@Service
public class BillingServiceImpl implements BillingService{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DiscountSlabRepository discountSlabRepository;
	
	public Float calculateBillAmount(Long purchaseAmount, Long customerId) throws Exception {
		System.out.println("customerId"+customerId);
		Customer customer = customerRepository.findOneById(customerId);
		if(customer==null) {
			throw new Exception("Customer Not found with given id");
		}
		System.out.println("customer "+customer.getCustomerTypeMapping().getCustomerType().getId());
		List<DiscountSlab> DiscountSlabList = discountSlabRepository.findByCustomerType_Id(customer.getCustomerTypeMapping().getCustomerType().getId());
		Long discount = 0L;
		Float billAmount = 0f;
		Long remainingAmount = 0L;
		for (DiscountSlab discountSlab : DiscountSlabList) {
			if(discountSlab.getMaxAmount()==null && purchaseAmount>discountSlab.getMinAmount()) {
				discount = discountSlab.getDiscount();
				billAmount = billAmount + ((purchaseAmount-discountSlab.getMinAmount()) * (1 - (discount/(float)100)));
				remainingAmount = discountSlab.getMinAmount();
			} else if(discountSlab.getMaxAmount()!=null && purchaseAmount<=discountSlab.getMaxAmount() && purchaseAmount>discountSlab.getMinAmount()) {
				discount = discountSlab.getDiscount();
				billAmount = billAmount + ((purchaseAmount-discountSlab.getMinAmount()) * (1 - (discount/(float)100)));
				remainingAmount = discountSlab.getMinAmount();
			} else if(discountSlab.getMaxAmount()!=null && purchaseAmount>=discountSlab.getMaxAmount() && purchaseAmount>discountSlab.getMinAmount()) {
				discount = discountSlab.getDiscount();
				billAmount = billAmount + ((discountSlab.getMaxAmount()-discountSlab.getMinAmount()) * (1 - (discount/(float)100)));
				remainingAmount = purchaseAmount - (discountSlab.getMaxAmount()-discountSlab.getMinAmount());
			}
			if(remainingAmount==0) {
				break;
			}
		}
		
		return billAmount;
	}
}
