package assignment7;

public class MyIndexOutOfBoundException extends Exception {

	private int lowerBound, upperBound, index;
	
	public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.index = index;
	}
	
	public String toString() {
		
		return String.format("Error Message: Index: %d, but Lower bound: %d, Upper bound: %d", 
				this.index, this.lowerBound, this.upperBound);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			throw new MyIndexOutOfBoundException(0, 9, 10);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
