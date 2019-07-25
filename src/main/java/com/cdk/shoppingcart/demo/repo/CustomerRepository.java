package com.cdk.shoppingcart.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cdk.shoppingcart.demo.model.Customer;

@Repository
public interface  CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findOneById(Long customerId);
}
