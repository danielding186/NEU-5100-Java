package assignment5.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assignment5.*;

public class CheckoutTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Checkout checkout = new Checkout();

        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25f, 399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
        checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
        
		
		assertEquals(checkout.numberOfItems(), 4);
		checkout.clear();
		assertEquals(checkout.numberOfItems(), 0);
	}
	
	@Test
	public void test2() {
		Checkout checkout = new Checkout();
		assertEquals(checkout.numberOfItems(), 0);
	}

}
