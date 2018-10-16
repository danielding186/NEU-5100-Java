package assignment5.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import assignment5.Candy;

public class CandyTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Candy ca = new Candy("Peanut Butter Fudge", 2.25f, 399);
		assertEquals(ca.getCost(), 898);	
	}

}
