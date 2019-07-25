package com.cdk.shoppingcart.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdk.shoppingcart.demo.model.Customer;
import com.cdk.shoppingcart.demo.model.DiscountSlab;

@Repository
public interface  DiscountSlabRepository extends CrudRepository<DiscountSlab, Long> {
	List<DiscountSlab> findByCustomerType_Id(Long customerTypeId);
}
