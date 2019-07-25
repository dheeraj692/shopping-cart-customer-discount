package com.cdk.shoppingcart.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cdk.shoppingcart.demo.model.Customer;
import com.cdk.shoppingcart.demo.repo.CustomerRepository;
import com.cdk.shoppingcart.demo.repo.DiscountSlabRepository;
import com.cdk.shoppingcart.demo.service.BillingService;
import com.cdk.shoppingcart.demo.service.BillingServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingcartApplicationTests {
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DiscountSlabRepository discountSlabRepository;
	
	@Test
	public void whenFindById_thenReturnCustomer() {
		Customer customer = customerRepository.findOneById(101L);
		assertEquals(customer.getName(), "Dheeraj");
	}
	
	@Test
	public void whenPurchaseAmountGiven_calcBillAmount_forRegularNil() throws Exception {
		Float billAmount = billingService.calculateBillAmount(5000L, 101L);
		Float expectedBillAmount = 5000f;
		assertEquals(expectedBillAmount, billAmount);
	}
	
	@Test
	public void whenPurchaseAmountGiven_calcBillAmount_forRegular10() throws Exception {
		Float billAmount = billingService.calculateBillAmount(10000L, 101L);
		Float expectedBillAmount = 9500f;
		assertEquals(expectedBillAmount, billAmount);
	}
	
	@Test
	public void whenPurchaseAmountGiven_calcBillAmount_forRegular20() throws Exception {
		Float billAmount = billingService.calculateBillAmount(15000L, 101L);
		Float expectedBillAmount = 13500f;
		assertEquals(expectedBillAmount, billAmount);
	}
	
	@Test
	public void whenPurchaseAmountGiven_calcBillAmount_forPremium10() throws Exception {
		Float billAmount = billingService.calculateBillAmount(4000L, 102L);
		Float expectedBillAmount = 3600f;
		assertEquals(expectedBillAmount, billAmount);
	}
	
	@Test
	public void whenPurchaseAmountGiven_calcBillAmount_forPremium15() throws Exception {
		Float billAmount = billingService.calculateBillAmount(8000L, 102L);
		Float expectedBillAmount = 7000f;
		assertEquals(expectedBillAmount, billAmount);
	}
	
	@Test
	public void whenPurchaseAmountGiven_calcBillAmount_forPremium20() throws Exception {
		Float billAmount = billingService.calculateBillAmount(12000L, 102L);
		Float expectedBillAmount = 10200f;
		assertEquals(expectedBillAmount, billAmount);
	}
	
	@Test
	public void whenPurchaseAmountGiven_calcBillAmount_forPremium30() throws Exception {
		Float billAmount = billingService.calculateBillAmount(20000L, 102L);
		Float expectedBillAmount = 15800f;
		assertEquals(expectedBillAmount, billAmount);
	}
	
	@Test
	public void whenPurchaseAmountGiven_calcBillAmount_forPremium30IncorrectUser() throws Exception {
		Float billAmount = billingService.calculateBillAmount(20000L, 101L);
		Float expectedBillAmount = 15800f;
		assertNotEquals(expectedBillAmount, billAmount);
	}
	
	@Test
	public void whenIncorrectUserId_thenThrowException() {
		try {
			billingService.calculateBillAmount(20000L, 105L);
		} catch (Exception e) {
			assertEquals("Customer Not found with given id", e.getMessage());
		}
	}

}
