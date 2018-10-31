package assignment7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Solution5Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Solution5 solution5 = new Solution5();
		int nums1[] = {1,3};
		int nums2[] = {2,4};
		
		assertTrue(solution5.findMedianSortedArrays(nums1, nums2) == 2.5);
	}
	
	@Test
	public void test2() {
		Solution5 solution5 = new Solution5();
		int nums1[] = {1,3};
		int nums2[] = {2,};
		
		assertTrue(solution5.findMedianSortedArrays(nums1, nums2) == 2);
	}
	
	@Test
	public void test3() {
		Solution5 solution5 = new Solution5();
		int nums1[] = {1,3};
		int nums2[] = {};
		
		assertTrue(solution5.findMedianSortedArrays(nums1, nums2) == 2);
	}
	
	@Test
	public void test4() {
		Solution5 solution5 = new Solution5();
		int nums1[] = {1,3};
		int nums2[] = {5,6,7,8,9};
		
		assertTrue(solution5.findMedianSortedArrays(nums1, nums2) == 6);
	}
	
	
	@Test
	public void test5() {
		Solution5 solution5 = new Solution5();
		int nums1[] = {10,11};
		int nums2[] = {5,6,7,8,9};
		
		assertTrue(solution5.findMedianSortedArrays(nums1, nums2) == 8);
	}
	
	@Test
	public void test6() {
		Solution5 solution5 = new Solution5();
		int nums1[] = {10,11, 12};
		int nums2[] = {5,6,7,8,9};
		
		assertTrue(solution5.findMedianSortedArrays(nums1, nums2) == 8.5);
	}
}
