package assignment7;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Soultion4Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Solution4 solution4 = new Solution4();
		
		List<Interval> list = new LinkedList<>();
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(16, 18));
		
		List<Interval> expected = new LinkedList<>();
		expected.add(new Interval(1, 6));
		expected.add(new Interval(8, 10));
		expected.add(new Interval(16, 18));
		
		List<Interval> actual = solution4.merge(list);
		
		assertEquals(expected.toString(), actual.toString());
		
	}
	
	@Test
	public void test2() {
		Solution4 solution4 = new Solution4();
		
		List<Interval> list = new LinkedList<>();
		list.add(new Interval(1, 3));
		List<Interval> actual = solution4.merge(list);
		assertEquals(list.toString(), actual.toString());
	}

	
	@Test
	public void test3() {
		Solution4 solution4 = new Solution4();
		
		List<Interval> list = new LinkedList<>();
		list.add(new Interval(1, 3));
		list.add(new Interval(3, 5));
		
		List<Interval> expected = new LinkedList<>();
		expected.add(new Interval(1, 5));
		
		
		List<Interval> actual = solution4.merge(list);
		assertEquals(expected.toString(), actual.toString());
	}
}
