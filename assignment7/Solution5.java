package assignment7;

public class Solution5 {

	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 
		 // Divide the whole data to left and right set, and
		 // any elements in left <= any elements in right, the left size is (m+n)/2 elements
		 // So (m+n)/2 is even, the middle should be the maximum(left) + minimum(right)/2
		 // (m+n)/2 is odd, the middle should be the minimum(right)
		 
		 if (nums1.length > nums2.length) {
			 int [] t = nums2;
			 nums2 = nums1;
			 nums1 = t;
		 }
		 
		 int m = nums1.length, n = nums2.length;

		 
		 // We need to calculate how many elements from nums1 to be added in left set
		 // low for 0 means zero elements of nums1 to be added in left set
		 //  high for m  means all elements of nums1 to be added to right set
		 int low = 0, high = m, i=0, j=(m+n)/2;
		 
		 while(low <= high) {
			 i = (low+high)/2;
			 j = (m+n)/2 - i;
			 
			 if ((i == 0 || nums1[i-1] <= nums2[j]) && (i == m || nums2[j-1] <= nums1[i]))
				 break;
			 
			 if (i != 0 && nums1[i-1] > nums2[j]) {
				 high = i - 1;
			 }
			 else
				 low = i + 1;
		 }
		 
		 if ((m+n)%2 == 1) {
			 if (i == m)
				 return nums2[j];
			 else
				 return Math.min(nums1[i], nums2[j]);
		 } else {
			
			 int max = (i == 0 ? nums2[j-1] : (j == 0 ? nums1[i-1] : Math.max(nums1[i-1], nums2[j-1])));
			 int min = (i == m ? nums2[j]: (j == n ? nums1[i] : Math.min(nums1[i], nums2[j])));
			 return (max+min)/2.;
		 }
	 }
	
	public static void main(String[] args) {
		Solution5 solution5 = new Solution5();
		int nums1[] = {1,5};
		int nums2[] = {2,3,4,6};
		
		System.out.println(solution5.findMedianSortedArrays(nums1, nums2));

	}

}
