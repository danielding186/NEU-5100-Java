import java.util.Map;    
import java.util.HashMap; 


public class Assignment4 {
	
	/**
	 * The deadline of assignment4 is 10/12/2018 23:59 PST.
	 * Please feel free to contact Zane and Amanda for any questions.
	 */
	
	/*
	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
	 * s = "leetcode" return 0. 
	 * s = "loveleetcode" return 2.
	 */
	
	//score 2/2
    public int firstUniqChar(String s) {
    	Map<Character, Integer> map = new HashMap<Character, Integer> ();
    	for (int i = 0; i < s.length(); i++) {
    		Character c = s.charAt(i);
    		if (map.containsKey(c))
    			map.put(c, map.get(c)+1);
    		else
    			map.put(c, 1);
    	}
    	
    	for (int i = 0; i < s.length(); i++) {
    		Character c = s.charAt(i);
    		if (map.get(c) > 1)
    			continue;
    		else
    			return i;
    	}
    	
    	return -1;
    	
     }
    
    /*
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * Input: 38 Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {
    	if (n < 10)
    		return n;
    	
    	int count = 0;
    	while (n > 0) {
    		count += n % 10;
    		n = n / 10;
    	}
    	
    	return addDigits(count);  	
    }
    
    /*
     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
    	int i = 0, j = 0;
    	while(i < nums.length) {
    		if (nums[i] != 0)
    			nums[j++] = nums[i++];
    		else
    			i++;
    	}
    	
    	while (j < nums.length)
    		nums[j++] = 0;
    	
     }
	
    /*
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
     */
    
    private int maxPalindrome(String p, int index, int mode) {
    	
    	int left = index - 1;
    	int right = mode == 0 ? index : index+1;
    	int count = mode == 0 ? 0 : 1;
    	while (left >= 0 && right < p.length() && p.charAt(left) == p.charAt(right)) {
    		left--;
    		right++;
    		count += 2;
    	}
    	
    	return count;
    }
    
	public String longestPalindrome(String s) {
		int maxCount = 0, index = 0, mode = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 2; j++) {
				int count = maxPalindrome(s, i, j);
				if (count > maxCount) {
					index = i;
					mode = j;
					maxCount = count;
				}
			}
		}
		
		if (mode == 0)
			return s.substring(index - maxCount/2, index + maxCount/2);
		else
			return s.substring(index - maxCount/2, index + maxCount/2 + 1);
    }
	
    /*
     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * Given input matrix = [ [1,2,3],
  			      [4,5,6],
  			      [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
  								 [8,5,2],
  								  [9,6,3] ],
     */
	

	private void rotate_circle(int [][] a, int k) {
		int n = a.length;
		if (k >= n/2)
			return;
		
		int m = n - 2 * k;
		
    	int tmp[] = new int[m-1];
    	for (int i = 0; i < m - 1; i++)
    		tmp[i] = a[k][i+k];
    	
    	for (int i = 0; i < m - 1; i++)
    		a[k][i+k] = a[n-i-1-k][k];
    	
    	for (int i = 0; i < m - 1; i++)
    		a[i+k+1][k] = a[n-1-k][i+k+1];
    	
    	for (int i = 0; i < m - 1; i++)
    		a[n-1-k][n-1-i-k] = a[i+k][n-1-k];
    	
    	for (int i = 0; i < m - 1; i++)
    		a[i+k][n-1-k] = tmp[i];
	}
	
    public int[][] rotate(int[][] a) {
    	int n = a.length;
    	if (n == 1)
    		return a;
    	
    	// rotate from a[k][k] the k circle
    	for (int k = 0; k < n/2; k++)
    		rotate_circle(a, k);
    	
    	return a;
   }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Assignment4 assignment4 = new Assignment4();
		
		System.out.println("firstUniqChar(leetcode) = " + assignment4.firstUniqChar("leetcode"));
		System.out.println("firstUniqChar(loveleetcode) = " + assignment4.firstUniqChar("loveleetcode"));
		System.out.println("addDigits(38) = " + assignment4.addDigits(38));
		
		int b[] = {0, 4, 0, 1, 3, 4};
		System.out.println("Before moveZeroes is [0, 4, 0, 1, 3, 4]");
		assignment4.moveZeroes(b);
		System.out.print("After moveZeroes is [");
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i]+", ");
		System.out.println("]");
		
		System.out.println(assignment4.longestPalindrome("babad"));
		System.out.println(assignment4.longestPalindrome("ba"));
		System.out.println(assignment4.longestPalindrome("eefaaadaddac"));
		
		final int N = 7;
		int [][]a = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				a[i][j] = i * N + j + 1;
		
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++)
    			System.out.print(a[i][j] + ", ");
    		System.out.println("");
    	}    
		
    	System.out.println("xxxxxxxxxxxxxxxxxx");
		
		assignment4.rotate(a);
		
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++)
    			System.out.print(a[i][j] + ", ");
    		System.out.println("");
    	}    	
    
		
	}
    
}
