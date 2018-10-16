package assignment5Extra;
import java.util.*;

public class MatrixSpiralOrder {
	
	/*
	 *    
	 *    For example, Given the following matrix: 
				{{1,2,3},
				{4,5,6},
				{7,8,9}}
				You should return {1,2,3,6,9,8,7,4,5}.
	 * 
	 */
	
	private void spiral(int[][] a, int level, List<Integer> list) {
		int N = a.length;
		if (level > N/2)
			return;
		
		if (N - level - 1 == level) {
			list.add(a[level][level]);
			return;
		}
		
		
		for (int i = level; i < N - level - 1; i++)
			list.add(a[level][i]);
		
		for (int i = level; i < N - level - 1; i++)
			list.add(a[i][N-level-1]);
		
		for (int i = N - level - 1; i > level ; i--)
			list.add(a[N-level-1][i]);
		
		for (int i = N - level -1; i > level; i--)
			list.add(a[i][level]);
		
	}
	
	public List<Integer> spiralOrder(int[][] a) {
        //write your code here
		
		List<Integer> list = new LinkedList<Integer>();
		for (int level = 0; level <= a.length/2; level++)
			spiral(a, level, list);
	
		return list;
		
	}
	
    public static void main(String[] args) {
    	final int N = 5;
		int [][]a = new int[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				a[i][j] = i * N + j + 1;
		
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++)
    			System.out.print(a[i][j] + ", ");
    		System.out.println("");
    	}  
    	MatrixSpiralOrder order = new MatrixSpiralOrder();
    	List<Integer> list = order.spiralOrder(a);
		
    	System.out.println("xxxxxxxxxxxxxxxxxx");
		
		
		
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++)
    			System.out.print(list.get(i*N+j) + ", ");
    		System.out.println("");
    	}    	
    	
    }
}
